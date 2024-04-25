package com.example.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductMenu : Fragment() {

    var ProductImageArr = ArrayList<Int>()
    var ProductTitleArr = ArrayList<Int>()
    var ProductPriceArr = ArrayList<Int>()

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ProductImageArr.add(R.drawable.laptop1)
        ProductImageArr.add(R.drawable.laptop2)
        ProductImageArr.add(R.drawable.laptop3)
        ProductTitleArr.add(R.string.laptop1)
        ProductTitleArr.add(R.string.laptop2)
        ProductTitleArr.add(R.string.laptop3)
        ProductPriceArr.add(1299)
        ProductPriceArr.add(1099)
        ProductPriceArr.add(1399)

        return inflater.inflate(R.layout.fragment_product_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.PMItemView)

        recyclerView.layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        adapter = ProductMenuAdapter(ProductImageArr, ProductTitleArr, ProductPriceArr, view.context)

        recyclerView.adapter = adapter

    }

}