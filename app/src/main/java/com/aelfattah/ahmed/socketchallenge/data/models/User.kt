package com.aelfattah.ahmed.socketchallenge.data.models

data class User(
    val createdAt: String,
    val deleted: Boolean,
    val friends: List<Int>,
    val fullname: String,
    val id: Int,
    val img: String,
    val phone: String,
    val updatedAt: String
)