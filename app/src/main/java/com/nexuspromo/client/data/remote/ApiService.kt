package com.nexuspromo.client.data.remote

import com.nexuspromo.client.data.model.PromoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("promos")
    suspend fun getPromosCollection(
        @Query("populate") populate: String = "*"
    ): PromoResponse
}