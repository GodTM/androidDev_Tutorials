package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Fibonacci_Numbers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci__numbers)

        val fibonacci_non_recursive = findViewById<Button>(R.id.button7)
        fibonacci_non_recursive.setOnClickListener {
            val calculateFibonacci1 = Intent(this , FibonacciGenerate_NonRecursive::class.java)
            startActivity(calculateFibonacci1)

        }


        val fibonacci_recursive = findViewById<Button>(R.id.button8)
        fibonacci_recursive.setOnClickListener {

            val calculateFibonacci2 = Intent(this , FibonacciGenerate_NonRecursive::class.java)
            startActivity(calculateFibonacci2)
        }


        // going back
        val goBack = findViewById<Button>(R.id.button9)
        goBack.setOnClickListener {
            finish()
        }


    }
    
}
