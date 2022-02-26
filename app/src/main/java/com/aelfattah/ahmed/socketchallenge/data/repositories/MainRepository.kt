package com.aelfattah.ahmed.socketchallenge.data.repositories

import com.aelfattah.ahmed.socketchallenge.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun addNewFriend(friendData: HashMap<String, Int>): Flow<Resource>

    fun getNewFriend(): Flow<Resource>
}