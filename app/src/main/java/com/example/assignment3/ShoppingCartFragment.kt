package com.example.assignment3

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingCartFragment : Fragment() {
    companion object {
        var ProductImageArr = ArrayList<Int>()
        var ProductTitleArr = ArrayList<Int>()
        var ProductPriceArr = ArrayList<Int>()
        var ProductQuantityArr = ArrayList<Int>()
        var Total = 0
        lateinit var SCAdapter: ShoppingCartAdapter
        lateinit var subtotal: TextView
        lateinit var shipping: TextView
        lateinit var total: TextView
    }

    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.SCRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        SCAdapter = ShoppingCartAdapter(ProductImageArr, ProductTitleArr, ProductPriceArr, ProductQuantityArr)
        recyclerView.adapter = SCAdapter

        subtotal = view.findViewById(R.id.subTotal)
        shipping = view.findViewById(R.id.shipping)
        total = view.findViewById(R.id.total)


    }






}