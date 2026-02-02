package com.android.readysetcook

import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.android.fragments.BaseActivity
import com.android.handlers.UserHandler
import com.android.preferenceManager.RecipePreferencesManager
import com.android.preferenceManager.UserPreferencesManager

class RecipeFullViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_full_view)

        val backArrow = findViewById<ImageView>(R.id.back_arrow)


        val recipeName = intent.getStringExtra("recipe_name") ?: "Recipe Name"
        val recipeDescription = intent.getStringExtra("recipe_description") ?: ""
        val recipeCookTime = intent.getIntExtra("recipe_cooktime", 0)
        val recipeIngredients = intent.getStringArrayListExtra("recipe_ingredients") ?: arrayListOf()
        val recipeMeasurements = intent.getStringArrayListExtra("recipe_measurements") ?: arrayListOf()
        val recipeInstructions = intent.getStringArrayListExtra("recipe_instructions") ?: arrayListOf()
        val recipePhotoRes = intent.getIntExtra("recipe_photoRes", -1)

        val recipeNameTextView = findViewById<TextView>(R.id.recipe_name)
        val cooktimeTextView = findViewById<TextView>(R.id.cooktime)
        val ingredientsTextView = findViewById<TextView>(R.id.ingredients)
        val stepsTextView = findViewById<TextView>(R.id.steps)
        val recipeImageView = findViewById<ImageView>(R.id.recipe_image)
        val heartIndicator = findViewById<ImageView>(R.id.heart_icon)
        val userEmail = UserPreferencesManager(this).getLoggedInEmail() ?: ""
        val recipePreferencesManager = RecipePreferencesManager(this, userEmail)

        val recipeIdString = intent.getStringExtra("recipe_id") ?: "-1"
        val recipeIdInt = recipeIdString.toIntOrNull() ?: -1

        var isFavorite = recipePreferencesManager.isFavorite(recipeIdInt)
        heartIndicator.setImageResource(if (isFavorite) R.drawable.heart_red else R.drawable.heart_grey)

        heartIndicator.setOnClickListener {
            isFavorite = !isFavorite
            if (isFavorite) {
                recipePreferencesManager.addFavorite(recipeIdInt)
                heartIndicator.setImageResource(R.drawable.heart_red)
            } else {
                recipePreferencesManager.removeFavorite(recipeIdInt)
                heartIndicator.setImageResource(R.drawable.heart_grey)
            }
        }

        backArrow.setOnClickListener { finish() }

        recipeNameTextView.text = recipeName
        cooktimeTextView.text = "Cooking Time: $recipeCookTime min"

        ingredientsTextView.text = recipeIngredients.mapIndexed { index, ingredient ->
            val measurement = if (index < recipeMeasurements.size) recipeMeasurements[index] else ""
            "• $ingredient ${if (measurement.isNotBlank()) "($measurement)" else ""}"
        }.joinToString(separator = "\n")

        stepsTextView.text = Html.fromHtml(
            recipeInstructions.mapIndexed { index, instruction ->
                "<b>Step ${index + 1}:</b><br/>&nbsp;&nbsp;&nbsp;&nbsp;$instruction"
            }.joinToString(separator = "<br/><br/>"),
            Html.FROM_HTML_MODE_LEGACY
        )

        if (recipePhotoRes != -1) {
            recipeImageView.setImageResource(recipePhotoRes)
        }

        backArrow.setOnClickListener { finish() }

    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(0, 0)
    }
}