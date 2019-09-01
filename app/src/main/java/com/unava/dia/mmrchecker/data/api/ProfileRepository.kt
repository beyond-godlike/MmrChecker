package com.unava.dia.mmrchecker.data.api

import com.unava.dia.mmrchecker.data.AccInformation

class ProfileRepository(private val api: APIInterface) : BaseRepository() {
    suspend fun getPlayerInfoAsync(id: String): AccInformation? {

        return safeApiCall(
            call = { api.getPlayerInfo(id).await() },
            errorMessage = "Error fetching player info"
        )
    }
}