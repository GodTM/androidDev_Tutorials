package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut3

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialising the static Activity
        val staticActivity = findViewById<Button>(R.id.staticFragBut)
        staticActivity.setOnClickListener {

            val staticIntent = Intent(this , ActivityStatic::class.java)
            startActivity(staticIntent)

        }

        // initialising the dynamic Activity
        val dynamicActivity = findViewById<Button>(R.id.dynamicFragBut)
        dynamicActivity.setOnClickListener {

            val dynamicIntent = Intent(this , ActivityDynamic::class.java)
            startActivity(dynamicIntent)
        }

        // initialising the Fragment With Interface
        val actWithInterface = findViewById<Button>(R.id.actInterfaceBut)
        actWithInterface.setOnClickListener {

            val activityWithInterfaceIntent = Intent(this , ActivityInterface::class.java)
            startActivity(activityWithInterfaceIntent)
        }
    }
}
