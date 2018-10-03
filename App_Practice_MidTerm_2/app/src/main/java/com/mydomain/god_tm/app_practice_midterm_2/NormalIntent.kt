package com.mydomain.god_tm.app_practice_midterm_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class NormalIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_intent)

        var country: String = intent.getStringExtra("country")
        var sports :String = intent.getStringExtra("sports")
        var players:Int = intent.getIntExtra("team size" , -1)

        if(players == -1){

            println("Error")
            finish()
        }
        Toast.makeText(this , " COUNTRY = "+ country +" sports = "+ sports +" team size = "+players.toString(), Toast.LENGTH_LONG).show()


        // end this activity
        var backButton = findViewById<Button>(R.id.backBut_NI)
        backButton.setOnClickListener {

            finish()
        }

    }
}
