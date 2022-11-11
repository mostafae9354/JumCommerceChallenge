package com.ptc.challenge.di

import com.ptc.challenge.data.repository.ConfigurationsRepositoryImpl
import com.ptc.challenge.data.source.remote.ConfigurationsService
import com.ptc.challenge.domain.repository.ConfigurationsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ConfigurationsModule {

    companion object {
        @Provides
        @ViewModelScoped
        fun provideConfigurationsService(retrofit: Retrofit): ConfigurationsService =
            retrofit.create(ConfigurationsService::class.java)
    }

    @Binds
    @ViewModelScoped
    abstract fun bindConfigurationsRepository(impl: ConfigurationsRepositoryImpl): ConfigurationsRepository
}