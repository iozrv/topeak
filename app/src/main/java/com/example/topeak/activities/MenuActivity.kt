package com.example.topeak.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.fragments.SearchFragment
import com.example.topeak.fragments.StartFragment
import com.example.topeak.fragments.UserCoursesFragment
import com.example.topeak.fragments.UserProfileFragment

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
            .addToBackStack("search_fragment")
            .commit()
    }

    fun toUserCoursesFragment(){
        val userCoursesFragment = UserCoursesFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, userCoursesFragment)
            .addToBackStack("user_courses_fragment")
            .commit()
    }

    fun toUserProfileFragment(){
        val userProfileFragment = UserProfileFragment()
        fm.beginTransaction()
            .replace(R.id.menu_fragment_container, userProfileFragment)
            .addToBackStack("user_profile_fragment")
            .commit()
    }



}
