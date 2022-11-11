package com.ptc.challenge.data.model

data class GetConfigurationsResponse(

    var success: Boolean? = null,
    var session: SessionModel? = null,
    var metadata: ConfigurationsMetadataModel? = null
)