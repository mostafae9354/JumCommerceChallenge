package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class GetProductsListMetadata(

    @SerializedName("sort") var sortBy: String? = null,
    @SerializedName("total_products") var totalProducts: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("results") var results: ArrayList<ProductModel>? = null
)