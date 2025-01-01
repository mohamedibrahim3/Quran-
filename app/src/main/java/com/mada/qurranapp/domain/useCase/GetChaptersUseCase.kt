package com.mada.qurranapp.domain.useCase

import com.mada.qurranapp.data.sources.Chapter
import com.mada.qurranapp.repository.QuranRepository

class GetChaptersUseCase(private val repository: QuranRepository) {
    suspend operator fun invoke(): List<Chapter> {
        return repository.fetchChapters()
    }
}