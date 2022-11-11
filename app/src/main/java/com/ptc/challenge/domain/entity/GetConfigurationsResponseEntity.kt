package com.ptc.challenge.domain.entity

data class GetConfigurationsResponseEntity(

    var success: Boolean? = null,
    var session: SessionEntity? = null,
    var metadata: ConfigurationsMetadataEntity? = null
)