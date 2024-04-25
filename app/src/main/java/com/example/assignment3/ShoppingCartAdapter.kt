package com.example.assignment3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingCartAdapter(
    var ProductImageArr: ArrayList<Int>,
    var ProductTitleArr: ArrayList<Int>,
    var ProductPriceArr: ArrayList<Int>,
    var ProductQuantityArr: ArrayList<Int>
):RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>()
{

    class ShoppingCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView= itemView.findViewById(R.id.ItemImage)
        var productTitle: TextView = itemView.findViewById(R.id.ItemTitle)
        var productPrice: TextView = itemView.findViewById(R.id.PriceTV)
        var productQuantity: TextView = itemView.findViewById(R.id.QuantityTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scitemviewdesign, parent, false)
        return ShoppingCartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ProductTitleArr.size
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        holder.itemImage.setImageResource(ProductImageArr.get(position))
        holder.productTitle.setText(ProductTitleArr.get(position))
        holder.productPrice.text = "$" + ProductPriceArr.get(position).toString()
        holder.productQuantity.text = ProductQuantityArr.get(position).toString()
    }


}