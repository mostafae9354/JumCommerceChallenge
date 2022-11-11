package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.SellerModel
import com.ptc.challenge.domain.entity.SellerEntity

fun SellerModel.toEntity() = SellerEntity(
    id = id,
    name = name,
    deliveryTime = deliveryTime
)