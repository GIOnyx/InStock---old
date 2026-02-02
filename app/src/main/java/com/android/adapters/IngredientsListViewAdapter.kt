package com.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.data.Ingredients
import com.android.data.Allergens
import com.android.readysetcook.R
import com.android.handlers.AppHandler

class IngredientsListViewAdapter(
    val context: Context,
    private val originalList: MutableList<Ingredients>,
    val onItemClick: (ingredients: Ingredients, position: Int) -> Unit
) : BaseAdapter() {

    private var filteredList: List<Ingredients> = originalList
    private val appHandler = context.applicationContext as AppHandler

    override fun getCount(): Int = Math.ceil(filteredList.size / 3.0).toInt()

    override fun getItem(position: Int): Any = filteredList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.ingredients_list_layout, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val index1 = position * 3
        val index2 = index1 + 1
        val index3 = index1 + 2

        bindIngredient(holder.container1, holder.image1, holder.name1, holder.selectCircle1, index1)
        bindIngredient(holder.container2, holder.image2, holder.name2, holder.selectCircle2, index2)
        bindIngredient(holder.container3, holder.image3, holder.name3, holder.selectCircle3, index3)

        return view
    }

    private fun bindIngredient(
        container: LinearLayout,
        image: ImageView,
        name: TextView,
        selectCircle: ImageView,
        index: Int
    ) {
        if (index < filteredList.size) {
            val ingredient = filteredList[index]
            container.visibility = View.VISIBLE
            image.setImageResource(ingredient.imageRes)
            name.text = ingredient.name

            val circleRes = if (ingredient.isSelected) R.drawable.status_circle_green else R.drawable.status_circle_grey
            selectCircle.setImageResource(circleRes)
            container.setOnClickListener {
                ingredient.isSelected = !ingredient.isSelected
                if (ingredient.isSelected) {
                    appHandler.addSelectedIngredient(ingredient)
                } else {
                    appHandler.removeSelectedIngredient(ingredient)
                }

                notifyDataSetChanged()
            }
        } else {
            container.visibility = View.INVISIBLE
        }
    }


    fun filter(query: String, allergens: Set<String>) {
        filteredList = originalList.filter { ingredient ->
            val matchesQuery = query.isEmpty() || ingredient.name.contains(query, ignoreCase = true)

            val isAllowed = allergens.isEmpty() || ingredient.allergens.intersect(allergens).isEmpty()
            matchesQuery && isAllowed
        }
        notifyDataSetChanged()
    }

    fun updateIngredientSelection(name: String, isSelected: Boolean) {

        (originalList as? MutableList<Ingredients>)?.firstOrNull { it.name == name }?.isSelected = isSelected
        (filteredList as? MutableList<Ingredients>)?.firstOrNull { it.name == name }?.isSelected = isSelected
        notifyDataSetChanged()
    }

    fun updateFilteredList(newList: List<Ingredients>) {
        filteredList = newList
        notifyDataSetChanged()
    }

    fun filterByAllergens(allergens: Set<String>) {
        filteredList = originalList.filter { ingredient ->
            // Ensure that ingredient.allergens is a List<String>
            !ingredient.allergens.any { allergen ->
                allergens.contains(allergen)
            }
        }
        notifyDataSetChanged()
    }



    private class ViewHolder(view: View) {
        val container1: LinearLayout = view.findViewById(R.id.ingredient_container_1)
        val container2: LinearLayout = view.findViewById(R.id.ingredient_container_2)
        val container3: LinearLayout = view.findViewById(R.id.ingredient_container_3)

        val image1: ImageView = view.findViewById(R.id.ingredient_image_1)
        val name1: TextView = view.findViewById(R.id.ingredient_name_1)
        val selectCircle1: ImageView = view.findViewById(R.id.ingredient_select_circle_1)

        val image2: ImageView = view.findViewById(R.id.ingredient_image_2)
        val name2: TextView = view.findViewById(R.id.ingredient_name_2)
        val selectCircle2: ImageView = view.findViewById(R.id.ingredient_select_circle_2)

        val image3: ImageView = view.findViewById(R.id.ingredient_image_3)
        val name3: TextView = view.findViewById(R.id.ingredient_name_3)
        val selectCircle3: ImageView = view.findViewById(R.id.ingredient_select_circle_3)
    }
}
