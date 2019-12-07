package com.example.topeak.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topeak.R
import com.example.topeak.activities.GoingCourseActivity
import com.example.topeak.models.CatalogLab
import com.example.topeak.models.QuestionLab

class QuestionAdapter: RecyclerView.Adapter<QuestionAdapter.QuestionHolder>()  {

    val questionList = QuestionLab().questionList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.QuestionHolder {

        val view: View

        view = LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false)
        return QuestionHolder(view)
    }

    override fun getItemCount(): Int = questionList.size

    override fun onBindViewHolder(holder: QuestionAdapter.QuestionHolder, position: Int) {
        QuestionLab()
        holder.itemView.setOnClickListener{
            (holder.itemView.context as GoingCourseActivity).toCourseFragment()}
        holder.bind(position)


    }



    inner class QuestionHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(position: Int){
            val idImg = itemView.findViewById<ImageView>(R.id.icon_question)
            idImg.setImageResource(R.drawable.ic_question)

        }
    }

}