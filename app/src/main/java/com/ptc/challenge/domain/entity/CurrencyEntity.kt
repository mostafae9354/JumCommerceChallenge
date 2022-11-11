package com.ptc.challenge.domain.entity

data class CurrencyEntity(

    var iso: String? = null,
    var symbol: String? = null,
    var position: Int? = null,
    var decimals: Int? = null,
    var thousandsSep: String? = null,
    var decimalsSep: String? = null
)