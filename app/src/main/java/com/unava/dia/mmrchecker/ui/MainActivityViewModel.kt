package com.unava.dia.mmrchecker.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.unava.dia.mmrchecker.data.AccInformation
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel : ViewModel() {

    val requestResult: MutableLiveData<Boolean> = MutableLiveData()
    val requestErrSubject: MutableLiveData<String> = MutableLiveData()
    val loadingSubject: MutableLiveData<Boolean> = MutableLiveData()

    var accInfo: MutableLiveData<AccInformation> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    // TODO inject model yeah
    private val model = MainActivityModel()

    fun fetchAccInfo(id: String) {
        scope.launch {
            try {
                val response = model.getPlayerInfoAsync(id)
                if (response != null) {
                        accInfo.postValue(response)
                        requestResult.postValue(true)
                    } else {
                        requestResult.postValue(false)
                    }
            } catch (e: Exception) {
                e.printStackTrace()
                loadingSubject.postValue(false)
                requestErrSubject.postValue(e.localizedMessage)
            }
        }
    }

    private fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }

}