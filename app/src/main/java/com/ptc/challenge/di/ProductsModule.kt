package com.ptc.challenge.di

import com.ptc.challenge.data.repository.ProductsRepositoryImpl
import com.ptc.challenge.data.source.remote.ProductsService
import com.ptc.challenge.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductsModule {

    companion object {
        @Provides
        @ViewModelScoped
        fun provideProductsService(retrofit: Retrofit): ProductsService =
            retrofit.create(ProductsService::class.java)
    }

    @Binds
    @ViewModelScoped
    abstract fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}