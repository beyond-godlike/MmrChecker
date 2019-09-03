package com.unava.dia.mmrchecker.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.unava.dia.mmrchecker.data.AccInformation
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel @Inject constructor(private val model: MainActivityModel) : ViewModel() {
    val requestError: MutableLiveData<String> = MutableLiveData()

    var accInfo: MutableLiveData<AccInformation> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun fetchAccInfo(id: String) {
        scope.launch {
            try {
                val response = model.getPlayerInfoAsync(id)
                if (response != null) {
                    accInfo.postValue(response)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                requestError.postValue(e.localizedMessage)
            }
        }
    }

    private fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }

}