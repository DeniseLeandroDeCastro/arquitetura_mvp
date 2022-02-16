package com.example.arquiteturamvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.arquiteturamvp.home.HomeActivity
import com.example.arquiteturamvp.presenter.LoginPresenterImpl
import com.example.arquiteturamvp.view.LoginContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract {
    internal lateinit var loginPresenterImpl: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenterImpl = LoginPresenterImpl(this)

        btn_login.setOnClickListener {
            loginPresenterImpl.onLogin(edt_email.text.toString(), edt_password.text.toString())
            val home = Intent(this, HomeActivity::class.java)
            startActivity(home)
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}