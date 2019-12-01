package com.example.topeak.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity

class StartFragment: androidx.fragment.app.Fragment() {

    private lateinit var startRegButton: Button
    private lateinit var enterButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)
        startRegButton=view.findViewById(R.id.start_reg_button)
        enterButton = view.findViewById(R.id.enter_button)
        setListener()
        return view

    }



    private fun setListener(){
        startRegButton.setOnClickListener{
            (context as StartActivity).toRegFragment()
        }

        enterButton.setOnClickListener{
            val intent = Intent(context as StartActivity, MenuActivity::class.java)
            startActivity(intent)

        }
}}