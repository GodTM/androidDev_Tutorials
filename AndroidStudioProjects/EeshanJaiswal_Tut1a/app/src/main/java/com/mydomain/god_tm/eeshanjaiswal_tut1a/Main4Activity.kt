package com.mydomain.god_tm.eeshanjaiswal_tut1a

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btnBack = findViewById<Button>(R.id.button6)
        btnBack.setOnClickListener {

            val intent = Intent()
            intent.putExtra("message" , "acabcli")
            setResult(Activity.RESULT_OK , intent)
            finish() ;

        }
    }
}
