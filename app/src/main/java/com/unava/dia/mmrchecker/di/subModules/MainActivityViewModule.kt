package com.unava.dia.mmrchecker.di.subModules

import android.arch.lifecycle.ViewModel
import com.unava.dia.mmrchecker.ui.MainActivityViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityViewModule {
    @Binds
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}