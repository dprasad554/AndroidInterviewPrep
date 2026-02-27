package com.example.apipracticeapp.domain.repository

import com.example.apipracticeapp.domain.model.Post

// Repository interface defines contract for data access
// Domain layer defines what to fetch, not how
interface PostRepository {

    // suspend because network/database operations are asynchronous
    // suspend allows this function to be called inside coroutine
    suspend fun getPosts(): List<Post>
}