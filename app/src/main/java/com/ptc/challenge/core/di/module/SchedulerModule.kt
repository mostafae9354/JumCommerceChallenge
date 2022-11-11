package com.ptc.challenge.core.di.module

import com.ptc.challenge.core.di.qualifier.IoScheduler
import com.ptc.challenge.core.di.qualifier.MainScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
@InstallIn(SingletonComponent::class)
object SchedulerModule {
    @Provides
    @IoScheduler
    fun provideIoScheduler() = Schedulers.io()

    @Provides
    @MainScheduler
    fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()
}