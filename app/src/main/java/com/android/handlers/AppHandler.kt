package com.android.handlers

import android.app.Application
import com.android.data.Allergens
import com.android.data.Ingredients
import com.android.lists.IngredientList

class AppHandler : Application(), UserHandler, AllergenHandler, IngredientHandler {

    override var fullName: String? = null
    override var email: String? = null
    override var firstName: String? = null
    override var phoneNumber: String? = null
    override var password: String? = null

    override fun setName(fullName: String) {
        this.fullName = fullName
        this.firstName = fullName.split(" ").firstOrNull()
    }

    override fun getName(): String = fullName ?: ""
    override fun getFName(): String = firstName ?: fullName?.split(" ")?.firstOrNull() ?: "Guest"
    override fun setFName(firstName: String) { this.firstName = firstName }
    override fun setAddress(email: String) { this.email = email }
    override fun getAddress(): String = email ?: ""
    override fun setPhone(phoneNumber: String) { this.phoneNumber = phoneNumber }
    override fun getPhone(): String = phoneNumber ?: ""
    override fun setPass(password: String) { this.password = password }
    override fun getPass(): String = password ?: ""

    override fun onCreate() {
        super.onCreate()
        initializeIngredients()
    }

    private fun initializeIngredients() {
        allIngredients.clear()
        allIngredients.addAll(
            IngredientList.listOfIngredientCategory.flatMap { it.ingredients }
        )
    }

    fun getAllIngredients(): MutableList<Ingredients> {
        return allIngredients.ifEmpty {
            initializeIngredients()
            allIngredients
        }
    }

    private val selectedIngredients = mutableSetOf<Ingredients>()
    private val allIngredients: MutableList<Ingredients> = mutableListOf()

    override fun getSelectedIngredients(): MutableSet<Ingredients> = selectedIngredients

    override fun addSelectedIngredient(ingredient: Ingredients) {
        if (selectedIngredients.none { it.name == ingredient.name }) {
            selectedIngredients.add(ingredient)
        }
    }

    override fun removeSelectedIngredient(ingredient: Ingredients) {
        selectedIngredients.removeIf { it.name == ingredient.name }
    }

    override fun isIngredientSelected(ingredient: Ingredients): Boolean {
        return selectedIngredients.any { it.name == ingredient.name }
    }

    private val selectedAllergens = mutableSetOf<Allergens>()

    override fun getSelectedAllergens(): MutableSet<Allergens> = selectedAllergens

    override fun addSelectedAllergen(allergen: Allergens) {
        selectedAllergens.add(allergen)
    }

    override fun removeSelectedAllergen(allergen: Allergens) {
        selectedAllergens.remove(allergen)
    }

    override fun isAllergenSelected(allergen: Allergens): Boolean {
        return selectedAllergens.contains(allergen)
    }

    fun getIngredientByName(name: String): Ingredients? {
        return allIngredients.firstOrNull { it.name.equals(name, ignoreCase = true) }
    }

    fun setSelectedAllergens(allergens: List<Allergens>) {
        selectedAllergens.clear()
        selectedAllergens.addAll(allergens)
    }


    fun clearIncompatibleSelections(allergenNames: Set<String>) {
        val toRemove = selectedIngredients.filter { ingredient ->
            ingredient.allergens.any { allergen ->
                allergenNames.any { it.equals(allergen, ignoreCase = true) }
            }
        }.toSet()

        toRemove.forEach { ingredient ->
            ingredient.isSelected = false
            removeSelectedIngredient(ingredient)
        }
    }
}