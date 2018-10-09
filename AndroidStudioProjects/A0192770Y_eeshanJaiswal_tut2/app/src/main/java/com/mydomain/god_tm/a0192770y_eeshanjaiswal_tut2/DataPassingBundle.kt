package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class DataPassingBundle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_passing_bundle)

        var sportsType:String = intent.getStringExtra("Sports")
        var country:String = intent.getStringExtra("Country")
        var team:Boolean  = intent.getBooleanExtra("Team Size",false)

        Toast.makeText(this,"Data passed from calling activity:  Country = "+country+" sportsType = "+sportsType+" It's a team sport = "+team , Toast.LENGTH_LONG).show()

        val button_data_passing_bundle = findViewById<Button>(R.id.intent_data_passing_back_bundle_1)
        button_data_passing_bundle.setOnClickListener {


            finish()
        }
    }
}
