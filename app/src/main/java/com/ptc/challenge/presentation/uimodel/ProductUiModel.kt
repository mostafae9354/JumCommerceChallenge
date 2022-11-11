package com.ptc.challenge.presentation.uimodel

data class ProductUiModel(

    var id: Int? = null,
    var name: String? = null,
    var brand: String? = null,
    var imageUrl: String? = null,
    var price: String? = null,
    var specialPrice: String? = null,
    var maxSavingPercentage: Int? = null,
    var averageRating: Int? = null
)