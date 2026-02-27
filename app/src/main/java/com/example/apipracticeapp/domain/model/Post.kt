package com.example.apipracticeapp.domain.model

// Domain model represents business object used across app
// data class because it holds immutable UI/business data
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)