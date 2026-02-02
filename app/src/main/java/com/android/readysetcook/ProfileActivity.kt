package com.android.readysetcook

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.preferenceManager.UserPreferencesManager
import com.android.data.User
import com.google.android.material.imageview.ShapeableImageView
import java.io.File
import java.io.FileOutputStream

class ProfileActivity : Activity() {
    private var isEditing = false
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var password: EditText
    private lateinit var profileImage: ShapeableImageView
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize profileImage first
        profileImage = findViewById(R.id.profile_image)

        // Other findViewById calls
        fullName = findViewById(R.id.fullName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        phoneNumber = findViewById(R.id.phoneNumber)
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val logout = findViewById<ImageView>(R.id.logout)
        val saveButton = findViewById<Button>(R.id.save_new_profile_button)
        val editProfile = findViewById<Button>(R.id.edit_profile)

        val pref = UserPreferencesManager(applicationContext)
        val loggedInEmail = pref.getLoggedInEmail()

        // Load saved user details
        if (loggedInEmail != null) {
            val user = pref.getUserData(loggedInEmail)
            if (user != null) {
                // Set text fields
                fullName.setText(user.fullName)
                email.setText(user.email)
                password.setText(user.password)
                phoneNumber.setText(user.phoneNumber)

                // Load saved profile image
                val imageUri = user.imageUri
                if (!imageUri.isNullOrEmpty()) {
                    try {
                        profileImage.setImageURI(Uri.parse(imageUri))
                        profileImage.tag = imageUri // Restore the tag
                    } catch (e: Exception) {
                        Toast.makeText(this, "Failed to load profile image", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    profileImage.setImageResource(R.drawable.default_profile) // Fallback to default image
                }
            }
        }

        saveButton.visibility = View.GONE
        setFieldsEditable(false)

        editProfile.setOnClickListener {
            isEditing = true
            setFieldsEditable(true)
            saveButton.visibility = View.VISIBLE
            editProfile.visibility = View.GONE
        }

        saveButton.setOnClickListener {
            val updatedFullName = fullName.text.toString()
            val updatedEmail = email.text.toString()
            val updatedPassword = password.text.toString()
            var updatedPhoneNumber = phoneNumber.text.toString()

            if (updatedPhoneNumber.isNotEmpty()) {
                if (!updatedPhoneNumber.startsWith("+63")) {
                    updatedPhoneNumber = "+63" + updatedPhoneNumber.removePrefix("0")
                }

                if (!updatedPhoneNumber.startsWith("+63") || updatedPhoneNumber.length !in 12..13) {
                    Toast.makeText(this, "Invalid phone number format! Use +63XXXXXXXXXX.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            if (!updatedEmail.contains("@gmail.com")) {
                Toast.makeText(this, "Invalid email! Must contain '@gmail.com'", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (loggedInEmail != null) {
                pref.clearUserData(loggedInEmail)
            }

            // Get the current profile image URI
            val imageUri = profileImage.tag as? String

            // Save all user data including the image URI
            pref.saveUserData(updatedEmail, updatedPassword, updatedFullName, updatedPhoneNumber, imageUri)
            pref.saveLoggedInEmail(updatedEmail)
            isEditing = false
            setFieldsEditable(false)
            saveButton.visibility = View.GONE
            editProfile.visibility = View.VISIBLE

            Toast.makeText(this, "Profile saved successfully!", Toast.LENGTH_SHORT).show()
        }

        backArrow.setOnClickListener {
            finish()
        }

        logout.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.custom_logout_dialog, null)
            val dialog = AlertDialog.Builder(this, R.style.CustomDialog)
                .setView(dialogView)
                .create()

            val btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)
            val btnLogout = dialogView.findViewById<Button>(R.id.btnLogout)

            btnCancel.setOnClickListener { dialog.dismiss() }
            btnLogout.setOnClickListener {
                if (loggedInEmail != null) {
                    pref.clearLoggedInState()
                }
                val logoutIntent = Intent(this, LoginActivity::class.java)
                logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(logoutIntent)
                finish()
            }

            dialog.show()
            dialog.window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        profileImage.setOnClickListener {
            if (isEditing) {
                openGallery()
            }
        }
    }

    private fun setFieldsEditable(editable: Boolean) {
        fullName.isFocusable = editable
        fullName.isFocusableInTouchMode = editable
        fullName.isEnabled = editable

        email.isFocusable = editable
        email.isFocusableInTouchMode = editable
        email.isEnabled = editable

        password.isFocusable = editable
        password.isFocusableInTouchMode = editable
        password.isEnabled = editable

        phoneNumber.isFocusable = editable
        phoneNumber.isFocusableInTouchMode = editable
        phoneNumber.isEnabled = editable
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    private fun deleteOldProfileImage(path: String?) {
        if (!path.isNullOrEmpty()) {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val selectedImageUri = data.data
            try {
                profileImage.setImageURI(selectedImageUri)

                val pref = UserPreferencesManager(this)
                val loggedInEmail = pref.getLoggedInEmail()

                // Delete the old image
                val oldImagePath = profileImage.tag as? String
                deleteOldProfileImage(oldImagePath)

                // Save the new image
                val savedImagePath = saveImageToInternalStorage(selectedImageUri!!, loggedInEmail ?: "default")
                profileImage.tag = savedImagePath

            } catch (e: Exception) {
                Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun saveImageToInternalStorage(uri: Uri, email: String): String? {
        return try {
            val inputStream = contentResolver.openInputStream(uri)
            val file = File(filesDir, "${email}_profile_image.jpg") // unique to each user
            val outputStream = FileOutputStream(file)

            inputStream?.copyTo(outputStream)

            inputStream?.close()
            outputStream.close()

            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}