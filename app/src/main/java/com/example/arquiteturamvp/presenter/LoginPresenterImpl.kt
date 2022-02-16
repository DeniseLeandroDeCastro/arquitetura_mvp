package com.example.arquiteturamvp.presenter

import android.content.Intent
import com.example.arquiteturamvp.enums.LoginState
import com.example.arquiteturamvp.model.UserContractImpl
import com.example.arquiteturamvp.view.LoginContract

class LoginPresenterImpl(internal var loginContract: LoginContract) {
    fun onLogin(email: String, password: String) {
        val user = UserContractImpl(email, password)
        val loginCode = user.isDataValid()
        if (loginCode == LoginState.OTHER_ERROR)
            loginContract.onLoginError("Falha ao tentar fazer login.")
        else if (loginCode == LoginState.LOGIN_EMAIL_ERROR)
            loginContract.onLoginError("Email inválido!")
        else if (loginCode == LoginState.LOGIN_PASSWORD_ERROR)
            loginContract.onLoginError("Senha inválida!")
        else
            loginContract.onLoginSuccess("Login efetuado com sucesso!")
    }
}