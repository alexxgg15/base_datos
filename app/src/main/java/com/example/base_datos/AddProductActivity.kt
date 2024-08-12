package com.example.base_datos



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddProductActivity : AppCompatActivity() {

    private lateinit var etProductName: EditText
    private lateinit var etProductPrice: EditText
    private lateinit var btnSaveProduct: Button
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        etProductName = findViewById(R.id.etProductName)
        etProductPrice = findViewById(R.id.etProductPrice)
        btnSaveProduct = findViewById(R.id.btnSaveProduct)

        // Inicializar la base de datos
        database = FirebaseDatabase.getInstance().getReference("products")

        btnSaveProduct.setOnClickListener {
            saveProduct()
        }
    }

    private fun saveProduct() {
        val productName = etProductName.text.toString()
        val productPrice = etProductPrice.text.toString()

        if (productName.isEmpty() || productPrice.isEmpty()) {
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val productId = database.push().key ?: return
        val product = Product(productId, productName, productPrice)

        database.child(productId).setValue(product)
            .addOnSuccessListener {
                Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show()
                etProductName.text.clear()
                etProductPrice.text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al agregar producto", Toast.LENGTH_SHORT).show()
            }
    }
}

data class Product(val id: String, val name: String, val price: String)
