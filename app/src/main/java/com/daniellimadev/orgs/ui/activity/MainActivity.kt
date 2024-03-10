package com.daniellimadev.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.daniellimadev.orgs.R
import com.daniellimadev.orgs.model.Product
import com.daniellimadev.orgs.ui.recyclerview.adapter.ListProductAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListProductAdapter(context = this, products = listOf(
            Product(name = "test",
                description = "tess desc",
                value = BigDecimal("$ 19.99")
            ),
            Product(name = "test 1",
                description = "test desc 1",
                value = BigDecimal("$ 29.99")
            ),
            Product(name = "test 2",
                description = "test desc 2",
                value = BigDecimal("$ 39.99")
            ),
        ))

    }
}
