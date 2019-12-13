package com.jake.archstudy.di

import com.jake.archstudy.ui.main.MainActivity
import com.jake.archstudy.ui.tickers.TickersFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            TickersFragmentModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}