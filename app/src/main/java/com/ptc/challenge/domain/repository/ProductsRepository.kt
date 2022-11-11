package com.ptc.challenge.domain.repository

import com.ptc.challenge.domain.entity.GetProductsListResponseEntity
import io.reactivex.Single

interface ProductsRepository {
    fun getProductsList(page: Int, searchText: String): Single<GetProductsListResponseEntity>
}