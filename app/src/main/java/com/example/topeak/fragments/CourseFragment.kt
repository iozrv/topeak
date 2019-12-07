package com.example.topeak.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topeak.R
import com.example.topeak.activities.GoingCourseActivity
import com.example.topeak.adapters.CatalogAdapter

class CourseFragment: androidx.fragment.app.Fragment() {
    private lateinit var  courseStartButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course, container, false)
        courseStartButton = view.findViewById(R.id.course_start_button)
        setListener()
        return view

    }

    fun setListener(){
        courseStartButton.setOnClickListener{
            val intent = Intent(context, GoingCourseActivity::class.java)
            startActivity(intent)
        }
    }

}