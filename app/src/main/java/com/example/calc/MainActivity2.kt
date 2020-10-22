package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        title = "Data Movements and Warnings (2)"

        var intent   = intent
        var getStr = intent.getStringExtra("textView3") ?: "No data"
        textView3.text = getStr

        Toast.makeText(applicationContext,getStr,Toast.LENGTH_LONG).show()
       // ya da Toast.makeText(this,getStr,Toast.LENGTH_LONG).show()
       // ya da Toast.makeText(this@MainActivity2,getStr,Toast.LENGTH_LONG).show()

        button5.setOnClickListener{
        val alert = AlertDialog.Builder(this)
            alert.setTitle("Warning")
            alert.setMessage("All info will be sent to main server. Are you sure?")
            alert.setPositiveButton("Yes"){dialogInterface, i ->
                println("Accepted.")
                var intentRedir = Intent(applicationContext,MainActivity3::class.java)
                intentRedir.putExtra("redirVal",textView3.text.toString())
                startActivity(intentRedir)
            }
            alert.setNegativeButton("No") {dialogInterface, i ->
                println("Declined.")
            }
            alert.show()
        }

        button6.setOnClickListener{
            var intentRunnable = Intent(applicationContext,MainActivity4::class.java)
            startActivity(intentRunnable)
        }

        toListView.setOnClickListener {
            var intentList = Intent(applicationContext,MainActivity5::class.java)
            startActivity(intentList)
        }

        button7.setOnClickListener {
            var intentSQL = Intent(applicationContext,MainActivity7::class.java)
            startActivity(intentSQL)
        }


    }


}
