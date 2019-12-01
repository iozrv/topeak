package com.example.topeak.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity
import com.example.topeak.adapters.CourseAdapter
import com.example.topeak.models.CourseLab

class UserCoursesFragment: androidx.fragment.app.Fragment()  {

    private lateinit var coursesRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_courses, container, false)

        coursesRecyclerView = view.findViewById(R.id.courses_recycler_view)

        coursesRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        coursesRecyclerView.adapter=CourseAdapter()
        return view

    }

}