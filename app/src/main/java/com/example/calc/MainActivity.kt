package com.example.calc


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Kotlin Base"
      //  saveData()
        val packageNameOnCreate = this.javaClass.`package`?.name
        val shared = getSharedPreferences("${packageNameOnCreate}", Context.MODE_PRIVATE)
        val floatVal = 0.0f
        val floatGet = shared.getFloat("toplamaLog",floatVal)
        println("getting saved content before...")
        println(floatGet)
        textView4.text = "Last calculated value: " + floatGet.toString()
        println("end of getting saved content before...")

    }


    fun toplama (view : View) {
        val sayi1Al = sayi1.text.toString()?.toDoubleOrNull() ?: 0.0
        val sayi2Al = sayi2.text.toString()?.toDoubleOrNull() ?: 0.0
        val sonucAl = sayi1Al+sayi2Al
        val toSaveData = sonucAl.toFloat()
        sonuc.text = "${sonucAl}"
        saveData(toSaveData)
    }

    fun cikarma (view : View) {
        val sayi1Al = sayi1?.text.toString().toDoubleOrNull() ?: 0.0
        val sayi2Al = sayi2?.text.toString().toDoubleOrNull() ?: 0.0
        val sonucAl = sayi1Al-sayi2Al
        val toSaveData = sonucAl.toFloat()
        sonuc.text = "${sonucAl}"
        saveData(toSaveData)
    }

    fun carpma (view : View) {
        val sayi1Al = sayi1?.text.toString().toDoubleOrNull() ?: 0.0
        val sayi2Al = sayi2?.text.toString().toDoubleOrNull() ?: 0.0
        val sonucAl = sayi1Al*sayi2Al
        val toSaveData = sonucAl.toFloat()
        sonuc.text = "${sonucAl}"
        saveData(toSaveData)
    }

    fun bolme (view : View) {
        val sayi1Al = sayi1?.text.toString().toDoubleOrNull() ?: 0.0
        val sayi2Al = sayi2?.text.toString().toDoubleOrNull() ?: 0.0
        val sonucAl = sayi1Al/sayi2Al
        val toSaveData = sonucAl.toFloat()
        sonuc.text = "${sonucAl}"
        saveData(toSaveData)
    }

    fun saveData(toSave : Float){

        val packageName = this.javaClass.`package`?.name
        val sharedPr = this.getSharedPreferences("${packageName}", Context.MODE_PRIVATE)
        sharedPr.edit().putFloat("toplamaLog", toSave).apply()
        val toGet = sharedPr.getFloat("toplamaLog", toSave)
        println("toGet alani yaziliyor...")
        println(toGet)
        textView4.text = "Last calculated value: " + toGet.toString()

        val intent = Intent(applicationContext,MainActivity2::class.java)
        intent.putExtra("textView3", textView4.text.toString())
        startActivity(intent)
    }



    fun segue (view: View) {
        println("btn click")

    }


}
