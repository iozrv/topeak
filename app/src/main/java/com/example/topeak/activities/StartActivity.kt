package com.example.topeak.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.example.topeak.R
import com.example.topeak.fragments.RegFragment
import com.example.topeak.fragments.StartFragment

class StartActivity : AppCompatActivity() {

    val fm = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val startFragment = StartFragment()

        fm.beginTransaction()
            .add(R.id.start_fragment_container, startFragment)
            .commit()
    }

    fun toRegFragment(){
        val regFragment = RegFragment()
        fm.beginTransaction()
            .replace(R.id.start_fragment_container, regFragment)
            .commit()
    }
    fun toStartFragment(){
        val startFragment = StartFragment()
        fm.beginTransaction()
            .replace(R.id.start_fragment_container, startFragment)
            .commit()
    }

    }




