package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class SessionModel(

    @SerializedName("id") var id: String? = null,
    @SerializedName("expire") var expire: String? = null,
    @SerializedName("YII_CSRF_TOKEN") var token: String? = null
)