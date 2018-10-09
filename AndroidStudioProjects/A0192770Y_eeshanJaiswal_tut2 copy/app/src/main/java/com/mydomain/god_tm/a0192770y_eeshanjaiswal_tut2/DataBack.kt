package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class DataBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_back)


        val buttonDataBack = findViewById<Button>(R.id.dataBack_back)
        buttonDataBack.setOnClickListener {

            val intentToBePassedBack  = Intent()
            intentToBePassedBack.putExtra("Continent" , "Asia")
            setResult(Activity.RESULT_OK,intentToBePassedBack)
            finish()
        }

    }





}
