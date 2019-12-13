package com.jake.archstudy.ui.tickers

import com.jake.archstudy.di.PerFragment
import com.jake.archstudy.di.ResourceProviderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TickersFragmentModule {

    @PerFragment
    @ContributesAndroidInjector(
        modules = [ResourceProviderModule::class]
    )
    abstract fun provideTickersFragment(): TickersFragment
}