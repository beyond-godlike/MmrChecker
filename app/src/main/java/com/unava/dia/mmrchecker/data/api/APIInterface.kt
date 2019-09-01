package com.unava.dia.mmrchecker.data.api

import com.unava.dia.mmrchecker.data.AccInformation
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface APIInterface {
    // Get Player Profile
    @GET("players/{accountId}")
    fun getPlayerInfo(@Path("accountId") accountId: String): Deferred<Response<AccInformation>>
}