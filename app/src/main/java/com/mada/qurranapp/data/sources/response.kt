package com.mada.qurranapp.data.sources

data class QuranResponse(
    val chapters: List<Chapter>
)

data class TranslatedName(
    val language_name: String,
    val name: String
)