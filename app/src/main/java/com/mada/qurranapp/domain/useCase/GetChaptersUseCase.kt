package com.mada.qurranapp.domain.useCase

import com.mada.qurranapp.data.sources.Chapter
import com.mada.qurranapp.data.repository.QuranRepository
import com.mada.qurranapp.data.repository.Resource

class GetChaptersUseCase(private val repository: QuranRepository) {
    suspend fun execute(): Resource<List<Chapter>> {
        return repository.getChapters()
    }
}