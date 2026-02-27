package com.example.apipracticeapp.domain.usecase

import com.example.apipracticeapp.domain.model.Post
import com.example.apipracticeapp.domain.repository.PostRepository
import javax.inject.Inject

// UseCase represents single business action
// Even if thin, we keep it for scalability
class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {

    suspend operator fun invoke(): List<Post> {
        return repository.getPosts()
    }
}