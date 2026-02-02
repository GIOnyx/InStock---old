package com.android.handlers

import com.android.data.Allergens

interface AllergenHandler {
    fun getSelectedAllergens(): MutableSet<Allergens>
    fun addSelectedAllergen(allergen: Allergens)
    fun removeSelectedAllergen(allergen: Allergens)
    fun isAllergenSelected(allergen: Allergens): Boolean
}