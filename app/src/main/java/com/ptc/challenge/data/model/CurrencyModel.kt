package com.ptc.challenge.data.model

import com.google.gson.annotations.SerializedName

data class CurrencyModel(

    @SerializedName("iso") var iso: String? = null,
    @SerializedName("currency_symbol") var symbol: String? = null,
    @SerializedName("position") var position: Int? = null,
    @SerializedName("decimals") var decimals: Int? = null,
    @SerializedName("thousands_sep") var thousandsSep: String? = null,
    @SerializedName("decimals_sep") var decimalsSep: String? = null
)