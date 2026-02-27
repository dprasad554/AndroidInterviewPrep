package com.example.apipracticeapp

import com.example.apipracticeapp.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPostsUseCaseTest {

    private val fakeRepository = FakePostRepository()
    private val useCase = GetPostsUseCase(fakeRepository)

    @Test
    fun `should return posts`() = runTest {
        val result = useCase()
        assertEquals(1, result.size)
    }
}