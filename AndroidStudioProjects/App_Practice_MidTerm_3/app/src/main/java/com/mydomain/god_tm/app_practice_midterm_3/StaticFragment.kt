package com.mydomain.god_tm.app_practice_midterm_3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class StaticFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // exit the screen
        var backButStatic = findViewById<Button>(R.id.backBut_static_frag)
        backButStatic.setOnClickListener {
            finish()
        }

    }
}
