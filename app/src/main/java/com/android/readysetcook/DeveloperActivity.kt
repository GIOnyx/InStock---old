package com.android.readysetcook

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.android.fragments.BaseActivity

    class   DeveloperActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val developer_karylle = findViewById<TextView>(R.id.developer_karylle)
        val developer_onyx = findViewById<TextView>(R.id.developer_onyx)

        developer_onyx.setOnClickListener {
            Toast.makeText(this, "Ongoing Feature", Toast.LENGTH_LONG).show()
        }

        developer_karylle.setOnClickListener {
            Toast.makeText(this, "Ongoing Feature", Toast.LENGTH_LONG).show()
        }
        backArrow?.setOnClickListener {
            finish()
        }
    }


}