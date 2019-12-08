package com.example.topeak.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity
import com.example.topeak.adapters.CatalogAdapter
import com.example.topeak.adapters.CourseAdapter

class SearchFragment : androidx.fragment.app.Fragment() {
    private lateinit var catalogRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        catalogRecyclerView = view.findViewById(R.id.catalog_recycler_view)
        catalogRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        catalogRecyclerView.adapter= CatalogAdapter()


        return view

    }


}