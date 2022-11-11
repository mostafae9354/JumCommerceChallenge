package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class SupportModel(

    @SerializedName("phone_number") var phoneNumber: String? = null,
    @SerializedName("call_to_order_enabled") var callEnabled: Boolean? = null,
    @SerializedName("cs_email") var email: String? = null
)