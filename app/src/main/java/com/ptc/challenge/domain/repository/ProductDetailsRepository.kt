package com.ptc.challenge.domain.repository

import com.ptc.challenge.domain.entity.GetProductDetailsResponseEntity
import com.ptc.challenge.domain.entity.param.GetProductDetailsParam

interface ProductDetailsRepository {
    suspend fun getProductDetails(param: GetProductDetailsParam): GetProductDetailsResponseEntity
}