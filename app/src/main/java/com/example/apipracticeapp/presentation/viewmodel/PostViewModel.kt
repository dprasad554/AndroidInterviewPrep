package com.example.apipracticeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel // Android ViewModel
import androidx.lifecycle.viewModelScope // Coroutine scope tied to ViewModel lifecycle
import com.example.apipracticeapp.domain.usecase.GetPostsUseCase
import com.example.apipracticeapp.presentation.state.PostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel survives configuration changes automatically
@HiltViewModel // Tells Hilt this is ViewModel
class PostViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    // MutableStateFlow holds UI state internally
    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)

    // Expose immutable StateFlow to UI
    val state: StateFlow<PostUiState> = _uiState

    init {
        fetchPosts() // Called when ViewModel created
    }

    private fun fetchPosts() {

        // viewModelScope runs on Main thread by default
        // Automatically cancelled when ViewModel cleared
        viewModelScope.launch {

            _uiState.value = PostUiState.Loading

            try {
                val posts = getPostsUseCase()
                _uiState.value = PostUiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}