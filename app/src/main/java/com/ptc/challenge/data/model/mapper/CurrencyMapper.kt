package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.CurrencyModel
import com.ptc.challenge.domain.entity.CurrencyEntity

fun CurrencyModel.toEntity() = CurrencyEntity(
    iso = iso,
    symbol = symbol,
    position = position,
    decimals = decimals,
    thousandsSep = thousandsSep,
    decimalsSep = decimalsSep
)