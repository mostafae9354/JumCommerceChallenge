package com.ptc.challenge.domain.entity

data class ConfigurationsMetadataEntity(

    var currency: CurrencyEntity? = null,
    var languages: ArrayList<LanguageEntity>? = null,
    var support: SupportEntity? = null
)