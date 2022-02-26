package com.aelfattah.ahmed.socketchallenge.ui.main

import com.aelfattah.ahmed.socketchallenge.databinding.ActivityMainBinding
import com.aelfattah.ahmed.socketchallenge.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

}