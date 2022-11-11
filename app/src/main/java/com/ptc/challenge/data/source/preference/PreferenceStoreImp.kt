package com.ptc.challenge.data.source.preference

import android.content.SharedPreferences
import com.google.gson.Gson
import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity
import javax.inject.Inject

private const val configurationsKey = "configurations"

class PreferenceStoreImp @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) : PreferenceStore {

    override fun setConfigurations(configurations: GetConfigurationsResponseEntity) {

        sharedPreferences.edit().putString(configurationsKey, gson.toJson(configurations)).apply()
    }

    override fun getConfigurations(): GetConfigurationsResponseEntity? {
        return gson.fromJson(
            sharedPreferences.getString(configurationsKey, ""),
            GetConfigurationsResponseEntity::class.java
        )
    }
}