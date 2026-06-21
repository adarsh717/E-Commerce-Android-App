package com.example.shopping

import android.os.Bundle
import android.util.Log
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



        adapter = ProductAdapter(productlist)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = adapter

        getProductFromApi()

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