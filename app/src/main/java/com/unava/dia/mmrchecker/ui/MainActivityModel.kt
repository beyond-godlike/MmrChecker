package com.unava.dia.mmrchecker.ui

import com.unava.dia.mmrchecker.data.AccInformation
import com.unava.dia.mmrchecker.data.api.ProfileRepository
import javax.inject.Inject

class MainActivityModel @Inject constructor(private var repository: ProfileRepository) {
    suspend fun getPlayerInfoAsync(id: String): AccInformation? {
        return this.repository.getPlayerInfoAsync(id)
    }
}