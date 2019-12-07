package com.example.topeak.activities

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.fragments.*

class MenuActivity : AppCompatActivity() {


    val fm = supportFragmentManager

    private lateinit var searchButton: ImageButton
    private lateinit var profileButton: ImageButton
    private lateinit var coursesButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initalize()
        setListener()
        val userCoursesFragment = UserCoursesFragment()
        fm.beginTransaction()
            .add(R.id.menu_fragment_container, userCoursesFragment)
            .commit()


    }

    fun initalize(){
        searchButton = findViewById(R.id.search_button)
        profileButton = findViewById(R.id.profile_button)
        coursesButton = findViewById(R.id.courses_button)
    }


    fun setListener(){
        searchButton.setOnClickListener{
            toSearchFragment()
        }
        profileButton.setOnClickListener{
            toUserProfileFragment()
        }
        coursesButton.setOnClickListener{
            toUserCoursesFragment()
        }

    }

    fun toSearchFragment(){
        val searchFragment = SearchFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, searchFragment)
            .commit()

        searchButton.setColorFilter(resources.getColor(R.color.orange))
        coursesButton.setColorFilter(resources.getColor(R.color.basic))
        profileButton.setColorFilter(resources.getColor(R.color.basic))

    }

    fun toUserCoursesFragment(){
        val userCoursesFragment = UserCoursesFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, userCoursesFragment)
            .commit()
        coursesButton.setColorFilter(resources.getColor(R.color.orange))
        profileButton.setColorFilter(resources.getColor(R.color.basic))
        searchButton.setColorFilter(resources.getColor(R.color.basic))


    }

    fun toUserProfileFragment(){
        val userProfileFragment = UserProfileFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, userProfileFragment)
            .commit()
        profileButton.setColorFilter(resources.getColor(R.color.orange))
        searchButton.setColorFilter(resources.getColor(R.color.basic))
        coursesButton.setColorFilter(resources.getColor(R.color.basic))


    }

    fun toCourseFragment(){
        val courseFragment = CourseFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, courseFragment)
            .commit()
        coursesButton.setColorFilter(resources.getColor(R.color.orange))
        profileButton.setColorFilter(resources.getColor(R.color.basic))
        searchButton.setColorFilter(resources.getColor(R.color.basic))


    }






}
