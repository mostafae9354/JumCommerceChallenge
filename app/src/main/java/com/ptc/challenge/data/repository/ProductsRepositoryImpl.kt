package com.ptc.challenge.data.repository

import com.ptc.challenge.data.model.mapper.toEntity
import com.ptc.challenge.data.source.remote.ProductsService
import com.ptc.challenge.domain.entity.GetProductsListResponseEntity
import com.ptc.challenge.domain.repository.ProductsRepository
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val service: ProductsService) :
    ProductsRepository {

    override fun getProductsList(
        page: Int,
        searchText: String
    ): Single<GetProductsListResponseEntity> {
        return service.getProductsList(page, searchText).map {
            it.toEntity()
        }
    }
}