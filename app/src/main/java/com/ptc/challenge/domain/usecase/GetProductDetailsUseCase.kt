package com.ptc.challenge.domain.usecase

import com.ptc.challenge.domain.entity.GetProductDetailsResponseEntity
import com.ptc.challenge.domain.entity.param.GetProductDetailsParam
import com.ptc.challenge.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(private val repository: ProductDetailsRepository) {
    suspend operator fun invoke(param: GetProductDetailsParam): GetProductDetailsResponseEntity {
        return with(param) {
            repository.getProductDetails(param)
        }
    }
}