package com.example.androtask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.edt_username)
        etPassword =findViewById(R.id.edt_password)
        etConfirmPassword = findViewById(R.id.edt_confirm_password)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_register -> {

                    val paket = Bundle()
                    paket.putString("username",etUsername.text.toString())
                    paket.putString("password",etPassword.text.toString() )

                    val pindah = Intent(this@RegisterActivity, LoginActivity::class.java)
                    pindah.putExtras(paket)
                    startActivity(pindah)
                }
            }
        }
    }
}