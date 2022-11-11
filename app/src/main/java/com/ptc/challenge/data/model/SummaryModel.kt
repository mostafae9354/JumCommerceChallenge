package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class SummaryModel(

    @SerializedName("description") var description: String? = null,
    @SerializedName("short_description") var shortDescription: String? = null
)