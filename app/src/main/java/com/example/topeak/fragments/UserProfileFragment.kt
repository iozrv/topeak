package com.example.topeak.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topeak.R
import com.example.topeak.activities.MenuActivity
import com.example.topeak.activities.StartActivity
import com.example.topeak.adapters.CatalogAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.*
import java.util.*

class UserProfileFragment: androidx.fragment.app.Fragment() {
    private lateinit var nick:TextView
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mReference: DatabaseReference
    private lateinit var mAuth: FirebaseAuth
    private lateinit var sendPicBtn : ImageButton
    private lateinit var imageUri : Uri
    private lateinit var logOutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)
        nick = view.findViewById(R.id.profile_nickname)
        sendPicBtn = view.findViewById(R.id.profilePic)
        logOutButton = view.findViewById(R.id.logOutBtn)
        setView()
        setListener()
        return view
    }
    private fun setListener() {
        sendPicBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,0)
        }
        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(context as MenuActivity, StartActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity!!.finish()
            startActivity(intent)
        }

    }
    private fun setView()
    {
        val user = FirebaseAuth.getInstance().currentUser!!.uid
        mDatabase= FirebaseDatabase.getInstance()
        mReference=mDatabase.reference.child("Users").child(user)

        mReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                nick.text="Не удалось загрузить ник"
            }

            override fun onDataChange(p0: DataSnapshot) {
                nick.text = p0.child("nick").value as String
            }


        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {

            imageUri = data.data!!
            uploadImageOnStorage()

        }
    }
    private fun uploadImageOnStorage() {

        val filename = UUID.randomUUID().toString()

        val mRef = FirebaseStorage.getInstance().getReference("/images/$filename")

        mRef.putFile(imageUri).addOnCompleteListener{
            mRef.downloadUrl.addOnSuccessListener {

                Log.e("FirebaseStorage", "$it")
            }
        }
    }
}
