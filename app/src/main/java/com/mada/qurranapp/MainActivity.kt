package com.mada.qurranapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import com.mada.qurranapp.data.repository.QuranRepository
import com.mada.qurranapp.data.retrofit.RetrofitInstance
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import com.mada.qurranapp.data.repository.Resource
import com.mada.qurranapp.presentation.screen.ChapterListScreen
import com.mada.qurranapp.presentation.viewModel.ChapterViewModel
import com.mada.qurranapp.presentation.viewModel.ChapterViewModelFactory
import com.mada.qurranapp.ui.theme.QurranAppTheme




class MainActivity : ComponentActivity() {
    private val viewModel: ChapterViewModel by viewModels {
        ChapterViewModelFactory(QuranRepository(RetrofitInstance.api))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QurranAppTheme {
                // Start the Chapter list screen
                val chaptersState = viewModel.chapters.observeAsState(initial = Resource.Loading)
                when (val state = chaptersState.value) {
                    is Resource.Success -> {
                        ChapterListScreen(chapters = state.data)
                    }
                    is Resource.Loading -> {
                        // Display loading state
                        CircularProgressIndicator()
                    }
                    is Resource.Error -> {
                        // Show error message
                        Text(text = state.message)
                    }
                }
            }
        }
        // Fetch chapters when activity is created
        viewModel.fetchChapters()
    }
}
