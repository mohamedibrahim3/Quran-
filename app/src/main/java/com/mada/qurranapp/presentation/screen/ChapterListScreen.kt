package com.mada.qurranapp.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mada.qurranapp.data.sources.Chapter

@Composable
fun ChapterListScreen(chapters: List<Chapter>) {
    LazyColumn {
        items(chapters) { chapter ->
            ChapterItem(chapter)
        }
    }
}