package com.example.topeak.models



data class Question(val number: Int)

class QuestionLab() {
    val questionList: MutableList<Question>

    init{
        questionList = mutableListOf()
        for(i in 0..9){

                val question = Question(i)
                questionList.add(question)
            }


        }
    }
