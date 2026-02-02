package com.android.data

import com.android.readysetcook.R


data class Recipes(
    val id: String,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val measurements: List<String>,
    val instructions: List<String>,
    val ingredientWeights: List<Double>,
    val cookingTime: Int,
    val allergenInfo: List<String>,
    val photoRes: Int? = null,
    var isFavorite: Boolean = false
)







