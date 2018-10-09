package com.mydomain.god_tm.app_practice_midterm_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Fibonacci : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)

        // launch the non - recursive generator
        var fiboNonRecursive = findViewById<Button>(R.id.fibo_non_recursive)
        fiboNonRecursive.setOnClickListener{

            var nonRecursiveFiboGenerator = Intent(this , FiboNonRecursive::class.java)
            startActivity(nonRecursiveFiboGenerator)
        }

        // launch the recursive generator
        var fiboRecursive = findViewById<Button>(R.id.fibo_recursive)
        fiboRecursive.setOnClickListener {
            var recursiveFiboGenerator = Intent(this, FiboNonRecursive::class.java)
            startActivity(recursiveFiboGenerator)
        }

        //end the activity

        var endFiboCal = findViewById<Button>(R.id.back_fibo_main)

        endFiboCal.setOnClickListener {

            finish()
        }
    }


}
