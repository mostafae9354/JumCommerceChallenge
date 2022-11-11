package com.ptc.challenge.di

import com.ptc.challenge.data.repository.ProductDetailsRepositoryImpl
import com.ptc.challenge.data.source.remote.ProductDetailsService
import com.ptc.challenge.domain.repository.ProductDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDetailsModule {

    companion object {
        @Provides
        @ViewModelScoped
        fun provideProductDetailsService(retrofit: Retrofit): ProductDetailsService =
            retrofit.create(ProductDetailsService::class.java)
    }

    @Binds
    @ViewModelScoped
    abstract fun bindProductDetailsRepository(impl: ProductDetailsRepositoryImpl): ProductDetailsRepository
}