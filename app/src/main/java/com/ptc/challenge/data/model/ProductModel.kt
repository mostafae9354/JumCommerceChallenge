package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(

    @SerializedName("sku") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("image") var imageUrl: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("special_price") var specialPrice: Int? = null,
    @SerializedName("max_saving_percentage") var maxSavingPercentage: Int? = null,
    @SerializedName("rating_average") var averageRating: Int? = null
)