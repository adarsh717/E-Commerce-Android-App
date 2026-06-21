package com.example.shopping

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductAdapter(private var productList: MutableList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.img)
        val title = itemView.findViewById<TextView>(R.id.product_name)
        val price = itemView.findViewById<TextView>(R.id.price)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder:ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.title.text = product.title
        holder.price.text = "$ "+product.price

            Glide.with(holder.itemView.context)
                .load(product.thumbnail)
                .into(holder.image)

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateData(newList : List<Product>){
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}