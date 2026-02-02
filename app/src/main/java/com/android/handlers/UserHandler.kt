package com.android.handlers

interface UserHandler {
    var fullName: String?
    var email: String?
    var firstName: String?
    var phoneNumber: String?
    var password: String?

    fun setName(fullName: String)
    fun getName(): String
    fun setFName(firstName: String)
    fun getFName(): String
    fun setAddress(email: String)
    fun getAddress(): String
    fun setPhone(phoneNumber: String)
    fun getPhone(): String
    fun setPass(password: String)
    fun getPass(): String
}