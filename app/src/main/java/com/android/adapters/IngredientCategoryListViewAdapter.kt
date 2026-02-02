package com.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.android.data.IngredientCategory
import com.android.readysetcook.R

class IngredientCategoryListViewAdapter(
    private val context: Context,
    private val originalList: List<IngredientCategory>
) : BaseAdapter() {

    private var filteredList: List<IngredientCategory> = originalList.toList()

    override fun getCount(): Int = filteredList.size

    override fun getItem(position: Int): Any = filteredList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.ingredient_category_layout,
                parent,
                false
            )
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val category = filteredList[position]
        holder.name.text = category.categoryName

        return view
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            originalList
        } else {
            originalList.filter {
                it.categoryName.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.ingredient_category)
    }
}