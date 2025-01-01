package com.mada.qurranapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mada.qurranapp.data.repository.QuranRepository

class ChapterViewModelFactory(private val repository: QuranRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChapterViewModel(repository) as T
    }
}