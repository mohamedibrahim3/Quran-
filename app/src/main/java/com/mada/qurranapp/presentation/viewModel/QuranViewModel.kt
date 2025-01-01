package com.mada.qurranapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mada.qurranapp.data.repository.QuranRepository
import com.mada.qurranapp.data.repository.Resource
import com.mada.qurranapp.data.sources.Chapter
import kotlinx.coroutines.launch

class ChapterViewModel(private val repository: QuranRepository) : ViewModel() {

    private val _chapters = MutableLiveData<Resource<List<Chapter>>>()
    val chapters: LiveData<Resource<List<Chapter>>> get() = _chapters

    fun fetchChapters() {
        viewModelScope.launch {
            _chapters.value = Resource.Loading
            val result = repository.getChapters()
            _chapters.value = result
        }
    }
}

