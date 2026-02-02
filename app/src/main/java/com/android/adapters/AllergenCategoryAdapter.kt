package com.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.data.Allergens
import com.android.handlers.AppHandler
import com.android.readysetcook.R

class AllergenCategoryAdapter(
    private val context: Context,
    private val allergenCategories: List<Allergens>,
    private val onCategoryClick: (Allergens) -> Unit
) : BaseAdapter() {

    private val selectedCategories = (context.applicationContext as AppHandler).getSelectedAllergens().toMutableSet()

    fun setSelectedCategories(categories: Set<Allergens>) {
        selectedCategories.clear()
        selectedCategories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun getCount(): Int = allergenCategories.size

    override fun getItem(position: Int): Any = allergenCategories[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.allergen_category_layout,
                parent,
                false
            )
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val category = allergenCategories[position]
        holder.name.text = category.name

        holder.checkbox.setImageResource(
            if (selectedCategories.contains(category)) {
                R.drawable.status_square_white
            } else {
                R.drawable.status_square_black
            }
        )

        view.setOnClickListener {

            if (selectedCategories.contains(category)) {
                selectedCategories.remove(category)
                (context.applicationContext as AppHandler).removeSelectedAllergen(category)
            } else {
                selectedCategories.add(category)
                (context.applicationContext as AppHandler).addSelectedAllergen(category)
            }

            notifyDataSetChanged()

            onCategoryClick(category)
        }

        return view
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.allergen_item_name)
        val checkbox: ImageView = view.findViewById(R.id.allergen_status_square)
    }
}
