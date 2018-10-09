package com.mydomain.god_tm.tut3_practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class StaticActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static)



        var backButStatic = findViewById<Button>(R.id.backButStatic)

        backButStatic.setOnClickListener {

            finish()
        }

    }
}
