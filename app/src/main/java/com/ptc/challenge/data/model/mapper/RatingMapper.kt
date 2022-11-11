package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.RatingModel
import com.ptc.challenge.domain.entity.RatingEntity

fun RatingModel.toEntity() = RatingEntity(
    average = average,
    total = total
)