package com.nexuspromo.client.data.remote

import com.nexuspromo.client.data.model.Constants.VARIOUS_URL.Companion.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        fun createApiService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}