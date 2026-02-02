package com.android.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.preferenceManager.UserPreferencesManager
import com.android.readysetcook.*
import java.io.File

open class BaseActivity : AppCompatActivity() {

    override fun setContentView(layoutResID: Int) {
        val fullLayout = layoutInflater.inflate(R.layout.header_footer_fragment, null)
        val contentContainer = fullLayout.findViewById<FrameLayout>(R.id.content_container)

        layoutInflater.inflate(layoutResID, contentContainer, true)
        super.setContentView(fullLayout)

        setupHeader()
        setupFooterNavigation()
    }

    private fun setupHeader() {
        val usernameTextView = findViewById<TextView>(R.id.username)
        val menuButton = findViewById<ImageView>(R.id.menu_button)
        val profileButton = findViewById<LinearLayout>(R.id.profile_button)
        val profileImageView = findViewById<ImageView>(R.id.profile_image)

        val sharedPrefs = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val loggedInEmail = sharedPrefs.getString("logged_in_user_email", null)

        if (loggedInEmail != null) {
            val userPrefsManager = UserPreferencesManager(this)
            val firstName = userPrefsManager.getFirstName(loggedInEmail)

            val displayName = firstName ?: "Guest"
            usernameTextView.text = "Hey, $displayName!"
            usernameTextView.visibility = View.VISIBLE

            // Load profile image if exists
            val imageUri = userPrefsManager.getUserData(loggedInEmail)?.imageUri
            if (!imageUri.isNullOrEmpty()) {
                val file = File(imageUri)
                if (file.exists()) {
                    profileImageView.setImageURI(Uri.fromFile(file))
                } else {
                    profileImageView.setImageResource(R.drawable.default_profile)
                }
            } else {
                profileImageView.setImageResource(R.drawable.default_profile)
            }
        } else {
            usernameTextView.text = "Hey, Guest!"
            profileImageView.setImageResource(R.drawable.default_profile)
        }

        menuButton?.setOnClickListener {
            startActivity(Intent(this, SettingsPageActivity::class.java))
        }

        profileButton?.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        setupHeader()
    }

    private fun setupFooterNavigation() {
        val cookButton = findViewById<LinearLayout?>(R.id.cooking_button)
        val ingredientsButton = findViewById<LinearLayout?>(R.id.ingredients_button)
        val favoritesButton = findViewById<LinearLayout?>(R.id.favorites_button)

        if (cookButton == null || ingredientsButton == null || favoritesButton == null) return

        val allButtons = listOf(cookButton, ingredientsButton, favoritesButton)

        fun setActiveButton(active: LinearLayout) {
            allButtons.forEach { it.alpha = if (it == active) 1f else 0.5f }
        }

        val currentTab = when (this::class.java.simpleName) {
            "RecipeOverviewActivity", "RecipeFullViewActivity" -> "cook"
            "IngredientCategoryActivity", "IngredientsActivity" -> "ingredients"
            "HistoryActivity" -> "history"
            "FavoritesActivity" -> "favorites"
            else -> null
        }

        when (currentTab) {
            "cook" -> setActiveButton(cookButton)
            "ingredients" -> setActiveButton(ingredientsButton)
            "favorites" -> setActiveButton(favoritesButton)
        }

        cookButton.setOnClickListener {
            if (currentTab != "cook") {
                startActivity(Intent(this, RecipeOverviewActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }

        ingredientsButton.setOnClickListener {
            if (currentTab != "ingredients") {
                startActivity(Intent(this, IngredientCategoryActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }

        favoritesButton.setOnClickListener {
            if (currentTab != "favorites") {
                startActivity(Intent(this, FavoritesActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }
    }
}