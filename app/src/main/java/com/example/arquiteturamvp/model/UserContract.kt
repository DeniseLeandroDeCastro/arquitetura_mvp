package com.example.arquiteturamvp.model

import com.example.arquiteturamvp.enums.LoginState

interface UserContract {
    val email: String
    val password: String
    fun isDataValid(): LoginState
}