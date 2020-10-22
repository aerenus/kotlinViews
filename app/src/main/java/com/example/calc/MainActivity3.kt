package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        title = "3rd Screen (3)"

        val intent = intent
        val getStr = intent.getStringExtra("redirVal")
        textView5.text = getStr

        object  : CountDownTimer(10000,1000) {
            override fun onFinish() {
             val toFirst = Intent(applicationContext,MainActivity::class.java)
             startActivity(toFirst)
                finish()
            }

            override fun onTick(p0: Long) {
                val msToS = p0/1000
                textView7.text = msToS.toString()
            }

        }.start()

    }
}