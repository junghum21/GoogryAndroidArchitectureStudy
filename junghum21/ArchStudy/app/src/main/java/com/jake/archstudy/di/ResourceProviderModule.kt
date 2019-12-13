package com.jake.archstudy.di

import com.jake.archstudy.util.ResourceProvider
import com.jake.archstudy.util.ResourceProviderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ResourceProviderModule {

    @Binds
    abstract fun provideResourceProviderModule(
        resourceProviderImpl: ResourceProviderImpl
    ): ResourceProvider
}