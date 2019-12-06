package com.example.topeak.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.models.CourseLab

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseHolder>() {

        val courseList = CourseLab().courseList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {

        val view: View

        view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return CourseHolder(view)
    }

    override fun getItemCount(): Int = courseList.size


    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        CourseLab()
        holder.bind(position)


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