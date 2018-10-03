package com.mydomain.god_tm.app_practice_midterm_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class BundleIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle_intent)


        var country:String  = intent.getStringExtra("country")
        var sport:String = intent.getStringExtra("sport")
        var teamSize:Boolean = intent.getBooleanExtra("team size",false)

        Toast.makeText(this , "country = "+country.toString()+" sports = "+sport.toString()+" team Size = "+teamSize.toString() , Toast.LENGTH_LONG).show()



        // end the activity
        var backBut  = findViewById<Button>(R.id.backBut_BI)
        backBut.setOnClickListener {

            finish()
        }

    }
}
