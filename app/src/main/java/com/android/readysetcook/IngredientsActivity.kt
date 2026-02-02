package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.adapters.AllergenCategoryAdapter
import com.android.adapters.IngredientsListViewAdapter
import com.android.adapters.SelectedIngredientsAdapter
import com.android.data.Ingredients
import com.android.data.Allergens
import com.android.fragments.BaseActivity
import com.android.handlers.AppHandler
import com.android.lists.AllergenList
import com.android.handlers.UserHandler
import com.android.lists.IngredientList
import com.android.preferenceManager.UserPreferencesManager

class IngredientsActivity : BaseActivity() {
    private lateinit var appHandler: AppHandler
    private lateinit var ingredientAdapter: IngredientsListViewAdapter
    private lateinit var selectedIngredientsAdapter: SelectedIngredientsAdapter
    private lateinit var selectedIngredientsPanel: ConstraintLayout
    private lateinit var selectedIngredientsPanelOpener: RelativeLayout
    private lateinit var allergenPanel: ConstraintLayout
    private lateinit var allergenListView: ListView
    private var isShowingCategories = true
    private var headerView: View? = null
    private var headerText: TextView? = null

    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        appHandler = application as AppHandler

        selectedIngredientsPanel = findViewById(R.id.selected_ingredients_panel)
        selectedIngredientsPanelOpener = findViewById(R.id.selected_ingredients_panel_opener)
        allergenPanel = findViewById(R.id.allergen_filter_panel)
        allergenListView = findViewById(R.id.allergen_listview)
        val selectedIngredientsGrid = findViewById<ListView>(R.id.selected_ingredient_listview)
        val ingredientListView = findViewById<ListView>(R.id.ingredient_listview)
        val hideSelectedButton = findViewById<LinearLayout>(R.id.hide_selected_button)
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val allergenButton = findViewById<ImageView>(R.id.allergen_button)
        val allergenBack = findViewById<ImageView>(R.id.allergen_back)
        val searchBar = findViewById<EditText>(R.id.search_bar)

        val ingredientCategoryTextView = findViewById<TextView>(R.id.ingredient_category_name)
        val applyAllergenFilterButton = findViewById<Button>(R.id.allergen_filter_button)
        val generateRecipeButton = findViewById<Button>(R.id.generate_recipe_button)

        val userPreferences = UserPreferencesManager(this)
        val currentEmail = userPreferences.getLoggedInEmail()
        val savedAllergens = currentEmail?.let { userPreferences.getUserAllergens(it) }

        if (!savedAllergens.isNullOrEmpty()) {
            val matchedAllergens = AllergenList.listOfAllergensCategory
                .filter { it.name in savedAllergens }

            appHandler.setSelectedAllergens(matchedAllergens.toMutableList())
        }


