package com.mada.qurranapp.data.api

import com.mada.qurranapp.data.sources.QuranResponse
import retrofit2.Response

import retrofit2.http.GET

interface QuranApi {
    @GET("chapters")
    suspend fun getChapters(): QuranResponse
}