package com.ptc.challenge.domain.usecase

import com.ptc.challenge.domain.entity.GetProductsListResponseEntity
import com.ptc.challenge.domain.entity.param.GetProductsListParam
import com.ptc.challenge.domain.repository.ProductsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProductsListUseCase @Inject constructor(private val repository: ProductsRepository) {
    operator fun invoke(param: GetProductsListParam): Single<GetProductsListResponseEntity> {
        return with(param) {
            repository.getProductsList(page, searchText)
        }
    }
}