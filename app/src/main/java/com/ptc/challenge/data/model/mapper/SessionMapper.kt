package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.SessionModel
import com.ptc.challenge.domain.entity.SessionEntity

fun SessionModel.toEntity() = SessionEntity(
    id = id,
    expire = expire,
    token = token
)