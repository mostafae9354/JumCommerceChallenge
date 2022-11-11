package com.ptc.challenge.data.source.remote

import com.ptc.challenge.data.model.GetProductsListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsService {
    @GET("search/{search}/page/{page_number}/")
    fun getProductsList(
        @Path("page_number") page: Int,
        @Path("search") searchText: String
    ): Single<GetProductsListResponse>
}