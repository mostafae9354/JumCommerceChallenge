package com.ptc.challenge.data.source.preference

import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity

interface PreferenceStore {

    fun setConfigurations(configurations: GetConfigurationsResponseEntity)

    fun getConfigurations(): GetConfigurationsResponseEntity?
}