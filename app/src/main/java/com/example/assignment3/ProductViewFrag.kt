package com.example.assignment3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProductViewFrag : Fragment() {
    companion object{
        lateinit var imageView: ImageView
        lateinit var PVtitle: TextView
        lateinit var PvPrice : TextView
    }
    lateinit var QuantityTV: TextView
    lateinit var cartButton: Button
    lateinit var addQuantity: Button
    lateinit var minusQuantity: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_view, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)
        PVtitle = view.findViewById(R.id.PVTitle)
        PvPrice = view.findViewById(R.id.PVPrice)
        QuantityTV = view.findViewById(R.id.QuantityButtonTV)
        cartButton = view.findViewById(R.id.AddToCartButton)
        addQuantity = view.findViewById(R.id.incrementButton)
        minusQuantity = view.findViewById(R.id.decrementButton)

        imageView.setImageResource(MainActivity.currentImage)
        PVtitle.setText(MainActivity.currentTitle)
        PvPrice.setText(MainActivity.currentPrice)

        addQuantity.setOnClickListener {
            QuantityTV.text = (QuantityTV.text.toString().toInt() + 1).toString()

        }

        minusQuantity.setOnClickListener {
            QuantityTV.text = (QuantityTV.text.toString().toInt() - 1).toString()
        }

        cartButton.setOnClickListener {
            if(!ShoppingCartFragment.ProductTitleArr.contains(MainActivity.currentTitle)){
                ShoppingCartFragment.ProductImageArr.add(MainActivity.currentImage)
                ShoppingCartFragment.ProductPriceArr.add(MainActivity.currentPrice)
                ShoppingCartFragment.ProductTitleArr.add(MainActivity.currentTitle)
                ShoppingCartFragment.ProductQuantityArr.add(QuantityTV.text.toString().toInt())
                ShoppingCartFragment.Total += MainActivity.currentPrice * QuantityTV.text.toString().toInt()
            }
            else{
                var index = ShoppingCartFragment.ProductTitleArr.indexOf(MainActivity.currentTitle)
                ShoppingCartFragment.ProductQuantityArr.add(index, ShoppingCartFragment.ProductQuantityArr.get(index) + QuantityTV.text.toString().toInt())
                ShoppingCartFragment.Total += ShoppingCartFragment.ProductPriceArr.get(index) * QuantityTV.text.toString().toInt()
            }

            if (ShoppingCartFragment.Total >= 200){
                Toast.makeText(view.context, R.string.Warning, Toast.LENGTH_SHORT).show()
            }
            ShoppingCartFragment.SCAdapter.notifyDataSetChanged()

            ShoppingCartFragment.subtotal.text = ShoppingCartFragment.Total.toString()
            ShoppingCartFragment.shipping.text = "10"
            ShoppingCartFragment.total.text = (ShoppingCartFragment.Total + 10).toString()

            QuantityTV.text = "1"

        }

    }

}