package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.android.adapters.RecipeOverviewAdapter
import com.android.data.Recipes
import com.android.fragments.BaseActivity
import com.android.handlers.AppHandler
import com.android.handlers.UserHandler
import com.android.lists.RecipeList

class RecipeOverviewActivity : BaseActivity() {

    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeOverviewAdapter: RecipeOverviewAdapter
    private lateinit var recipeList: List<Recipes>
    private lateinit var appHandler: AppHandler
    private lateinit var allFilteredRecipes: List<Pair<Recipes, Double>>

    private lateinit var snapHelper: LinearSnapHelper
    private lateinit var pageIndicator: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_overview)

        appHandler = application as AppHandler

        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val menuButton = findViewById<ImageView>(R.id.menu_button)
        pageIndicator = findViewById(R.id.item_num_indicator)

        backArrow.setOnClickListener { finish() }
        menuButton.setOnClickListener {
            val intent = Intent(this, SettingsPageActivity::class.java)
            startActivity(intent)
        }


        recipeRecyclerView = findViewById(R.id.recycler_view)
        recipeList = RecipeList.recipes

        val selectedIngredients = intent.getStringArrayListExtra("selected_ingredients") ?: arrayListOf()
        val selectedAllergens = intent.getStringArrayListExtra("selected_allergens") ?: arrayListOf()
        val cookNowBtn =  findViewById<Button>(R.id.cook_now_button)

        val filteredRecipesWithMatch: List<Pair<Recipes, Double>> = if (selectedIngredients.isEmpty() && selectedAllergens.isEmpty()) {
            recipeList.map { it to 100.0 }
        } else {
            recipeList.mapNotNull { recipe ->
                val recipeIngredients = recipe.ingredients
                val recipeAllergens = recipe.allergenInfo
                val ingredientWeights = recipe.ingredientWeights

                var weightedMatch = 0.0
                var totalWeight = 0.0

                recipeIngredients.forEachIndexed { index, ingredient ->
                    val matchFound = selectedIngredients.any { selectedIngredientName ->
                        val selectedIngredient = appHandler.getIngredientByName(selectedIngredientName)
                        selectedIngredient?.name.equals(ingredient, ignoreCase = true) ||
                                (selectedIngredient?.variants?.any { variant ->
                                    variant.equals(ingredient, ignoreCase = true)
                                } ?: false)
                    }

                    if (matchFound) {
                        weightedMatch += ingredientWeights.getOrElse(index) { 0.0 }
                    }
                    totalWeight += ingredientWeights.getOrElse(index) { 0.0 }
                }

                val matchPercentage = if (totalWeight > 0) {
                    (weightedMatch / totalWeight) * 100
                } else {
                    0.0
                }

                val containsNoneOfSelectedAllergens = recipeAllergens.none { recipeAllergen ->
                    selectedAllergens.any { it.equals(recipeAllergen, ignoreCase = true) }
                }

                if (matchPercentage >= 60 && containsNoneOfSelectedAllergens) {
                    recipe to matchPercentage
                } else {
                    null
                }
            }.sortedByDescending { it.second }
        }

        val noRecipeTextView = findViewById<TextView>(R.id.no_recipe_text_view)
        if (filteredRecipesWithMatch.isEmpty()) {
            noRecipeTextView.visibility = View.VISIBLE
            recipeRecyclerView.visibility = View.GONE
            pageIndicator.visibility=View.GONE
        } else {
            noRecipeTextView.visibility = View.GONE
            recipeRecyclerView.visibility = View.VISIBLE
        }

        recipeOverviewAdapter = RecipeOverviewAdapter(
            filteredRecipesWithMatch,
            onFavoriteClick = { recipe: Recipes ->
            }
        )

        snapHelper = LinearSnapHelper().apply { attachToRecyclerView(recipeRecyclerView) }
        recipeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recipeRecyclerView.adapter = recipeOverviewAdapter

        recipeRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    updatePageIndicator()
                }
            }
        })

        updatePageIndicator()

        val searchBar = findViewById<EditText>(R.id.search_bar)

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim().lowercase()
                val filtered = allFilteredRecipes.filter { (recipe, _) ->
                    recipe.name.lowercase().contains(query)
                }

                if (filtered.isEmpty()) {
                    noRecipeTextView.visibility = View.VISIBLE
                    recipeRecyclerView.visibility = View.GONE
                    pageIndicator.visibility = View.GONE
                } else {
                    noRecipeTextView.visibility = View.GONE
                    recipeRecyclerView.visibility = View.VISIBLE
                    pageIndicator.visibility = View.VISIBLE
                }

                recipeOverviewAdapter.updateList(filtered)
                updatePageIndicator()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        allFilteredRecipes = filteredRecipesWithMatch

    }

    override fun onResume() {
        super.onResume()
    }

    private fun updatePageIndicator() {
        val layoutManager = recipeRecyclerView.layoutManager as LinearLayoutManager
        val snapView = snapHelper.findSnapView(layoutManager)
        val position = if (snapView != null) layoutManager.getPosition(snapView) else 0
        val total = recipeOverviewAdapter.itemCount
        pageIndicator.text = "${position + 1} of $total"
    }
}