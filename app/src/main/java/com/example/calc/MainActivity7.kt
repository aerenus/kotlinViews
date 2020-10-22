package com.example.calc

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main7.*
import java.lang.Exception

class MainActivity7 : AppCompatActivity() {

    val dbName = "USERS"
    val dbTable = "data"

    var arrayIdSource = ArrayList<Int>()
    var arrayKeySource = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        title = "SQLite Examples (7)"
    }

    override fun onResume() {
        super.onResume()
        sqlCreateIfNotExist(dbName, dbTable)
        sqlWrite(dbName, dbTable, "column1","column2","eren","faikoglu")
        sqlRead(dbTable)
    }

    fun sqlCreateIfNotExist(dbName: String, table: String){
        val sqldb = openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null)
        try { sqldb.execSQL("CREATE TABLE IF NOT EXISTS $table (id INTEGER PRIMARY KEY,column1 VARCHAR, column2 VARCHAR)")
            Toast.makeText(applicationContext,table + "created/opened..",Toast.LENGTH_LONG).show()
        }
        catch (e: Exception) {
            println("CREATE/OPEN ERROR")
           Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
       }
    }

    fun sqlWrite(dbName: String, table: String, column: String, column2: String, columnVal: String, columnVal2: String){
        val sqldb = openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null)
        try {
        sqldb.execSQL("INSERT INTO $table  ($column, $column2) VALUES ('$columnVal','$columnVal2')")
            Toast.makeText(applicationContext, "A row added to $table",Toast.LENGTH_LONG).show()
        }
        catch (e: Exception) {
            println(e.localizedMessage)
            Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
    }
    }
    //fun sqlRead(table: String, column: String, whereVal: String){
    fun sqlRead(table: String){
        val sqldb = openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null)
        try {
            val cursor = sqldb.rawQuery("SELECT * FROM $dbTable", null)

            val columnIdQuery = cursor.getColumnIndex("id")
            val columnValQuery = cursor.getColumnIndex("column1")

            while (cursor.moveToNext()){
                arrayIdSource.add(cursor.getInt(columnIdQuery))
                arrayKeySource.add(cursor.getString(columnValQuery))
            }
            cursor.close()

            val adapterListSql = ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayKeySource)
            listSql.adapter = adapterListSql

        } catch (e: Exception) {
            Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun sqlDelete(table: String, column: String, whereVal: String){
        val sqldb = openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null)
      //  sqlInit(table)
    }



}