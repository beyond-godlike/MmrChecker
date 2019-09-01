package com.unava.dia.mmrchecker.ui

import com.unava.dia.mmrchecker.data.AccInformation
import com.unava.dia.mmrchecker.data.api.ApiFactory
import com.unava.dia.mmrchecker.data.api.ProfileRepository

class MainActivityModel {
    // TODO inject repository here
    private val repository: ProfileRepository = ProfileRepository(ApiFactory.apiInstance)

    suspend fun getPlayerInfoAsync (id: String): AccInformation? {
        return this.repository.getPlayerInfoAsync(id)
    }
}