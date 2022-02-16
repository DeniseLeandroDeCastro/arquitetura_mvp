package com.example.arquiteturamvp.view

interface LoginContract {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}