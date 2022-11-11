package com.ptc.challenge.data.source.remote

import com.ptc.challenge.data.model.GetProductDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailsService {
    @GET("product/{id}/")
    suspend fun getProductDetails(
        @Path("id") id: Int,
    ): GetProductDetailsResponse
}