package com.unava.dia.mmrchecker.di

import com.unava.dia.mmrchecker.di.subModules.MainActivityViewModule
import com.unava.dia.mmrchecker.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
       MainActivityViewModule::class
    ])
    internal abstract fun bindMainActivity(): MainActivity
}