package com.example.androtask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView2)

        val useRname =intent.getParcelableExtra<User>("User")?.username
        val password =intent.getParcelableExtra<User>("User")?.password
        tv.text = "username: $useRname dan Password: $password"

        val btnImplicit : Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_implicit -> {
    //                    val message = "Selamat, Tugas Android Fundamental 1 berhasil"
    //                    val pindah = Intent()
    //                    intent.action = Intent.ACTION_SEND
    //                    intent.putExtra(Intent.EXTRA_TEXT, message)
    //                    intent.type = "text/plain"
    //                    startActivity(pindah)

                    val pindah = Intent()
                    pindah.putExtra("history", "Anda Sudah Login")
                    setResult(RESULT_OK,pindah)
                    finish()
                }
            }
        }
    }
}