package com.example.apipracticeapp.presentation.state

import com.example.apipracticeapp.domain.model.Post

// Helps when using when() expression exhaustively
sealed class PostUiState {

    object Loading : PostUiState() // Loading state

    data class Success(
        val posts: List<Post>
    ) : PostUiState()

    data class Error(
        val message: String
    ) : PostUiState()
}