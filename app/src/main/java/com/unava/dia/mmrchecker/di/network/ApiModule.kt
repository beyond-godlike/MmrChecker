package com.unava.dia.mmrchecker.di.network

import com.unava.dia.mmrchecker.data.api.APIInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : APIInterface {
        return retrofit.create(APIInterface::class.java)
    }
}