package com.ptc.challenge.data.source.remote

import com.ptc.challenge.data.model.GetConfigurationsResponse
import retrofit2.http.GET

interface ConfigurationsService {
    @GET("configurations/")
    suspend fun getConfigurations(): GetConfigurationsResponse
}