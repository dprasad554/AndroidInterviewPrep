package com.example.apipracticeapp.data.repository

import com.example.apipracticeapp.data.remote.ApiService
import com.example.apipracticeapp.domain.model.Post
import com.example.apipracticeapp.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {

    override suspend fun getPosts(): List<Post> =
        apiService.getPosts().map {
            Post(
                userId = it.userId,
                id = it.id,
                title = it.title,
                body = it.body
            )
        }
}