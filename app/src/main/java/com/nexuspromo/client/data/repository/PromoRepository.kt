package com.nexuspromo.client.data.repository

import com.nexuspromo.client.data.model.PromoResponse

interface PromoRepository {
    suspend fun getPromos(): PromoResponse
}