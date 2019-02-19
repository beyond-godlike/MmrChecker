package com.unava.dia.mmrchecker.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiFactory {
    private var interceptor = Interceptor { chain->
        val newUrl = chain.request().url()
            .newBuilder()
            .build()

        val newRequest = chain.request().newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.opendota.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val apiInstance : APIInterface = retrofit().create(APIInterface::class.java)
}