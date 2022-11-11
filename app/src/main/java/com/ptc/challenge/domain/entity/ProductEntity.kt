package com.ptc.challenge.domain.entity

data class ProductEntity(

    var id: Int? = null,
    var name: String? = null,
    var brand: String? = null,
    var imageUrl: String? = null,
    var price: Int? = null,
    var specialPrice: Int? = null,
    var maxSavingPercentage: Int? = null,
    var averageRating: Int? = null
)