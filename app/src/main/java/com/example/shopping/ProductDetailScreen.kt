package com.example.shopping

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class ProductDetailScreen : AppCompatActivity() {

   lateinit var image : ImageView
   lateinit var name : TextView
   lateinit var price : TextView
   lateinit var category : TextView
   lateinit var description : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        price = findViewById(R.id.price)
        category = findViewById(R.id.category)
        description = findViewById(R.id.description)
        image = findViewById(R.id.imageView)

        val pri = intent.getDoubleExtra("price",0.0)
        val cat = intent.getStringExtra("category")
        val des = intent.getStringExtra("description")
        val img = intent.getStringExtra("image")

        price.text = "$ "+pri.toString()
        category.text = "Category: "+cat
        description.text = "Description: "+des
        Glide.with(this)
            .load(img)
            .into(image)

    }
}