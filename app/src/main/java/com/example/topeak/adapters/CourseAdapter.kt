package com.example.topeak.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity
import com.example.topeak.fragments.UserCoursesFragment
import com.example.topeak.fragments.UserProfileFragment
import com.example.topeak.models.CourseLab

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseHolder>() {

        val courseList = CourseLab().courseList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {

        val view: View

        view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        view.setOnClickListener(){
            MenuActivity().toUserProfileFragment()


        }

        return CourseHolder(view)
    }



    override fun getItemCount(): Int = courseList.size


    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        CourseLab()
        holder.bind(position)

        holder.itemView.setOnClickListener{
            (holder.itemView.context as MenuActivity).toCourseFragment()
      //    val intent = Intent(holder.itemView.context, StartActivity::class.java)
       //     holder.itemView.context.startActivity(intent)
            }


    }



    inner class CourseHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(position: Int){
            val idImg = itemView.findViewById<ImageView>(R.id.icon_course)
            val idText = itemView.findViewById<TextView>(R.id.course_name)
            if(position==0){
            idImg.setImageResource(R.drawable.course1_icon)
            idText.text = "${courseList[position].name}"
        }
            else if(position==1){
                idImg.setImageResource(R.drawable.course2_icon)
                idText.text = "${courseList[position].name}"
            }
    }


}
}