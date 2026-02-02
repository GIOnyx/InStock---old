package com.android.data

data class Ingredients(
    val imageRes: Int,
    val name: String,
    val allergens: List<String> = emptyList(),
    val variants: List<String> = emptyList(),
    var isSelected: Boolean = false,
    val importance: Int = 1
)
