package com.ptc.challenge.domain.entity

data class GetProductDetailsMetadataEntity(

    var id: Int? = null,
    var name: String? = null,
    var brand: String? = null,
    var price: Int? = null,
    var specialPrice: Int? = null,
    var maxSavingPercentage: Int? = null,
    var rating: RatingEntity? = null,
    var imagesList: ArrayList<String>? = null,
    var summary: SummaryEntity? = null,
    var seller: SellerEntity? = null
)