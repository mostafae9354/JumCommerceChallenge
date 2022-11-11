package com.ptc.challenge.presentation.uimodel.mapper

import com.ptc.challenge.domain.entity.ProductEntity
import com.ptc.challenge.presentation.uimodel.ProductUiModel

fun ProductEntity.toUiModel(symbol: String?) = ProductUiModel(
    id = id,
    name = name,
    brand = brand,
    imageUrl = imageUrl,
    price = "$symbol $price",
    specialPrice = "$symbol $specialPrice",
    maxSavingPercentage = maxSavingPercentage,
    averageRating = averageRating
)