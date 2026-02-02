package com.android.readysetcook

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.cardview.widget.CardView
import android.widget.TextView
import android.widget.Button

class PrivacySecurityActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_security)

        findViewById<ImageView>(R.id.back_arrow).setOnClickListener {
            finish()
        }

        findViewById<CardView>(R.id.data_privacy_card).setOnClickListener {
            showInfoDialog(
                "Data Privacy",
                "Data Storage\n\n" +
                        "All your recipe data and preferences are stored locally on your device. " +
                        "We do not collect or share any personal information with third parties.\n\n" +
                        "Data Control\n\n" +
                        "You have full control over your data. You can delete all stored information " +
                        "at any time through the app settings."
            )
        }

        findViewById<CardView>(R.id.app_permissions_card).setOnClickListener {
            showInfoDialog(
                "App Permissions",
                "Storage Permission\n\n" +
                        "Required to save your recipes and preferences locally.\n\n" +
                        "Camera Permission\n\n" +
                        "Optional: Only needed if you want to take photos of your recipes.\n\n" +
                        "Internet Permission\n\n" +
                        "Only used for recipe sharing features when enabled."
            )
        }

        findViewById<CardView>(R.id.security_settings_card).setOnClickListener {
            showInfoDialog(
                "Security Settings",
                "Data Encryption\n\n" +
                        "Your data is encrypted using industry-standard encryption protocols.\n\n" +
                        "Local Storage\n\n" +
                        "All sensitive information is stored securely on your device.\n\n" +
                        "Privacy Controls\n\n" +
                        "Customize your privacy settings and data sharing preferences."
            )
        }
    }

    private fun showInfoDialog(title: String, message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.privacy_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val displayMetrics = resources.displayMetrics
        val width = (displayMetrics.widthPixels * 0.9).toInt()
        dialog.window?.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)

        dialog.findViewById<TextView>(R.id.dialog_title).text = title
        dialog.findViewById<TextView>(R.id.dialog_content).text = message
        dialog.findViewById<Button>(R.id.dialog_ok_button).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}