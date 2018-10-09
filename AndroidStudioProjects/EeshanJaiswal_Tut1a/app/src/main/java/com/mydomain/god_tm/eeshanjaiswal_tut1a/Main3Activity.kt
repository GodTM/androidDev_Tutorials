package com.mydomain.god_tm.eeshanjaiswal_tut1a

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var sportsType: String = intent.getStringExtra("sports")
        var teamSize:Int  = intent.getIntExtra("indoor" , 0)

        Toast.makeText(this , "Sports = "+ sportsType+"Size"+teamSize , Toast.LENGTH_LONG).show()
    }
}
