package com.android.data

data class User(
    val email: String,
    val password: String,
    val fullName: String,
    val phoneNumber: String? = null,
    val imageUri: String? = null
)