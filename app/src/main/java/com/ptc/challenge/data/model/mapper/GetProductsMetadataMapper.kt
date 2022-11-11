package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.GetProductsListMetadata
import com.ptc.challenge.domain.entity.GetProductsListMetadataEntity

fun GetProductsListMetadata.toEntity() = GetProductsListMetadataEntity(
    sortBy = sortBy,
    totalProducts = totalProducts,
    title = title,
    results = results?.map { it.toEntity() } as ArrayList
)