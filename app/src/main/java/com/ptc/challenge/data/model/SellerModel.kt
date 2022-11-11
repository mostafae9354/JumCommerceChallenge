package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class SellerModel(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("delivery_time") var deliveryTime: String? = null
)