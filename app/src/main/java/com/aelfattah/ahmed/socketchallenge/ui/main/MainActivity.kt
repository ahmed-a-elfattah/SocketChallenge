package com.aelfattah.ahmed.socketchallenge.ui.main

import android.os.Bundle
import com.aelfattah.ahmed.socketchallenge.databinding.ActivityMainBinding
import com.aelfattah.ahmed.socketchallenge.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val friendData = HashMap<String, Int>()
        friendData["myId"] = 1
        friendData["friendId"] = 2
        viewModel.addFriend(friendData = friendData)
    }
}