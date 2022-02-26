package com.aelfattah.ahmed.socketchallenge.data.models

data class Message(
    val _id: Int,
    val content: String,
    val createdAt: String,
    val seen: Boolean,
    val user: User
)