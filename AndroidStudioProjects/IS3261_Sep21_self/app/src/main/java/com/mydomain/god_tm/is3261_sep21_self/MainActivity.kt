package com.mydomain.god_tm.is3261_sep21_self

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var broadCast1 = findViewById<Button>(R.id.button)

        broadCast1.setOnClickListener {


        }
    }
}
