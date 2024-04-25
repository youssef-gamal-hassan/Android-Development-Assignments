package com.example.assignment3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ProductMenuAdapter(
    var ProductImageArr: ArrayList<Int>,
    var ProductTitleArr: ArrayList<Int>,
    var ProductPriceArr: ArrayList<Int>,
    var context: Context
) : RecyclerView.Adapter<ProductMenuAdapter.ProductMenuHolder>() {
    class ProductMenuHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var productimage:ImageView = itemView.findViewById(R.id.ProductImage)
        var producttitle: TextView = itemView.findViewById(R.id.ProductTitle)
        var productprice: TextView = itemView.findViewById(R.id.ProductPrice)
        var cardView: CardView = itemView.findViewById(R.id.PMCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductMenuHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.pm_item_view_design, parent, false)
        return ProductMenuHolder(view)
    }

    override fun getItemCount(): Int {
        return ProductTitleArr.size
    }

    override fun onBindViewHolder(holder: ProductMenuHolder, position: Int) {
        holder.producttitle.setText(ProductTitleArr.get(position))
        holder.productprice.text = "$" + ProductPriceArr.get(position).toString()
        holder.productimage.setImageResource(ProductImageArr.get(position))

        holder.cardView.setOnClickListener{
            MainActivity.currentTitle = ProductTitleArr.get(position)
            MainActivity.currentPrice = ProductPriceArr.get(position)
            MainActivity.currentImage = ProductImageArr.get(position)

            ProductViewFrag.imageView.setImageResource(MainActivity.currentImage)
            ProductViewFrag.PVtitle.setText(MainActivity.currentTitle)
            ProductViewFrag.PvPrice.text = "$" + MainActivity.currentPrice.toString()

        }
    }

}