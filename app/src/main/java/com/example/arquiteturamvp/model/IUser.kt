package com.example.arquiteturamvp.model

interface IUser {
    val email: String
    val password: String
    fun isDataValid(): Int
}