package com.aelfattah.ahmed.socketchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B:ViewBinding,VM:ViewModel>:AppCompatActivity() {

    protected abstract val viewModel: VM

    private var _binding: B? = null
    val binding: B get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getActivityBinding()
        setContentView(binding.root)
    }

    abstract fun getActivityBinding(): B

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}