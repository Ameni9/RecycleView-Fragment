package com.example.restapiidemo.home.data

data class CommentModel (
    var postId:Int?=0,
    var id:Int?=0,
    var name:String?="",
    var email:String?="",
    var body:String?=""
)

