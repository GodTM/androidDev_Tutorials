package com.mydomain.god_tm.app_practice_midterm_3

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var staticFragmentBut = findViewById<Button>(R.id.static_but_main)
        staticFragmentBut.setOnClickListener {

            var staticIntent = Intent(this , StaticFragment::class.java)
            startActivity(staticIntent)
        }

        var dynamicFragmentBut = findViewById<Button>(R.id.dyn_but_main)
        dynamicFragmentBut.setOnClickListener {

            var dynamicIntent = Intent(this , DynamicFragment::class.java)
            startActivity(dynamicIntent)

        }

        // set  the
        var fragmentWithInterface = findViewById<Button>(R.id.interface_frag_but_main)
        fragmentWithInterface.setOnClickListener {


        }

    }
}
