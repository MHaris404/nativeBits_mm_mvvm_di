package com.example.nativebits_mm_mvvm_di.data.datasource

import com.example.nativebits_mm_mvvm_di.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(
        country: String,
    ): Response<NewsResponse>
}