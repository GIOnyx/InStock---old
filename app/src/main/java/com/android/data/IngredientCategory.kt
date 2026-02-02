package com.android.data

import com.android.readysetcook.R

data class IngredientCategory(
    val id: Int,
    val categoryName: String,
    val ingredients: List<Ingredients>
)