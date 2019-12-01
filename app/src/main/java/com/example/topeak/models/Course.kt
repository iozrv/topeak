package com.example.topeak.models

data class Course(val name: String)

class CourseLab(){
    val courseList: MutableList<Course>

    init{
        courseList = mutableListOf()

        for(i in 0..1){
            if(i==0){
                val course = Course("Курс по английскому языку")
                courseList.add(course)
            }
            else if(i==1){
                val course = Course("Курс по основам программирования")
                courseList.add(course)
            }

        }
    }

}