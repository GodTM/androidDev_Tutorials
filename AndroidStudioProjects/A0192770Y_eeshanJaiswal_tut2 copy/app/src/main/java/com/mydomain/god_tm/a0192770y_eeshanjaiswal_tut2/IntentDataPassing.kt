package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class IntentDataPassing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data_passing)


        var country:String = intent.getStringExtra("Country")
        var sportsType:String = intent.getStringExtra("Sports")
        var teamSize:Int = intent.getIntExtra("Team Size",11)
        /*
        *
        *
        * */
        Toast.makeText(this , "Data Passed from Calling Activity: Country = "+country+" Sports = "+sportsType+" teamSize ="+teamSize , Toast.LENGTH_LONG).show()


        // goes back to the original Page
        val backToMain1 = findViewById<Button>(R.id.intent_data_passing_back_1)
        backToMain1.setOnClickListener {

            finish()
        }
    }
}
