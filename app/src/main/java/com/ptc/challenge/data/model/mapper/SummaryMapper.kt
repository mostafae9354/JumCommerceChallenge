package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.SummaryModel
import com.ptc.challenge.domain.entity.SummaryEntity

fun SummaryModel.toEntity() = SummaryEntity(
    description = description,
    shortDescription = shortDescription
)