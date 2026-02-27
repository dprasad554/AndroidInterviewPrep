package com.example.apipracticeapp

import com.example.apipracticeapp.domain.model.Post
import com.example.apipracticeapp.domain.repository.PostRepository

class FakePostRepository : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return listOf(
            Post(1, 1,"Fake Title", "Fake Body")
        )
    }
}