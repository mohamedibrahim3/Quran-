package com.mada.qurranapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.mada.qurranapp.data.sources.Chapter

@Composable
fun ChapterItem(chapter: Chapter) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter("https://url.to.image/${chapter.id}"), // Replace with image URL
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = chapter.name_arabic, style = MaterialTheme.typography.headlineMedium)
        }
    }
}