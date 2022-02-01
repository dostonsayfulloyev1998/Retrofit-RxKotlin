package com.example.retrofit_main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit_main.R
import com.example.retrofit_main.model.UserModel
import de.hdodenhof.circleimageview.CircleImageView


class UserAdapter(private val userList:List<UserModel>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val d = userList[position]

        Glide.with(holder.itemView.context).load(d.picture).into(holder.imageView)
        holder.name.text = d.firstName
        holder.surname.text = d.lastName
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
         val imageView:CircleImageView = itemView.findViewById(R.id.image)
         val name:TextView = itemView.findViewById(R.id.name)
         val surname:TextView = itemView.findViewById(R.id.surname)
    }
}