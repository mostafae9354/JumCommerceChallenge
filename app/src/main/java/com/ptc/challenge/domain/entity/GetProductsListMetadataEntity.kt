package com.ptc.challenge.domain.entity

data class GetProductsListMetadataEntity(

    var sortBy: String? = null,
    var totalProducts: Int? = null,
    var title: String? = null,
    var results: ArrayList<ProductEntity>? = null
)