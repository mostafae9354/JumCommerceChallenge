package com.ptc.challenge.domain.repository

import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity

interface ConfigurationsRepository {
    suspend fun getConfigurations(): GetConfigurationsResponseEntity
}