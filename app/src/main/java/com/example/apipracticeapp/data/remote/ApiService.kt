package com.example.apipracticeapp.data.remote

import com.example.apipracticeapp.domain.model.Post
import retrofit2.http.GET

// Retrofit interface defines API endpoints
interface ApiService {

    // @GET defines HTTP GET request
    // "posts" is endpoint path
    // suspend because Retrofit coroutine support allows async call
    @GET("posts")
    suspend fun getPosts(): List<Post>
}