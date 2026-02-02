package com.android.readysetcook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.android.handlers.UserHandler
import com.android.data.IngredientCategory
import com.android.adapters.IngredientCategoryListViewAdapter
import com.android.fragments.BaseActivity
import com.android.lists.IngredientList

class IngredientCategoryActivity : BaseActivity() {

    lateinit var arrayAdapter: IngredientCategoryListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_category)

        val listview = findViewById<ListView>(R.id.listview)

        var listOfIngredientCategory = IngredientList.listOfIngredientCategory

        arrayAdapter = IngredientCategoryListViewAdapter(
            this, listOfIngredientCategory
        )

        listview.adapter = arrayAdapter

        val searchBar = findViewById<EditText>(R.id.search_bar)

        searchBar.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                arrayAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: android.text.Editable?) {}
        })

        listview.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = arrayAdapter.getItem(position) as IngredientCategory

            val intent = Intent(this, IngredientsActivity::class.java).apply {
                putExtra("ingredient_category_name", selectedCategory.categoryName)
                putExtra("ingredient_names", selectedCategory.ingredients.map { it.name }.toTypedArray())
                putExtra("ingredient_images", selectedCategory.ingredients.map { it.imageRes }.toIntArray())
            }
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(0, 0)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
        super.onBackPressed()
    }

}