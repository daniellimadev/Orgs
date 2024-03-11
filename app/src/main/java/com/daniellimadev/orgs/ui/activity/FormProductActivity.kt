package com.daniellimadev.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.daniellimadev.orgs.R
import com.daniellimadev.orgs.dao.ProductsDao
import com.daniellimadev.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val buttonSave = findViewById<Button>(R.id.button_save)
        buttonSave.setOnClickListener {
            val fieldName = findViewById<EditText>(R.id.name)
            val name = fieldName.text.toString()
            val findDescription = findViewById<EditText>(R.id.description)
            val description = findDescription.text.toString()
            val findValue = findViewById<EditText>(R.id.value)
            val textInValue = findValue.text.toString()
            val value = if (textInValue.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(textInValue)
            }


            val productNew = Product(
                name = name,
                description = description,
                value = value
            )


            Log.i("FormProduct", "onCreate: $productNew")
            val dao = ProductsDao()
            dao.add(productNew)
            Log.i("FormProduct", "onCreate: ${dao.searchAll()}")
        }
    }

}