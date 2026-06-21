package com.example.shopping

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.apiCalling.RetrofitInstance
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : ProductAdapter
    private lateinit var fetchBtn : Button

    private val productlist = mutableListOf<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView =findViewById(R.id.recyclerView)

        fetchBtn = findViewById(R.id.fetchBtn)



        adapter = ProductAdapter(productlist) { product ->
            val intent = Intent(this, ProductDetailScreen::class.java)
            intent.putExtra("price",product.price)
            intent.putExtra("category",product.category)
            intent.putExtra("description",product.description)
            intent.putExtra("image",product.thumbnail)
            startActivity(intent)

        }
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = adapter


        fetchBtn.setOnClickListener {
            fetchBtn.visibility = View.GONE
            getProductFromApi()

        }

    }

    fun getProductFromApi(){
        lifecycleScope.launch {
            try {
                val responce = RetrofitInstance.api.getProducts()
                adapter.updateData(responce.products)
            }catch (e: Exception){
                Log.e("API ERROR","Error ${e.message}")
            }
        }
    }
}