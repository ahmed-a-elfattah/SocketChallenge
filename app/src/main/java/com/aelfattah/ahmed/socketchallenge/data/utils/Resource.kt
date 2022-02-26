package com.aelfattah.ahmed.socketchallenge.data.utils

sealed class Resource() {
    data class Success<T>(val data: T) : Resource()
    data class Error(val message: String) : Resource()
}
