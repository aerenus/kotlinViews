package com.example.calc

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import javax.net.ssl.HandshakeCompletedEvent

class MainActivity4 : AppCompatActivity() {

    var number = 0
    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        setSupportActionBar(findViewById(R.id.toolbar))

        title = "Runnables (4)"


        // Initialize the handler instance
        mHandler = Handler(Looper.getMainLooper())

        start.setOnClickListener{
            start.isClickable = false
            status.text = "Running..."
            mRunnable = Runnable {

                number += 1
                println("Current val: $number")

                numberField.text = number.toString()
                mHandler.postDelayed(
                    mRunnable, // Runnable
                    1000 // Delay in milliseconds
                )
            }

            // Schedule the task to repeat after 1 second
            mHandler.postDelayed(
                mRunnable, // Runnable
                1000 // Delay in milliseconds
            )
        }


        stop.setOnClickListener{
            if(number>0){
                start.isClickable = true
            mHandler.removeCallbacks(mRunnable)
            status.text = "Stopped..."
            println("Runnable done.")
            }
        }

        stop.setOnLongClickListener {
            if(number>0){
                start.isClickable = true
                mHandler.removeCallbacks(mRunnable)
                number = 0
                numberField.text = "0"
            }
            status.text = ""
            true

        }






        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Mail servers are offline", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }



}
