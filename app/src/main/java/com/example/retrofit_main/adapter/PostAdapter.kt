package com.example.retrofit_main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit_main.R
import com.example.retrofit_main.model.PostModel

class PostAdapter(private val postList:List<PostModel>): RecyclerView.Adapter<PostAdapter.ViewHolder>(){


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.image)
        val textView:TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_activity,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = postList[position]
        holder.textView.text = item.text
        Glide.with(holder.itemView.context).load(item.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}