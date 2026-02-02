package com.android.adapters

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.data.Recipes
import com.android.preferenceManager.RecipePreferencesManager
import com.android.readysetcook.R

class FavoritesAdapter(
    val context: Context,
    private var favoritesList: MutableList<Recipes>,
    private val recipePreferencesManager: RecipePreferencesManager,
    private val onRecipeClick: (recipe: Recipes, position: Int) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = Math.ceil(favoritesList.size / 3.0).toInt()

    override fun getItem(position: Int): Any = favoritesList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.favorites_list_layout, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val index1 = position * 3
        val index2 = index1 + 1
        val index3 = index1 + 2

        bindRecipe(holder.container1, holder.image1, holder.name1, index1)
        bindRecipe(holder.container2, holder.image2, holder.name2, index2)
        bindRecipe(holder.container3, holder.image3, holder.name3, index3)

        return view
    }

    private fun bindRecipe(
        container: LinearLayout,
        image: ImageView,
        name: TextView,
        index: Int
    ) {
        if (index < favoritesList.size) {
            val recipe = favoritesList[index]
            container.visibility = View.VISIBLE
            name.text = recipe.name
            recipe.photoRes?.let {
                image.setImageResource(it)
            } ?: image.setImageResource(R.drawable.dill)

            container.setOnClickListener {
                onRecipeClick(recipe, index)
            }

            container.setOnLongClickListener {
                AlertDialog.Builder(context)
                    .setTitle("Remove from Favorites")
                    .setMessage("Are you sure you want to remove \"${recipe.name}\" from your favorites?")
                    .setPositiveButton("Yes") { _, _ ->
                        recipe.isFavorite = false
                        recipePreferencesManager.removeFavorite(recipe.id.toIntOrNull() ?: return@setPositiveButton)
                        favoritesList.removeAt(index)
                        notifyDataSetChanged()

                        Toast.makeText(context, "${recipe.name} Successfully Removed From Favorites", Toast.LENGTH_SHORT).show()
                    }

                    .setNegativeButton("Cancel", null)
                    .show()
                true
            }
        } else {
            container.visibility = View.INVISIBLE
        }
    }

    fun updateFavorites(newFavoritesList: List<Recipes>) {
        favoritesList = newFavoritesList.toMutableList()
        notifyDataSetChanged()
    }



    private class ViewHolder(view: View) {
        val container1: LinearLayout = view.findViewById(R.id.favorite_container_1)
        val container2: LinearLayout = view.findViewById(R.id.favorite_container_2)
        val container3: LinearLayout = view.findViewById(R.id.favorite_container_3)

        val image1: ImageView = view.findViewById(R.id.favorite_image_1)
        val name1: TextView = view.findViewById(R.id.favorite_name_1)

        val image2: ImageView = view.findViewById(R.id.favorite_image_2)
        val name2: TextView = view.findViewById(R.id.favorite_name_2)

        val image3: ImageView = view.findViewById(R.id.favorite_image_3)
        val name3: TextView = view.findViewById(R.id.favorite_name_3)
    }
}
