package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.GetProductDetailsMetadata
import com.ptc.challenge.domain.entity.GetProductDetailsMetadataEntity

fun GetProductDetailsMetadata.toEntity() = GetProductDetailsMetadataEntity(
    id = id,
    name = name,
    brand = brand,
    price = price,
    specialPrice = specialPrice,
    maxSavingPercentage = maxSavingPercentage,
    rating = rating?.toEntity(),
    imagesList = imagesList,
    summary = summary?.toEntity(),
    seller = seller?.toEntity()
)