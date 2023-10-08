package com.example.androtask1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var history: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data:Intent? = result.data
                val returnString:String? = data?.getStringExtra("history")
                history.text = returnString

            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        history = findViewById(R.id.history)
        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)

        val paket = intent.extras
        if (paket != null) {
            etUsername.setText(paket.getString("username"))
            etPassword.setText(paket.getString("password"))
        }

        val btnLogin : Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_login -> {
                    val pindah = Intent(this@LoginActivity, MainActivity::class.java)
                    pindah.putExtra("User",User(etUsername.text.toString(),etPassword.text.toString()))
//                    startActivity(pindah)
                    resultLauncher.launch(pindah)
                }
            }
        }
    }
}