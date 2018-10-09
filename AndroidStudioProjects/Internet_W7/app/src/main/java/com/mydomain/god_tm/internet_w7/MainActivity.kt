package com.mydomain.god_tm.internet_w7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var jsonURL = "http:jsonplaceholder.typicode.com/users"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.tv1)
        var btnDownload= findViewById<Button>(R.id.button)

        btnDownload.setOnClickListener {

            InternetJSON(this@MainActivity , jsonURL , textView).execute()
        }
    }
}
