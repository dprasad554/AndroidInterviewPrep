package com.example.apipracticeapp

import com.example.apipracticeapp.domain.model.Post
import com.example.apipracticeapp.domain.usecase.GetPostsUseCase
import com.example.apipracticeapp.presentation.state.PostUiState
import com.example.apipracticeapp.presentation.viewmodel.PostViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class PostViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val useCase = mockk<GetPostsUseCase>()

    @Test
    fun `should emit Success state`() = runTest {

        val fakePosts = listOf(Post(1, "Title", "Body"))

        coEvery { useCase.invoke() } returns fakePosts

        val viewModel = PostViewModel(useCase)

        advanceUntilIdle()

        assertTrue(viewModel.state.value is PostUiState.Success)
    }
}