package com.mydomain.god_tm.eeshanjaiswal_tut1a

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class ActivityIntent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val btn2  = findViewById<Button>(R.id.button5)
        btn2.setOnClickListener {

            this.onBackPressed()
        }

        Toast.makeText(this , "I am an Activity Content" , Toast.LENGTH_LONG).show()
    }


}
