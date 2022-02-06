package com.example.arquiteturamvp.view

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}