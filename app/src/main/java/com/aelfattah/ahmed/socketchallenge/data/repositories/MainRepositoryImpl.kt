package com.aelfattah.ahmed.socketchallenge.data.repositories

import com.aelfattah.ahmed.socketchallenge.data.sources.remote.FriendService

class MainRepositoryImpl constructor(private val friendService: FriendService) :
    MainRepository {
    override fun addNewFriend(friendData: HashMap<String, Int>) =
        friendService.addNewFriend(friendData = friendData)

    override fun getNewFriend() =
        friendService.getNewFriend()
}