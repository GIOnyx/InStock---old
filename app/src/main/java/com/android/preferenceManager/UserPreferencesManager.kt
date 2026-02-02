package com.android.preferenceManager

import android.content.Context
import android.content.SharedPreferences
import com.android.data.User

class UserPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)

    fun saveUserData(email: String, password: String, fullName: String, phoneNumber: String? = null, imageUri: String? = null) {
        val editor = sharedPreferences.edit()
        editor.putString("${email}_email", email)
        editor.putString("${email}_password", password)
        editor.putString("${email}_full_name", fullName)
        editor.putString("${email}_phone_number", phoneNumber)
        editor.putString("${email}_image_uri", imageUri)
        editor.apply()
    }

    fun getUserData(email: String): User? {
        val storedEmail = sharedPreferences.getString("${email}_email", null)
        val storedPassword = sharedPreferences.getString("${email}_password", null)
        val storedFullName = sharedPreferences.getString("${email}_full_name", null)
        val storedPhoneNumber = sharedPreferences.getString("${email}_phone_number", null)
        val storedImageUri = sharedPreferences.getString("${email}_image_uri", null)

        return if (storedEmail != null && storedPassword != null && storedFullName != null) {
            User(storedEmail, storedPassword, storedFullName, storedPhoneNumber, storedImageUri)
        } else {
            null
        }
    }

    fun saveLoggedInEmail(email: String) {
        val editor = sharedPreferences.edit()
        editor.putString("logged_in_user_email", email)
        editor.apply()
    }

    fun getFirstName(email: String): String? {
        val fullName = sharedPreferences.getString("${email}_full_name", null)
        return fullName?.split(" ")?.firstOrNull()
    }

    fun getLoggedInEmail(): String? {
        return sharedPreferences.getString("logged_in_user_email", null)
    }

    fun clearUserData(email: String) {
        val editor = sharedPreferences.edit()
        editor.remove("${email}_email")
        editor.remove("${email}_password")
        editor.remove("${email}_full_name")
        editor.remove("${email}_phone_number")
        editor.remove("${email}_image_uri")
        editor.apply()
    }

    fun clearLoggedInState() {
        val editor = sharedPreferences.edit()
        editor.remove("logged_in_user_email")
        editor.apply()
    }

    fun saveUserAllergens(email: String, allergens: List<String>) {
        val editor = sharedPreferences.edit()
        editor.putStringSet("${email}_allergens", allergens.toSet())
        editor.apply()
    }

    fun getUserAllergens(email: String): Set<String> {
        return sharedPreferences.getStringSet("${email}_allergens", emptySet()) ?: emptySet()
    }

}