package com.example.retrofit

import com.example.retrofit.model.postResposeItem
import retrofit2.http.GET

interface APIInterface {

    @GET("posts")
    suspend fun getPost(): List<postResposeItem>
}