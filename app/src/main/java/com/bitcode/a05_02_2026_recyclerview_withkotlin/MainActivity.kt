package com.bitcode.a05_02_2026_recyclerview_withkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForUsers: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var users: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initArrayList()
        initViews()
    }

    fun initViews() {
        recyclerViewForUsers = findViewById(R.id.recyclerViewForUsers)
        userAdapter = UserAdapter(users)
        recyclerViewForUsers.adapter = userAdapter

        linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerViewForUsers.layoutManager = linearLayoutManager
    }

    fun initArrayList() {
        users = ArrayList<User>()
        for (i in 1..10) {
            users.add(
                User(
                    i + 100,
                    "User $i",
                    "Pune"
                )
            )
        }
    }
}