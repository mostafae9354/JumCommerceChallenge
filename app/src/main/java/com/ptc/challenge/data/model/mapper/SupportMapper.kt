package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.SupportModel
import com.ptc.challenge.domain.entity.SupportEntity

fun SupportModel.toEntity() = SupportEntity(
    phoneNumber = phoneNumber,
    callEnabled = callEnabled,
    email = email
)