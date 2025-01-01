package com.mada.qurranapp.repository

import com.mada.qurranapp.data.api.QuranApi
import com.mada.qurranapp.data.sources.Chapter

class QuranRepository(private val api:QuranApi) {
    suspend fun fetchChapters(): List<Chapter> {
        val response = api.getChapters()
        if (response.isSuccessful) {
            return response.body()?.chapters ?: emptyList()
        } else {
            throw Exception("Failed to load chapters")
        }
    }
}