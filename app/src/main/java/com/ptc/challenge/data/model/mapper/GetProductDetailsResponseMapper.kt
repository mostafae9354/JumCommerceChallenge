package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.GetProductDetailsResponse
import com.ptc.challenge.domain.entity.GetProductDetailsResponseEntity

fun GetProductDetailsResponse.toEntity() = GetProductDetailsResponseEntity(
    success = success,
    metadata = metadata?.toEntity()
)