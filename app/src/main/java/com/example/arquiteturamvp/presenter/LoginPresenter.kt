package com.example.arquiteturamvp.presenter

import com.example.arquiteturamvp.model.User
import com.example.arquiteturamvp.view.ILoginView

class LoginPresenter(internal var iLoginView: ILoginView): ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode = user.isDataValid()
        if (loginCode == 0)
            iLoginView.onLoginError("O e-mail não pode ser vazio!")
        else if (loginCode == 1)
            iLoginView.onLoginError("Endereço de e-mail errado!")
        else if (loginCode == 2)
            iLoginView.onLoginError("A senha deve ter mais do que 6 caracteres.")
        else
            iLoginView.onLoginSuccess("Login efetuado com sucesso!")
    }
}