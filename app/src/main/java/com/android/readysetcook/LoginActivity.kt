package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.handlers.UserHandler
import com.android.preferenceManager.RecipePreferencesManager
import com.android.preferenceManager.UserPreferencesManager

class LoginActivity : Activity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var createAccount: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        createAccount = findViewById(R.id.createAccount)

        val userEmail = UserPreferencesManager(this).getLoggedInEmail() ?: ""
        val recipePreferencesManager = RecipePreferencesManager(this, userEmail)

        if (userEmail == null) {
            Toast.makeText(this, "No user logged in", Toast.LENGTH_SHORT).show()
            finish()
            return
        }


        login.setOnClickListener {
            val enteredEmail = email.text.toString().trim()
            val enteredPassword = password.text.toString().trim()

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val userPreferencesManager = UserPreferencesManager(applicationContext)
            val storedUser = userPreferencesManager.getUserData(enteredEmail)

            if (storedUser != null && storedUser.password == enteredPassword) {
                val pref = UserPreferencesManager(applicationContext)
                pref.saveLoggedInEmail(enteredEmail)
                val profileIntent = Intent(this, IngredientCategoryActivity::class.java)
                profileIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(profileIntent)
                Toast.makeText(this, "Welcome back!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_LONG).show()
            }
        }

        createAccount.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }
}
