package com.example.retrofit_main.api

import com.example.retrofit_main.model.PostModel
import com.example.retrofit_main.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @Headers("app-id:61f54bd48f70dab71949f4d7")
    @GET("user")
    fun getUsers():Call<BaseResponse<List<UserModel>>>

    @Headers("app-id:61f54bd48f70dab71949f4d7")
    @GET("post")
    fun getPosts():Call<BaseResponse<List<PostModel>>>



}

