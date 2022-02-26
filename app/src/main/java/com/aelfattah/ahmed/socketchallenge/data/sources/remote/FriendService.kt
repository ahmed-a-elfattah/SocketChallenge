package com.aelfattah.ahmed.socketchallenge.data.sources.remote

import com.aelfattah.ahmed.socketchallenge.data.utils.Resource
import io.socket.client.Socket
import io.socket.emitter.Emitter
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class FriendService constructor(private val socket: Socket) {
    companion object {
        const val event: String = "newFriend"
    }

    fun addNewFriend(friendData: HashMap<String, Int>) = callbackFlow {
        try {
            socket.connect()
            socket.emit(event, friendData)
            trySend(Resource.Success(null))
        } catch (e: Exception) {
            trySend(Resource.Error(e.message!!))
        }
        awaitClose {
            socket.disconnect()
        }
    }

    fun getNewFriend() = callbackFlow {
        try {
            socket.connect()
            val emitter = Emitter.Listener {
                trySend(Resource.Success(it))
            }
            socket.on(event, emitter)
        } catch (e: Exception) {
            trySend(Resource.Error(e.message!!))
        }
        awaitClose {
            socket.disconnect()
        }
    }
}