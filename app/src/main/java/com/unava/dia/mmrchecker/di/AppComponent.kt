package com.unava.dia.mmrchecker.di

import android.app.Application
import com.unava.dia.mmrchecker.MmrCheckerApp
import com.unava.dia.mmrchecker.di.network.NetworkModule
import com.unava.dia.mmrchecker.di.network.RepositoryModule
import com.unava.dia.mmrchecker.di.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MmrCheckerApp)
}