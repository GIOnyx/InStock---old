package com.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.data.Ingredients
import com.android.readysetcook.R

class SelectedIngredientsAdapter(
    private val context: Context,
    private val ingredients: MutableList<Ingredients>,
    private val onItemClick: (Ingredients) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = Math.ceil(ingredients.size / 3.0).toInt()

    override fun getItem(position: Int): Any = ingredients[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.selected_ingredient_layout, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val index1 = position * 3
        val index2 = index1 + 1
        val index3 = index1 + 2

        bind(holder.container1, holder.image1, holder.name1,index1)
        bind(holder.container2, holder.image2, holder.name2,index2)
        bind(holder.container3, holder.image3, holder.name3, index3)

        return view
    }

    private fun bind(container: LinearLayout, image: ImageView, name: TextView, index: Int) {
        if (index < ingredients.size) {
            val ingredient = ingredients[index]
            container.visibility = View.VISIBLE
            image.setImageResource(ingredient.imageRes)
            name.text = ingredient.name
            container.setOnClickListener {
                onItemClick(ingredient)
            }
        } else {
            container.visibility = View.INVISIBLE
        }
    }


    fun updateIngredients(newIngredients: List<Ingredients>) {
        ingredients.clear()
        ingredients.addAll(newIngredients)
        notifyDataSetChanged()
    }
    private class ViewHolder(view: View) {
        val container1: LinearLayout = view.findViewById(R.id.selected_container_1)
        val container2: LinearLayout = view.findViewById(R.id.selected_container_2)
        val container3: LinearLayout = view.findViewById(R.id.selected_container_3)

        val image1: ImageView = view.findViewById(R.id.selected_image_1)
        val image2: ImageView = view.findViewById(R.id.selected_image_2)
        val image3: ImageView = view.findViewById(R.id.selected_image_3)

        val name1: TextView = view.findViewById(R.id.selected_name_1)
        val name2: TextView = view.findViewById(R.id.selected_name_2)
        val name3: TextView = view.findViewById(R.id.selected_name_3)
    }


}
