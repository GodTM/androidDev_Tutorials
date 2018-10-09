package com.mydomain.god_tm.tut3_practice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // define all the 3 buttons
        var staticMain = findViewById<Button>(R.id.staticButMain)
        var dynamicMain  = findViewById<Button>(R.id.dynButMain)
        var interfaceButMain = findViewById<Button>(R.id.interfaceButMain)

        staticMain.setOnClickListener {

            var myIntent = Intent(this , StaticActivity::class.java)
            startActivity(myIntent)
        }

        dynamicMain.setOnClickListener {

            var myIntent2 = Intent(this , ActivityDynamic::class.java)
            startActivity(myIntent2)

        }

        interfaceButMain.setOnClickListener {

            var myIntent3 = Intent(this , ActivityInterface::class.java)
            startActivity(myIntent3)
        }

    }
}
