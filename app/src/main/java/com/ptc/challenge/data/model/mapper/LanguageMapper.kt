package com.ptc.challenge.data.model.mapper

import com.ptc.challenge.data.model.LanguageModel
import com.ptc.challenge.domain.entity.LanguageEntity

fun LanguageModel.toEntity() = LanguageEntity(
    name = name,
    code = code,
    default = default
)