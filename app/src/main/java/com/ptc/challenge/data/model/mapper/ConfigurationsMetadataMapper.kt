package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.ConfigurationsMetadataModel
import com.ptc.challenge.domain.entity.ConfigurationsMetadataEntity

fun ConfigurationsMetadataModel.toEntity() = ConfigurationsMetadataEntity(
    currency = currency?.toEntity(),
    languages = languages?.map { it.toEntity() } as ArrayList,
    support = support?.toEntity()
)