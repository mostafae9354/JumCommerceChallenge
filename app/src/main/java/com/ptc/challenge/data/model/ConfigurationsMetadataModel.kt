package com.ptc.challenge.data.model

data class ConfigurationsMetadataModel(

    var currency: CurrencyModel? = null,
    var languages: ArrayList<LanguageModel>? = null,
    var support: SupportModel? = null
)