package com.android.handlers

import com.android.data.Ingredients

interface IngredientHandler {
    fun getSelectedIngredients(): MutableSet<Ingredients>
    fun addSelectedIngredient(ingredient: Ingredients)
    fun removeSelectedIngredient(ingredient: Ingredients)
    fun isIngredientSelected(ingredient: Ingredients): Boolean
}