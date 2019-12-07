package com.example.topeak.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.adapters.QuestionAdapter
import com.example.topeak.fragments.CourseItemFragment
import com.example.topeak.fragments.TheoryFragment
import com.example.topeak.fragments.UserCoursesFragment
import com.example.topeak.fragments.VideoFragment

class GoingCourseActivity : AppCompatActivity() {


    val fm = supportFragmentManager
    private lateinit var questionRecyclerView: RecyclerView
    private lateinit var videoBtn: ImageButton
    private lateinit var theoryBtn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_going_course)

        initialise()
        setListener()

        questionRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        questionRecyclerView.adapter= QuestionAdapter()


        val theoryFragment = TheoryFragment()
        fm.beginTransaction()
            .add(R.id.course_fragment_container, theoryFragment)
            .commit()

    }

    fun initialise(){
        questionRecyclerView = findViewById(R.id.questions_recycler_view)
        videoBtn = findViewById(R.id.ic_video)
        theoryBtn = findViewById(R.id.ic_theory)

    }

    fun setListener(){
        videoBtn.setOnClickListener{
            val videoFragment = VideoFragment()
            fm.beginTransaction()
                .replace(R.id.course_fragment_container, videoFragment)
                .commit()


            videoBtn.setColorFilter(resources.getColor(R.color.orange))
            theoryBtn.setColorFilter(resources.getColor(R.color.basic))
        }

        theoryBtn.setOnClickListener{
            val theoryFragment = TheoryFragment()
            fm.beginTransaction()
                .replace(R.id.course_fragment_container, theoryFragment)
                .commit()
            videoBtn.setColorFilter(resources.getColor(R.color.basic))
            theoryBtn.setColorFilter(resources.getColor(R.color.orange))
        }
    }


    fun toCourseFragment(){
        val courseItemFragment = CourseItemFragment()
        fm.beginTransaction()
            .replace(R.id.course_fragment_container, courseItemFragment)
            .commit()

    }
}
