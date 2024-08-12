package com.example.base_datos

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lvProducts: ListView
    private lateinit var btnAddProduct: Button
    private lateinit var btnMakeSale: Button
    private lateinit var btnViewInventory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlazar vistas
        lvProducts = findViewById(R.id.lv_products)
        btnAddProduct = findViewById(R.id.btn_add_product)
        btnMakeSale = findViewById(R.id.btn_make_sale)
        btnViewInventory = findViewById(R.id.btn_view_inventory)

        // Lista temporal de productos
        val productList = arrayListOf("Producto 1", "Producto 2", "Producto 3")

        // Adaptador para la lista de productos
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productList)
        lvProducts.adapter = adapter

        // Eventos de clic en los botones
        btnAddProduct.setOnClickListener {
            // Navegar a la actividad de agregar producto
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }

        btnMakeSale.setOnClickListener {
            // Navegar a la actividad de realizar venta
            val intent = Intent(this, MakeSaleActivity::class.java)
            startActivity(intent)
        }

        btnViewInventory.setOnClickListener {
            // Mostrar inventario (Ejemplo simple de Toast)
            Toast.makeText(this, "Mostrando inventario", Toast.LENGTH_SHORT).show()
        }
    }
}
