package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class GetProductsListResponse(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("metadata") var metadata: GetProductsListMetadata? = null
)