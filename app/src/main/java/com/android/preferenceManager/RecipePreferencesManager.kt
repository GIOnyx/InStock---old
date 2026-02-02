package com.android.preferenceManager

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class RecipePreferencesManager(context: Context, private val userEmail: String) {
    private val prefs: SharedPreferences = context.getSharedPreferences("FavoriteRecipes", Context.MODE_PRIVATE)

    private fun getKey(): String = "${userEmail}_favorites"

    fun getFavoriteIds(): Set<Int> {
        val favoriteIds = prefs.getStringSet(getKey(), emptySet())!!
            .mapNotNull { it.toIntOrNull() }
            .toSet()
        return favoriteIds
    }

    fun isFavorite(id: Int): Boolean = getFavoriteIds().contains(id)

    fun addFavorite(id: Int) {
        val current = getFavoriteIds().toMutableSet()
        current.add(id)
        save(current)
    }

    fun removeFavorite(id: Int) {
        val current = getFavoriteIds().toMutableSet()
        current.remove(id)
        save(current)
    }

    private fun save(set: Set<Int>) {
        prefs.edit().putStringSet(getKey(), set.map { it.toString() }.toSet()).apply()
    }
}
