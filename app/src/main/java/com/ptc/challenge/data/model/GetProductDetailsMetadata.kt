package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class GetProductDetailsMetadata(

    @SerializedName("sku") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("special_price") var specialPrice: Int? = null,
    @SerializedName("max_saving_percentage") var maxSavingPercentage: Int? = null,
    @SerializedName("rating") var rating: RatingModel? = null,
    @SerializedName("image_list") var imagesList: ArrayList<String>? = null,
    @SerializedName("summary") var summary: SummaryModel? = null,
    @SerializedName("seller_entity") var seller: SellerModel? = null
)