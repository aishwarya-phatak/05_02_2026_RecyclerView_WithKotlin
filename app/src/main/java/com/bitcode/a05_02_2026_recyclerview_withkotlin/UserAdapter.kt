package com.bitcode.a05_02_2026_recyclerview_withkotlin

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

            userImageView.setOnClickListener {
                Log.e("tag", it.toString())
                var intent: Intent = Intent(it.context, UserDetailsActivity::class.java)
//                intent.putExtra("user_id",usersArray[adapterPosition].userId)
                intent.putExtra("user", usersArray[adapterPosition])
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return usersArray.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userView: View = LayoutInflater.from(parent.context).inflate(R.layout.user_view, null)
        //regular - way 1 by implementing inner class
//        userView.findViewById<ImageView>(R.id.userImageView)
//            .setOnClickListener(MyImageViewClickListener())
//
//        //way 2 - using lambda function & it as an argument
//        userView.findViewById<TextView>(R.id.txtUserName).setOnClickListener {
//            Toast.makeText(it.context,
//                "TextView for username is clicked",
//                Toast.LENGTH_LONG).show()
//        }

        return UserViewHolder(userView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userNameTextView: TextView = holder.itemView.findViewById(R.id.txtUserName)
        userNameTextView.text = usersArray[position].userName + " " + usersArray[position].userId
        val userCityTextView: TextView = holder.itemView.findViewById(R.id.txtUserCity)
        userCityTextView.text = usersArray[position].userCity
    }

    inner class MyImageViewClickListener : View.OnClickListener {
        override fun onClick(view: View?) {
            Toast.makeText(view?.context, "Image View Click Listener", Toast.LENGTH_LONG).show()
        }
    }
}
