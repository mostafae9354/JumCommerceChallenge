package com.ptc.challenge.data.repository

import com.ptc.challenge.data.model.mapper.toEntity
import com.ptc.challenge.data.source.remote.ProductDetailsService
import com.ptc.challenge.domain.entity.GetProductDetailsResponseEntity
import com.ptc.challenge.domain.entity.param.GetProductDetailsParam
import com.ptc.challenge.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(private val service: ProductDetailsService) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(param: GetProductDetailsParam): GetProductDetailsResponseEntity {
        return service.getProductDetails(param.id).toEntity()
    }
}