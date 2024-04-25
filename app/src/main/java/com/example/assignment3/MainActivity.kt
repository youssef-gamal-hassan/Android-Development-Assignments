package com.example.assignment3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.assignment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    companion object {
        var currentTitle: Int = R.string.laptop1
        var currentPrice: Int = R.string.Placeholder
        var currentImage: Int = R.drawable.laptop1

    }
    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        var view = mainBinding.root
        setContentView(view)



        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction :FragmentTransaction = fragmentManager.beginTransaction()

        val productMenu = ProductMenu()

        fragmentTransaction.add(R.id.PMFrame, productMenu)

        val shoppingCart = ShoppingCartFragment()

        val productView = ProductViewFrag()

        fragmentTransaction.add(R.id.PVFrame, productView)

        fragmentTransaction.add(R.id.SCFrame, shoppingCart)

        fragmentTransaction.commit()



    }

    fun Save(){
        sharedPref = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.clear()

        for (i in ShoppingCartFragment.ProductTitleArr){
            var index = ShoppingCartFragment.ProductTitleArr.indexOf(i)
            if (i == R.string.laptop1){
                editor.putInt("item_1", R.string.laptop1)
                editor.putInt("item_1_quantity", ShoppingCartFragment.ProductQuantityArr.get(index))
            }
            else if (i == R.string.laptop2){
                editor.putInt("item_2", R.string.laptop2)
                editor.putInt("item_2_quantity", ShoppingCartFragment.ProductQuantityArr.get(index))
            }
            else if (i == R.string.laptop3){
                editor.putInt("item_3", R.string.laptop3)
                editor.putInt("item_3_quantity", ShoppingCartFragment.ProductQuantityArr.get(index))
            }
        }

        editor.apply()
        Toast.makeText(applicationContext, "data saved!", Toast.LENGTH_LONG).show()
    }

    fun Load(){

        ShoppingCartFragment.ProductTitleArr.clear()
        ShoppingCartFragment.ProductQuantityArr.clear()
        ShoppingCartFragment.ProductPriceArr.clear()
        ShoppingCartFragment.ProductImageArr.clear()
        ShoppingCartFragment.Total = 0



        sharedPref = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        val item1 = sharedPref.getInt("item_1", 0)
        val item_1_quantity = sharedPref.getInt("item_1_quantity", 0)

        val item2 = sharedPref.getInt("item_2", 0)
        val item_2_quantity = sharedPref.getInt("item_2_quantity", 0)

        val item3 = sharedPref.getInt("item_3", 0)
        val item_3_quantity = sharedPref.getInt("item_3_quantity", 0)

        if(item1 != 0){
            ShoppingCartFragment.ProductTitleArr.add(R.string.laptop1)
            ShoppingCartFragment.ProductQuantityArr.add(item_1_quantity)
            ShoppingCartFragment.ProductPriceArr.add(1299)
            ShoppingCartFragment.ProductImageArr.add(R.drawable.laptop1)
            ShoppingCartFragment.Total += 1299 * item_1_quantity

        }
        if(item2 != 0){
            ShoppingCartFragment.ProductTitleArr.add(R.string.laptop2)
            ShoppingCartFragment.ProductQuantityArr.add(item_2_quantity)
            ShoppingCartFragment.ProductPriceArr.add(1099)
            ShoppingCartFragment.ProductImageArr.add(R.drawable.laptop2)
            ShoppingCartFragment.Total += 1099 * item_2_quantity
        }
        if(item3 !=0){
            ShoppingCartFragment.ProductTitleArr.add(R.string.laptop3)
            ShoppingCartFragment.ProductQuantityArr.add(item_3_quantity)
            ShoppingCartFragment.ProductPriceArr.add(1399)
            ShoppingCartFragment.ProductImageArr.add(R.drawable.laptop3)
            ShoppingCartFragment.Total += 1399 * item_3_quantity
        }

        ShoppingCartFragment.SCAdapter.notifyDataSetChanged()

        ShoppingCartFragment.subtotal.text = ShoppingCartFragment.Total.toString()
        ShoppingCartFragment.shipping.text = "10"
        ShoppingCartFragment.total.text = (ShoppingCartFragment.Total + 10).toString()

        Toast.makeText(applicationContext, "data loaded!", Toast.LENGTH_LONG).show()

    }

    override fun onPause() {
        super.onPause()
        Save()
    }

    override fun onResume() {
        super.onResume()
        Load()
    }
}