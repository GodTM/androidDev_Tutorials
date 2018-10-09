package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var context : Context
    lateinit var receiver:MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var displayDetails = findViewById<Button>(R.id.saveTime)
        var retrieve = findViewById<Button>(R.id.retrieve)
        context = this


        displayDetails.setOnClickListener {

            val intent = Intent(this , )
        }


        retrieve.setOnClickListener {


        }

    }


    // for getting all the system data from the
    private fun getDetails(){


    }





}
