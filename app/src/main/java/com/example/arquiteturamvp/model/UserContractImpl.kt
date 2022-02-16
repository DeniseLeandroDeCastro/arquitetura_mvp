package com.example.arquiteturamvp.model

import android.text.TextUtils
import android.util.Patterns
import com.example.arquiteturamvp.enums.LoginState

class UserContractImpl(override val email: String, override  val password: String) : UserContract {
    override fun isDataValid(): LoginState {
        if (TextUtils.isEmpty(email))
            return (LoginState.OTHER_ERROR) //Outros erros de autenticação
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return (LoginState.LOGIN_EMAIL_ERROR) //Erro no endereço de email
        else if (password.length <= 6)
            return (LoginState.LOGIN_PASSWORD_ERROR) //Erro na senha
        else
            return (LoginState.LOGIN_SUCCESS) //Login efetuado com sucesso
    }
}