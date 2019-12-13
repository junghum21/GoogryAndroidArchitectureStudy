package com.jake.archstudy.di

import com.jake.archstudy.data.source.UpbitRemoteDataSource
import com.jake.archstudy.data.source.UpbitRepository
import com.jake.archstudy.network.service.UpbitService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideUpbitRemoteDataSource(upbitService: UpbitService): UpbitRemoteDataSource =
        UpbitRemoteDataSource(upbitService)

    @Provides
    @Singleton
    fun provideUpbitRepository(upbitRemoteDataSource: UpbitRemoteDataSource): UpbitRepository =
        UpbitRepository(upbitRemoteDataSource)
}