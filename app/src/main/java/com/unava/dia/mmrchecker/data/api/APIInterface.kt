package com.unava.dia.mmrchecker.network

import com.unava.dia.mmrchecker.data.AccInformation
import com.unava.dia.mmrchecker.data.Contributor
import kotlinx.coroutines.Deferred
import retrofit2.Response

import retrofit2.http.*
import retrofit2.http.GET



interface APIInterface {
    // Get Player Profile
    @GET("players/{accountId}")
    //Observable<AccInformation> getAccountInformation(@Path("accountId") String accountId);
    //fun getPlayerInfo(@Path("accountId") accountId: String): Deferred<Response<AccInformation>>
	fun getPlayerInfo(@Path("accountId") accountId: String): Deferred<Response<AccInformation>>

    @GET("repos/{owner}/{repo}/contributors")
    fun repoContributors(@Path("owner") owner: String,@Path("repo") repo: String
    ): Deferred<Response<Contributor>>
}