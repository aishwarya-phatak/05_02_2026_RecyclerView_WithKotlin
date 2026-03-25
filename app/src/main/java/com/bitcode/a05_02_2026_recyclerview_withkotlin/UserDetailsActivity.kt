package com.bitcode.a05_02_2026_recyclerview_withkotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var userImageView1: ImageView
    private lateinit var txtUserName1: TextView
    private lateinit var txtUserCity1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        userImageView1 = findViewById(R.id.userImageView1)
        txtUserName1 = findViewById(R.id.txtUserName1)
        txtUserCity1 = findViewById(R.id.txtUserCity1)
        extractAndBindData()
    }

    fun extractAndBindData() {
        val i = intent
        val user = i.getSerializableExtra("user") as User    //as is a keyword to cast
        txtUserName1.text = user.userName + " " + user.userId
        txtUserCity1.text = user.userCity

//        txtUserName1.text = i.getIntExtra("user_id", -1).toString()
        userImageView1.setImageResource(R.drawable.ic_launcher_background)
    }
}