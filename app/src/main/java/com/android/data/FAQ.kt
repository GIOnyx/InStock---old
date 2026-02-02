package com.android.data

data class FAQ(
    val question: String,
    val answer: String,
    var isExpanded: Boolean = false
)