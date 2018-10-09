package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FibonacciGenerate_NonRecursive : AppCompatActivity() {


    fun fibonacci( n: Int ):Int{
        var numberOfTimes = n
        var value:Int = 0
        if (n==1 || n==2){
            return 1 ;
        }
        else{

            value = fibonacci(n-1)+ fibonacci(n-2)
            return value
        }
    }


    var output = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci_generate)

        // text field for input
        var fiboInput:EditText =   findViewById(R.id.fiboInput)

        // back Button
        val backFiboNonRecursive = findViewById<Button>(R.id.backFibo)

        // generate Button
        val generateButton  = findViewById<Button>(R.id.generate)


        generateButton.setOnClickListener {

            var numberOfTerms:Int = Integer.valueOf(fiboInput.getText().toString())

            // calculate the 'numberOfTerms' FIbonacci Numbers
            for(i in 1..numberOfTerms){
                var temp =""
                if(i<numberOfTerms-1) {
                     temp = fibonacci(i).toString() + " , "
                    output.append(temp)
                }
                else{
                    temp = fibonacci(i).toString()
                    output.append(temp)
                }
             }
            var resultView:TextView = findViewById(R.id.outputArea)
            resultView.setText(output);

        }

        // finish the activity
        backFiboNonRecursive.setOnClickListener {
            finish()
        }

    }
}
