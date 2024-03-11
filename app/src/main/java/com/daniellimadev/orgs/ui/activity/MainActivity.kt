package com.daniellimadev.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.daniellimadev.orgs.R
import com.daniellimadev.orgs.dao.ProductsDao
import com.daniellimadev.orgs.model.Product
import com.daniellimadev.orgs.ui.recyclerview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProductsDao()
        Log.i("MainActivity", "onCreate: ${dao.searchAll()}")
        recyclerView.adapter = ListProductAdapter(context = this, products = dao.searchAll())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
}
