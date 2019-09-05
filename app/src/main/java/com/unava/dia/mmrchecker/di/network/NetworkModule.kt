package com.unava.dia.mmrchecker.di.network

import dagger.Module

@Module(includes = [
        RetrofitModule::class,
        ApiModule::class,
        RepositoryModule::class
])
abstract class NetworkModule