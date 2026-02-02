package com.android.readysetcook

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.handlers.UserHandler
import com.android.preferenceManager.UserPreferencesManager

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fullName = findViewById<EditText>(R.id.fullName)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val createAccount = findViewById<Button>(R.id.createAccount)

        createAccount.setOnClickListener {
            val fullNameText = fullName.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()
            val confirmPasswordText = confirmPassword.text.toString().trim()

            if (fullNameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty() || confirmPasswordText.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (!emailText.contains("@gmail.com")) {
                Toast.makeText(this, "Invalid email! Must contain '@gmail.com'", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (passwordText != confirmPasswordText) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val userPreferencesManager = UserPreferencesManager(applicationContext)
            
            // Check if email already exists
            if (userPreferencesManager.getUserData(emailText) != null) {
                Toast.makeText(this, "Email is already in use", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val firstName = fullNameText.split(" ")[0]
            userPreferencesManager.saveUserData(emailText, passwordText, fullNameText)

            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
        }
    }
}
