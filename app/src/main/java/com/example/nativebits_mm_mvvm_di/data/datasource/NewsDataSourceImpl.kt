package com.example.nativebits_mm_mvvm_di.data.datasource

import com.example.nativebits_mm_mvvm_di.data.api.ApiService
import com.example.nativebits_mm_mvvm_di.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}