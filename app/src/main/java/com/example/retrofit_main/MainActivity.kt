package com.example.retrofit_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_main.adapter.PostAdapter
import com.example.retrofit_main.adapter.UserAdapter
import com.example.retrofit_main.api.ApiService
import com.example.retrofit_main.api.BaseResponse
import com.example.retrofit_main.model.PostModel
import com.example.retrofit_main.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var res:RecyclerView
    private lateinit var user_res:RecyclerView
    private lateinit var userAdapter:UserAdapter
    private var userList:List<UserModel>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       res = findViewById(R.id.res)
       user_res = findViewById(R.id.user_res)

       val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        user_res.layoutManager = layoutManager

       loadUser()
        loadPost()
    }

    fun loadPost(){
        ApiService.apiClient().getPosts().enqueue(object :Callback<BaseResponse<List<PostModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<PostModel>>>,
                response: Response<BaseResponse<List<PostModel>>>
            ) {
                res.adapter = PostAdapter(response.body()?.data?: emptyList())
            }

            override fun onFailure(call: Call<BaseResponse<List<PostModel>>>, t: Throwable) {

            }
        })
    }

    fun loadUser(){
        ApiService.apiClient().getUsers().enqueue(object : Callback<BaseResponse<List<UserModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<UserModel>>>,
                response: Response<BaseResponse<List<UserModel>>>
            ) {
                user_res.adapter = UserAdapter(response.body()?.data?: emptyList())
            }
            override fun onFailure(call: Call<BaseResponse<List<UserModel>>>, t: Throwable) {

            }
        })
    }
}