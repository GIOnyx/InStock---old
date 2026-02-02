package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.android.handlers.UserHandler
import com.android.preferenceManager.UserPreferencesManager

class SettingsPageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_page)

        val back_arrow = findViewById<ImageView>(R.id.back_arrow)
        val about = findViewById<LinearLayout>(R.id.about)
        val account = findViewById<LinearLayout>(R.id.account)
        val privacy = findViewById<LinearLayout>(R.id.privacy)
        val support = findViewById<LinearLayout>(R.id.support)
        val notification_switch = findViewById<Switch>(R.id.notification_switch)
        val dark_mode_switch = findViewById<Switch>(R.id.dark_mode_switch)

        dark_mode_switch.setOnClickListener {
            Toast.makeText(this, "Dark Mode Toggled", Toast.LENGTH_LONG).show()
        }

        notification_switch.setOnClickListener {
            Toast.makeText(this, "Notifications Toggled", Toast.LENGTH_LONG).show()
        }

        back_arrow.setOnClickListener {
            finish()
        }

        about.setOnClickListener {
            val aboutIntent = Intent(this, DeveloperActivity::class.java)
            startActivity(aboutIntent)
        }

        account.setOnClickListener {
            val userPreferencesManager = UserPreferencesManager(applicationContext)
            val receivedEmail = userPreferencesManager.getLoggedInEmail()

            if (!receivedEmail.isNullOrEmpty()) {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }


        privacy.setOnClickListener {
            try {
                val privacyIntent = Intent(this, PrivacySecurityActivity::class.java)
                startActivity(privacyIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        support.setOnClickListener {
            startActivity(Intent(this, HelpSupportActivity::class.java))
        }
    }
}
