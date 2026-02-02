package com.android.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.data.Recipes
import com.android.readysetcook.RecipeFullViewActivity
import com.android.readysetcook.R

class RecipeOverviewAdapter(
    private var recipeList: List<Pair<Recipes, Double>>,
    private val onFavoriteClick: (Recipes) -> Unit
) : RecyclerView.Adapter<RecipeOverviewAdapter.RecipeViewHolder>() {

    fun updateList(newList: List<Pair<Recipes, Double>>) {
        recipeList = newList
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeNameTextView: TextView = itemView.findViewById(R.id.recipe_name)
        val recipeDescriptionTextView: TextView = itemView.findViewById(R.id.description)
        val recipeCookTimeTextView: TextView = itemView.findViewById(R.id.cooktime)
        val recipeImageView: ImageView = itemView.findViewById(R.id.placeholder_image)
        val cookNowButton: Button = itemView.findViewById(R.id.cook_now_button)
        val matchPercentageTextView: TextView = itemView.findViewById(R.id.tvMatchPercentage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_overview_layout, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val (recipe, matchPercentage) = recipeList[position]

        holder.recipeNameTextView.text = recipe.name
        holder.recipeDescriptionTextView.text = recipe.description
        holder.recipeCookTimeTextView.text = "${recipe.cookingTime} min"
        holder.matchPercentageTextView.text = "${matchPercentage.toInt()}% Match"

        recipe.photoRes?.let {
            holder.recipeImageView.setImageResource(it)
        }

        holder.cookNowButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, RecipeFullViewActivity::class.java)
            intent.putExtra("recipe_id", recipe.id)
            intent.putExtra("recipe_name", recipe.name)
            intent.putExtra("recipe_description", recipe.description)
            intent.putExtra("recipe_cooktime", recipe.cookingTime)
            intent.putStringArrayListExtra("recipe_ingredients", ArrayList(recipe.ingredients))
            intent.putStringArrayListExtra("recipe_measurements", ArrayList(recipe.measurements))
            intent.putStringArrayListExtra("recipe_instructions", ArrayList(recipe.instructions))
            intent.putExtra("recipe_photoRes", recipe.photoRes ?: -1)
            context.startActivity(intent)
        }

        holder.recipeImageView.setOnClickListener {
            onFavoriteClick(recipe)
        }

        if (matchPercentage >= 100) {
            holder.matchPercentageTextView.setTextColor(holder.itemView.context.getColor(R.color.green))
            holder.matchPercentageTextView.text = "Perfect Match!"
        } else {
            holder.matchPercentageTextView.setTextColor(holder.itemView.context.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int = recipeList.size


}
