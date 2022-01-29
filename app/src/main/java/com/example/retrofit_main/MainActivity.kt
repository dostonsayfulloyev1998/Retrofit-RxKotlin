package com.example.retrofit_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrofit_main.api.ApiService
import com.example.retrofit_main.api.BaseResponse
import com.example.retrofit_main.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
   private lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text)
        loadUser();
    }

    fun loadUser(){
        ApiService.apiClient().getUsers().enqueue(object : Callback<BaseResponse<List<UserModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<UserModel>>>,
                response: Response<BaseResponse<List<UserModel>>>
            ) {
                text.text = (response.body()?.data?: emptyList()).toString()
            }
            override fun onFailure(call: Call<BaseResponse<List<UserModel>>>, t: Throwable) {

            }
        })
    }
}