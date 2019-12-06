package com.example.topeak.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.topeak.R
import com.example.topeak.activities.StartActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_reg.*

class RegFragment : androidx.fragment.app.Fragment() {
    private lateinit var regButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg, container, false)
        regButton=view.findViewById(R.id.end_reg_button)
        setListener()
        return view

    }

    private fun setListener(){
        regButton.setOnClickListener {
            val nick = reg_login_edit.text.toString()
            val password = reg_password_edit.text.toString()
            val email = reg_mail_edit.text.toString()
            if (email.isEmpty()||password.isEmpty()||nick.isEmpty()) {
                Toast.makeText(context, "Заполните поля", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {

                        data class User(val nick: String, val email: String)
                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid)
                            .setValue(User(nick, email))

                        Toast.makeText(context, "Регистрация успешна!", Toast.LENGTH_LONG).show()
                        (context as StartActivity).toStartFragment()
                    }
                }
                .addOnFailureListener {
                    try { throw it}
                    catch(e: FirebaseAuthUserCollisionException){
                        Toast.makeText(context, "Такой пользователь уже существует", Toast.LENGTH_LONG).show()
                    }
                    catch(e: FirebaseAuthWeakPasswordException)
                    {
                        Toast.makeText(context, "Слабый пароль (6 символов минимум)", Toast.LENGTH_LONG).show()
                    }
                    catch(e: FirebaseAuthInvalidCredentialsException)
                    {
                        Toast.makeText(context, "Некорректная почта", Toast.LENGTH_LONG).show()
                    }
                }


        }





    }
}