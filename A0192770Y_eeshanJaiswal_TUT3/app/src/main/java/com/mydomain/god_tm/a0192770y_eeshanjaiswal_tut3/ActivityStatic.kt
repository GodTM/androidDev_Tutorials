package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ActivityStatic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static)

        // go back ..finish activity
        var backButStatic = findViewById<Button>(R.id.staticActBackBut)
        backButStatic.setOnClickListener {
            finish() ;
        }
    }
}
