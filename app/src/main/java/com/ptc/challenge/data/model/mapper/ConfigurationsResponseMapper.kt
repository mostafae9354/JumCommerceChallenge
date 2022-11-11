package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.GetConfigurationsResponse
import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity

fun GetConfigurationsResponse.toEntity() = GetConfigurationsResponseEntity(
    success = success,
    session = session?.toEntity(),
    metadata = metadata?.toEntity()
)