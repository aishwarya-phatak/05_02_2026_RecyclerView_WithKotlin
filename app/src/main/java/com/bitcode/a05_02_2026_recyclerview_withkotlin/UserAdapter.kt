package com.bitcode.a05_02_2026_recyclerview_withkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var usersArray: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var userImageView: ImageView
    private lateinit var txtUserName: TextView
    private lateinit var txtUserCity: TextView

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            userImageView = itemView.findViewById(R.id.userImageView)
            txtUserName = itemView.findViewById(R.id.txtUserName)
            txtUserCity = itemView.findViewById(R.id.txtUserCity)
        }
    }

    override fun getItemCount(): Int {
        return usersArray.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userView = LayoutInflater.from(parent.context).inflate(R.layout.user_view, null)
        return UserViewHolder(userView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userNameTextView: TextView = holder.itemView.findViewById(R.id.txtUserName)
        userNameTextView.text = usersArray[position].userName + " " + usersArray[position].userId
        val userCityTextView: TextView = holder.itemView.findViewById(R.id.txtUserCity)
        userCityTextView.text = usersArray[position].userCity
    }
}
