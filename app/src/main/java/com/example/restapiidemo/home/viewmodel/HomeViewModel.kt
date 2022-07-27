package com.example.restapiidemo.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapiidemo.home.data.CommentModel
import com.example.restapiidemo.home.data.HomeRepository
import com.example.restapiidemo.home.data.PostModel

class HomeViewModel(application: Application): AndroidViewModel(application){

    private var homeRepository:HomeRepository?=null
    var postModelListLiveData : LiveData<List<PostModel>>?=null
    var commentModelListLiveData : LiveData<List<CommentModel>>?=null

    init {
        homeRepository = HomeRepository()
        postModelListLiveData = MutableLiveData()
        commentModelListLiveData = MutableLiveData()

    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }

    fun fetchAllComments(id:Int){
        commentModelListLiveData  = homeRepository?.fetchAllComments(id)
    }

}