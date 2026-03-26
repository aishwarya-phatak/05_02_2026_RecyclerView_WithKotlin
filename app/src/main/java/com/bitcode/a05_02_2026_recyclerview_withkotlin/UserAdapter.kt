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

class UserAdapter(var usersArray: ArrayList<User>,
                  var productsArray : ArrayList<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var userImageView: ImageView
    private lateinit var txtUserName : TextView
    private lateinit var txtUserCity : TextView

    private lateinit var txtViewProductId : TextView
    private lateinit var txtViewProductName : TextView
    private lateinit var txtViewProductPrice : TextView
    private lateinit var imageViewProduct : ImageView

    private val PRODUCT_VIEW_HOLDER = 1
    private val USER_VIEW_HOLDER = 2

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            userImageView = itemView.findViewById(R.id.userImageView)
            txtUserName = itemView.findViewById(R.id.txtUserName)
            txtUserCity = itemView.findViewById(R.id.txtUserCity)

            itemView.setOnClickListener {
                Log.e("tag", it.toString())
                var intent: Intent = Intent(it.context, UserDetailsActivity::class.java)
//                intent.putExtra("user_id",usersArray[adapterPosition].userId)
                intent.putExtra("user", usersArray[adapterPosition])
                it.context.startActivity(intent)
            }

//            userImageView.setOnClickListener {
//                Log.e("tag", it.toString())
//                var intent: Intent = Intent(it.context, UserDetailsActivity::class.java)
////                intent.putExtra("user_id",usersArray[adapterPosition].userId)
//                intent.putExtra("user", usersArray[adapterPosition])
//                it.context.startActivity(intent)
//            }
        }
    }

     inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            txtViewProductId = itemView.findViewById(R.id.txtViewProductId)
            txtViewProductName = itemView.findViewById(R.id.txtViewProductName)
            txtViewProductPrice = itemView.findViewById(R.id.txtViewProductPrice)
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if (viewType == 1) {
            val productView : View = layoutInflater.inflate(R.layout.product_view,null)
             ProductViewHolder(productView)
        }else{
            val userView: View = layoutInflater.inflate(R.layout.user_view, null)
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
            UserViewHolder(userView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder){
            val productIdTextView : TextView = holder.itemView.findViewById(R.id.txtViewProductId)
            val productNameTextView : TextView = holder.itemView.findViewById(R.id.txtViewProductName)
            val productPriceTextView : TextView = holder.itemView.findViewById(R.id.txtViewProductPrice)
            val productImageView : ImageView = holder.itemView.findViewById(R.id.imageViewProduct)

            val eachProduct = productsArray[(position - 1)/2]
            productIdTextView.text = eachProduct.productId.toString()
            productNameTextView.text = eachProduct.productName
            productPriceTextView.text = eachProduct.productPrice.toString()
            productImageView.setImageResource(R.drawable.test_image_pr_1)
        }else {
            val userNameTextView: TextView = holder.itemView.findViewById(R.id.txtUserName)
            val eachUser =  usersArray[position / 2]
            userNameTextView.text =
               eachUser.userName + " " + usersArray[position].userId
            val userCityTextView: TextView = holder.itemView.findViewById(R.id.txtUserCity)
            userCityTextView.text = eachUser.userCity
        }
    }

    override fun getItemCount(): Int {
        return usersArray.count() + productsArray.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0){
            USER_VIEW_HOLDER
        }else{
            PRODUCT_VIEW_HOLDER
        }
    }

    inner class MyImageViewClickListener : View.OnClickListener {
        override fun onClick(view: View?) {
            Toast.makeText(view?.context, "Image View Click Listener", Toast.LENGTH_LONG).show()
        }
    }
}
