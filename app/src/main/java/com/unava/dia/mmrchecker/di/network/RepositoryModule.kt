package com.unava.dia.mmrchecker.di.network

import com.unava.dia.mmrchecker.data.api.ApiFactory
import com.unava.dia.mmrchecker.data.api.ProfileRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideProfileRepository(): ProfileRepository {
        return ProfileRepository(ApiFactory.apiInstance)
    }
}