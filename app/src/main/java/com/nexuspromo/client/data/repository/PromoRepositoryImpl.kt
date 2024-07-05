package com.nexuspromo.client.data.repository

import com.nexuspromo.client.data.model.PromoResponse
import com.nexuspromo.client.data.remote.ApiConfig
import com.nexuspromo.client.data.remote.ApiService

class PromoRepositoryImpl(private val apiService: ApiService) : PromoRepository {
    override suspend fun getPromos(): PromoResponse {
        return ApiConfig.createApiService().getPromosCollection()
    }
}