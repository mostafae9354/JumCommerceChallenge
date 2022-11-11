package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.GetProductsListResponse
import com.ptc.challenge.domain.entity.GetProductsListResponseEntity

fun GetProductsListResponse.toEntity() = GetProductsListResponseEntity(
    success = success,
    metadata = metadata?.toEntity()
)