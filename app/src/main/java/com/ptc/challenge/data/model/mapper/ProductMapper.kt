package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.ProductModel
import com.ptc.challenge.domain.entity.ProductEntity

fun ProductModel.toEntity() = ProductEntity(
    id = id,
    name = name,
    brand = brand,
    imageUrl = imageUrl,
    price = price,
    specialPrice = specialPrice,
    maxSavingPercentage = maxSavingPercentage,
    averageRating = averageRating
)