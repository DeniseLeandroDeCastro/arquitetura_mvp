package com.example.arquiteturamvp.model

import android.text.TextUtils
import android.util.Patterns


class User(override val email: String, override  val password: String) : IUser {
    override fun isDataValid(): Int {
        if (TextUtils.isEmpty(email))
            return 0 //Código de erro para email vazio
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1 //Código de erro para padrão errado
        else if (password.length <= 6)
            return 2 //Código de erro para tamanho da senha, que deve ser maior ou igual a 6
        else
            return -1 //Login efetuado com sucesso
    }

}