        generateRecipeButton.setOnClickListener {
            val selectedIngredients = appHandler.getSelectedIngredients()
            val selectedAllergens = appHandler.getSelectedAllergens()

            if (selectedIngredients.isEmpty()) {
                Toast.makeText(this, "Please select ingredients first!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ingredientNames = selectedIngredients.map { it.name }
            val allergenNames = selectedAllergens.map { it.name }

            val intent = Intent(this, RecipeOverviewActivity::class.java)
            intent.putStringArrayListExtra("selected_ingredients", ArrayList(ingredientNames))
            intent.putStringArrayListExtra("selected_allergens", ArrayList(allergenNames))

            startActivity(intent)
        }

        val ingredientCategoryName = intent.getStringExtra("ingredient_category_name") ?: "Unknown"
        ingredientCategoryTextView.text = ingredientCategoryName

        val ingredientList: MutableList<Ingredients> = if (ingredientCategoryName != "Unknown") {
            IngredientList.listOfIngredientCategory.firstOrNull { it.categoryName == ingredientCategoryName }?.ingredients?.toMutableList()
                ?: mutableListOf()
        } else {
            appHandler.getAllIngredients()
        }

        ingredientAdapter = IngredientsListViewAdapter(this, ingredientList) { clickedIngredient, _ ->
            clickedIngredient.isSelected = !clickedIngredient.isSelected
            if (clickedIngredient.isSelected) {
                appHandler.addSelectedIngredient(clickedIngredient)
            } else {
                appHandler.removeSelectedIngredient(clickedIngredient)
            }
            refreshAllAdapters()
            updateIngredientImportance()
        }
        ingredientListView.adapter = ingredientAdapter

        selectedIngredientsAdapter = SelectedIngredientsAdapter(
            this,
            ArrayList(appHandler.getSelectedIngredients()),
            { ingredient ->
                appHandler.getIngredientByName(ingredient.name)?.isSelected = false
                appHandler.removeSelectedIngredient(ingredient)
                refreshAllAdapters()
                updateIngredientImportance()
            }
        )
        selectedIngredientsGrid.adapter = selectedIngredientsAdapter


        val allergenAdapter = AllergenCategoryAdapter(this, AllergenList.listOfAllergensCategory) { selectedCategory -> }
        allergenListView.adapter = allergenAdapter

        val screenHeight = Resources.getSystem().displayMetrics.heightPixels
        selectedIngredientsPanel.layoutParams.height = (screenHeight * 0.65).toInt()

        backArrow.setOnClickListener { finish() }

        hideSelectedButton.setOnClickListener {
            selectedIngredientsPanel.animate()
                .translationY(selectedIngredientsPanel.height.toFloat())
                .setDuration(300)
                .withEndAction { selectedIngredientsPanel.visibility = View.GONE }
                .start()
        }
        selectedIngredientsPanelOpener.setOnClickListener {
            if (appHandler.getSelectedIngredients().isNotEmpty()) {
                selectedIngredientsPanel.visibility =
                    if (selectedIngredientsPanel.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                if (selectedIngredientsPanel.visibility == View.VISIBLE) {
                    selectedIngredientsPanel.translationY = selectedIngredientsPanel.height.toFloat()
                    selectedIngredientsPanel.animate()
                        .translationY(0f)
                        .setDuration(300)
                        .start()
                } else {
                    selectedIngredientsPanel.animate()
                        .translationY(selectedIngredientsPanel.height.toFloat())
                        .setDuration(300)
                        .start()
                }
                updateSelectedIngredientsPanel()
            } else {
                Toast.makeText(this, "No ingredients selected", Toast.LENGTH_SHORT).show()
            }
        }

        allergenButton.setOnClickListener {
            allergenPanel.visibility = View.VISIBLE
            allergenPanel.translationX = allergenPanel.width.toFloat()
            allergenPanel.animate()
                .translationX(0f)
                .setDuration(300)
                .start()
        }
        allergenBack.setOnClickListener {
            if (!isShowingCategories) {
                allergenListView.adapter = allergenAdapter
                headerView?.let { allergenListView.removeHeaderView(it) }
                headerView = null
                headerText = null
                isShowingCategories = true
            } else {
                allergenPanel.animate()
                    .translationX(allergenPanel.width.toFloat())
                    .setDuration(300)
                    .withEndAction { allergenPanel.visibility = View.GONE }
                    .start()
            }
        }

        applyAllergenFilterButton.setOnClickListener {
            applyAllergenFiltering()
            (allergenListView.adapter as AllergenCategoryAdapter).setSelectedCategories(
                appHandler.getSelectedAllergens()
            )

            ingredientAdapter.notifyDataSetChanged()
            selectedIngredientsAdapter.notifyDataSetChanged()
            currentEmail?.let {
                val selectedAllergenNames = appHandler.getSelectedAllergens().map { allergen -> allergen.name }
                userPreferences.saveUserAllergens(it, selectedAllergenNames)
            }


            allergenPanel.animate()
                .translationX(allergenPanel.width.toFloat())
                .setDuration(300)
                .withEndAction { allergenPanel.visibility = View.GONE }
                .start()
        }

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                ingredientAdapter.filter(s.toString(), getIngredientsToExclude())
            }
            override fun afterTextChanged(s: Editable?) {}
        })


    }

    override fun onResume() {
        super.onResume()

        val activeAllergens = appHandler.getSelectedAllergens().map { it.name }.toSet()
        ingredientAdapter.filter("", activeAllergens)
        ingredientAdapter.notifyDataSetChanged()
        overridePendingTransition(0, 0)
    }

    private fun updateSelectedIngredientsPanel() {
        selectedIngredientsAdapter.updateIngredients(ArrayList(appHandler.getSelectedIngredients()))
    }

    private fun updateIngredientImportance() {
        val totalImportance = appHandler.getSelectedIngredients().sumOf { it.importance }
        println("Total Importance: $totalImportance")
    }

    private fun getIngredientsToExclude(): Set<String> {
        return appHandler.getSelectedAllergens().map { it.name }.toSet()
    }

    private fun applyAllergenFiltering() {
        val allergenNames = appHandler.getSelectedAllergens().map { it.name }.toSet()
        appHandler.clearIncompatibleSelections(allergenNames)
        ingredientAdapter.filter("", allergenNames)
        refreshAllAdapters()
        Toast.makeText(
            this,
            "Filtered out allergens: ${allergenNames.joinToString()}",
            Toast.LENGTH_SHORT
        ).show()
    }


    private fun refreshAllAdapters() {
        selectedIngredientsAdapter.updateIngredients(ArrayList(appHandler.getSelectedIngredients()))
        ingredientAdapter.notifyDataSetChanged()
        selectedIngredientsAdapter.notifyDataSetChanged()

        if (appHandler.getSelectedIngredients().isEmpty()) {
            selectedIngredientsPanel.visibility = View.GONE
        }
    }


}
