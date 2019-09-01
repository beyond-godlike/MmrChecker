package com.unava.dia.mmrchecker.network

import com.unava.dia.mmrchecker.data.AccInformation

class ProfileRepository(private val api : APIInterface) : BaseRepository() {
    suspend fun getPlayerInfo(id: String) : AccInformation? {
        val accResponse = safeApiCall(
            call = {api.getPlayerInfo(id).await()},
            errorMessage = "Error fetching player info"
        )

        return accResponse
    }
}