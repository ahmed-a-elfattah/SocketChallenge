package com.aelfattah.ahmed.socketchallenge.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.aelfattah.ahmed.socketchallenge.data.repositories.MainRepositoryImpl
import com.aelfattah.ahmed.socketchallenge.data.utils.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest

class MainViewModel constructor(private val mainRepositoryImpl: MainRepositoryImpl) : ViewModel() {
    companion object {
        private const val TAG = "MainViewModel"
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "error: $throwable")
    }
    private var parentJob: Job = Job()
    private val ioScope = CoroutineScope(Dispatchers.IO + parentJob + exceptionHandler)

    init {
        getNewFriend()
    }

    fun addFriend(friendData: HashMap<String, Int>) {
        ioScope.launch {
            mainRepositoryImpl.addNewFriend(friendData = friendData).collectLatest {
                when (it) {
                    is Resource.Error -> Log.e(TAG, "addFriendError: ${it.message}")
                    is Resource.Success<*> -> {
                        Log.e(TAG, "addFriend: added successfully")
                    }
                }
            }
        }
    }

    private fun getNewFriend() {
        ioScope.launch {
            mainRepositoryImpl.getNewFriend().collectLatest {
                when (it) {
                    is Resource.Error -> Log.e(TAG, "getNewFriendError: ${it.message}")
                    is Resource.Success<*> -> {
                        Log.e(TAG, "getNewFriend: ${it.data}")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}