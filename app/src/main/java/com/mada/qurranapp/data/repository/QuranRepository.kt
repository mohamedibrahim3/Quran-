package com.mada.qurranapp.data.repository

import com.mada.qurranapp.data.api.QuranApi
import com.mada.qurranapp.data.sources.Chapter


class QuranRepository(private val apiService: QuranApi) {
    suspend fun getChapters(): Resource<List<Chapter>> {
        return try {
            val response = apiService.getChapters()
            if (response.chapters.isNotEmpty()) {
                Resource.Success(response.chapters)
            } else {
                Resource.Error("No chapters found")
            }
        } catch (e: Exception) {
            Resource.Error("Failed to fetch chapters: ${e.localizedMessage}")
        }
    }
}
