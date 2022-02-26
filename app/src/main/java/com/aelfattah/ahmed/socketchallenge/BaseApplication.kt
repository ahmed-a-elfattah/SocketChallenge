package com.aelfattah.ahmed.socketchallenge

import android.app.Application
import com.aelfattah.ahmed.socketchallenge.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BaseApplication)
            modules(allModules)
        }
    }
}