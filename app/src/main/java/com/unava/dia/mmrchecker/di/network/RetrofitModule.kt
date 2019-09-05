package com.unava.dia.mmrchecker.di.network

import com.unava.dia.mmrchecker.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return RetrofitFactory.retrofit()
    }
}