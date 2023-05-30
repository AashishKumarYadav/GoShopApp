package com.example.goshop

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class ProductAdapter(val context:Activity,val productArrayList : List<Product> ) :
RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.pName.text = currentItem.title

        Picasso.get().load(currentItem.thumbnail).into(holder.pImage)
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var pName : TextView
        var pImage : ShapeableImageView

        init {
            pName = itemView.findViewById(R.id.ProductName)
            pImage = itemView.findViewById(R.id.productImage)
        }
    }
}