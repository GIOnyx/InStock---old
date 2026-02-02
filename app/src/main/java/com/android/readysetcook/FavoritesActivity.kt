package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import com.android.adapters.FavoritesAdapter
import com.android.data.Recipes
import com.android.fragments.BaseActivity
import com.android.lists.RecipeList
import com.android.preferenceManager.RecipePreferencesManager
import com.android.preferenceManager.UserPreferencesManager

class FavoritesActivity : BaseActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var recipePreferencesManager: RecipePreferencesManager
    private lateinit var recipeGridView: ListView
    private lateinit var favoriteAdapter: FavoritesAdapter
    private lateinit var searchBar: EditText

    private val favoritesList: MutableList<Recipes> = mutableListOf()
    private var allFavorites: List<Recipes> = listOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE)
        val userEmail = UserPreferencesManager(this).getLoggedInEmail() ?: ""
        recipePreferencesManager = RecipePreferencesManager(this, userEmail)

        recipeGridView = findViewById(R.id.fav_listview)
        searchBar = findViewById(R.id.search_bar)

        findViewById<ImageView>(R.id.back_arrow).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.menu_button).setOnClickListener {
            startActivity(Intent(this, SettingsPageActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.ingredients_button).setOnClickListener {
            startActivity(Intent(this, IngredientCategoryActivity::class.java))
        }

        loadFavorites()

        favoriteAdapter = FavoritesAdapter(this, favoritesList, recipePreferencesManager) { recipe, _ ->
            val intent = Intent(this, RecipeFullViewActivity::class.java)
            intent.putExtra("recipe_id", recipe.id)
            intent.putExtra("recipe_name", recipe.name)
            intent.putExtra("recipe_description", recipe.description)
            intent.putExtra("recipe_cooktime", recipe.cookingTime)
            intent.putStringArrayListExtra("recipe_ingredients", ArrayList(recipe.ingredients))
            intent.putStringArrayListExtra("recipe_instructions", ArrayList(recipe.instructions))
            intent.putExtra("recipe_photoRes", recipe.photoRes ?: -1)
            startActivity(intent)
        }

        recipeGridView.adapter = favoriteAdapter

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim().lowercase()
                val filtered = allFavorites.filter { recipe ->
                    recipe.name.lowercase().contains(query)
                }

                favoriteAdapter.updateFavorites(filtered)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

    }

    override fun onResume() {
        super.onResume()
        loadFavorites()
        favoriteAdapter.updateFavorites(favoritesList)
        overridePendingTransition(0, 0)
    }

    private fun loadFavorites() {
        val allRecipes = RecipeList.recipes
        val favoriteIds = recipePreferencesManager.getFavoriteIds()
        Log.d("FavoritesActivity", "Favorite IDs: $favoriteIds")
        favoritesList.clear()

        for (recipe in allRecipes) {
            val recipeIdInt = recipe.id.toIntOrNull()
            val isFavorite = recipeIdInt != null && favoriteIds.contains(recipeIdInt)
            Log.d("FavoritesActivity", "Recipe ID: ${recipe.id}, is favorite: $isFavorite")

            if (isFavorite) {
                favoritesList.add(recipe)
            }
        }

        allFavorites = favoritesList.toList()
    }
}
