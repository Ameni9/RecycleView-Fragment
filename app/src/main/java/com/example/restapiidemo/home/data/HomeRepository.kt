package com.example.restapiidemo.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapiidemo.network.ApiClient
import com.example.restapiidemo.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllPosts():LiveData<List<PostModel>>{
        val data = MutableLiveData<List<PostModel>>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>>{

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        return data

    }

    fun fetchAllComments(id:Int):LiveData<List<CommentModel>>{
        val data = MutableLiveData<List<CommentModel>>()

        apiInterface?.fetchAllComments(id)?.enqueue(object : Callback<List<CommentModel>>{

            override fun onFailure(call: Call<List<CommentModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<CommentModel>>,
                response: Response<List<CommentModel>>
            ) {
                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data

    }

}