package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class RatingModel(

    @SerializedName("average") var average: Int? = null,
    @SerializedName("ratings_total") var total: Int? = null
)