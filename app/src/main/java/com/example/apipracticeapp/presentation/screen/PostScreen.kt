package com.example.apipracticeapp.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apipracticeapp.presentation.viewmodel.PostViewModel
import com.example.apipracticeapp.presentation.state.PostUiState
import com.example.apipracticeapp.domain.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Posts") }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (uiState) {

                is PostUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                is PostUiState.Success -> {
                    val posts = (uiState as PostUiState.Success).posts
                    PostList(posts)
                }

                is PostUiState.Error -> {
                    val message = (uiState as PostUiState.Error).message
                    Text(
                        text = message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun PostList(posts: List<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(posts) { post ->
            PostItem(post = post)
        }
    }
}


//LazyColumn(modifier = Modifier.fillMaxSize()) {
////                items(posts) { post ->
////                    Text(
////                        text = post.title,
////                        style = MaterialTheme.typography.bodyLarge,
////                        modifier = Modifier.padding(16.dp)
////                    )
////                }
////            }