package com.mada.qurranapp.data.retrofit

import com.mada.qurranapp.data.api.QuranApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.quran.com/api/v4/"

    val api: QuranApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranApi::class.java)
    }
}
