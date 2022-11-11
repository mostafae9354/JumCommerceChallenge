package com.ptc.challenge.domain.usecase

import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity
import com.ptc.challenge.domain.repository.ConfigurationsRepository
import javax.inject.Inject

class GetConfigurationsUseCase @Inject constructor(private val repository: ConfigurationsRepository) {
    suspend operator fun invoke(): GetConfigurationsResponseEntity {
        return repository.getConfigurations()
    }
}