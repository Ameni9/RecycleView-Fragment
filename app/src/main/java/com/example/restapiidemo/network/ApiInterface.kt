package com.example.restapiidemo.network

import com.example.restapiidemo.home.data.CommentModel
import com.example.restapiidemo.home.data.PostModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>

    @GET("posts/{id}/comments")
    fun fetchAllComments(@Path("id") id:Int): Call<List<CommentModel>>

}