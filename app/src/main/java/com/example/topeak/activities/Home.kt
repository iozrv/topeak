package com.example.topeak.activities

import android.app.Application
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

private lateinit var firebaseAuth: FirebaseAuth


class Home: Application() {

    override fun onCreate() {
        super.onCreate()
        firebaseAuth = FirebaseAuth.getInstance()
        var firebUser = firebaseAuth.currentUser
        if(firebUser != null){
            val intent = Intent(this@Home, MenuActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

}