package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.activity_main5_row.*
import android.content.Intent as Intent1

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        title = "List View (5)"




    }

    override fun onResume() {
        super.onResume()
        var zero = 0
        var maxNum = 10
        var listSource = ArrayList<String>()

        while (zero<=maxNum) {
            listSource.add("List View Element $zero")
            zero += 1
        }

        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listSource)
        val adapter = ArrayAdapter(this,R.layout.activity_main5_row,R.id.cell,listSource)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent1(applicationContext,MainActivity6::class.java)
            intent.putExtra("textView8",listSource[i])
            startActivity(intent)

        }
    }
}
