package com.mydomain.god_tm.app_practice_midterm_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class DataPassBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pass_back)


        var butBack = findViewById<Button>(R.id.backBut_data_pass_back)
        butBack.setOnClickListener {

            val intentToReturn = Intent()
            intentToReturn.putExtra("Continent", "Asia")
            setResult(Activity.RESULT_OK, intentToReturn)
            finish()

        }


    }
}
