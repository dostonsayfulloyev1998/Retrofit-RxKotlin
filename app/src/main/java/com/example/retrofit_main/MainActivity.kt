package com.example.retrofit_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrofit_main.api.ApiService
import com.example.retrofit_main.api.BaseResponse
import com.example.retrofit_main.model.PostModel
import com.example.retrofit_main.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
   private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        loadPost()
    }

    fun loadPost(){
        ApiService.apiClient().getPosts().enqueue(object :Callback<BaseResponse<List<PostModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<PostModel>>>,
                response: Response<BaseResponse<List<PostModel>>>
            ) {
                 (response.body()?.data?: emptyList()).toString()
            }

            override fun onFailure(call: Call<BaseResponse<List<PostModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun loadUser(){
        ApiService.apiClient().getUsers().enqueue(object : Callback<BaseResponse<List<UserModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<UserModel>>>,
                response: Response<BaseResponse<List<UserModel>>>
            ) {
                textView.text = (response.body()?.data?: emptyList()).toString()
            }
            override fun onFailure(call: Call<BaseResponse<List<UserModel>>>, t: Throwable) {

            }
        })
    }
}