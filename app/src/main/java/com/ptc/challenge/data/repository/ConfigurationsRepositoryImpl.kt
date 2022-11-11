package com.ptc.challenge.data.repository

import com.ptc.challenge.data.model.mapper.toEntity
import com.ptc.challenge.data.source.remote.ConfigurationsService
import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity
import com.ptc.challenge.domain.repository.ConfigurationsRepository
import javax.inject.Inject

class ConfigurationsRepositoryImpl @Inject constructor(private val service: ConfigurationsService) :
    ConfigurationsRepository {

    override suspend fun getConfigurations(): GetConfigurationsResponseEntity {
        return service.getConfigurations().toEntity()
    }
}