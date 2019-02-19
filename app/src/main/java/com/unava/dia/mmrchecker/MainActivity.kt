package com.unava.dia.mmrchecker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.unava.dia.mmrchecker.data.AccInformation
import com.unava.dia.mmrchecker.network.APIInterface
import com.unava.dia.mmrchecker.network.ApiFactory
import com.unava.dia.mmrchecker.network.ProfileRepository
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    var playerId: String = "235632094"
    var accInfo: AccInformation? = null
    var avatarUrl: String? = null

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
    get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : ProfileRepository = ProfileRepository(ApiFactory.apiInstance)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accInfo = AccInformation()

        buttonSearchPlayer.setOnClickListener {
            fetchAccInfo(playerId)

            textViewEstimatedMmr.text = accInfo?.mmr_estimate?.estimate.toString()
            textViewSoloMmr.text = accInfo?.solo_competitive_rank
            textViewPartyMmr.text = accInfo?.competitive_rank
        }
    }
	
    private fun fetchAccInfo(id: String) {
		scope.launch {
            accInfo = repository.getPlayerInfo(id)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}
