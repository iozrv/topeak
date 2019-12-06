package com.example.topeak.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment: androidx.fragment.app.Fragment() {

    private lateinit var startRegButton: Button
    private lateinit var enterButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        startRegButton=view.findViewById(R.id.start_reg_button)
        enterButton = view.findViewById(R.id.enter_button)
        setListener()
        return view

    }



    private fun setListener(){
        startRegButton.setOnClickListener{
            (context as StartActivity).toRegFragment()
        }

        enterButton.setOnClickListener{
            val email = start_login_edit.text.toString()
            val password = start_password_edit.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context,"Заполните поля",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent =
                            Intent(context as StartActivity, MenuActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Неверная почта или пароль", Toast.LENGTH_SHORT).show()
                }

        }
    }}