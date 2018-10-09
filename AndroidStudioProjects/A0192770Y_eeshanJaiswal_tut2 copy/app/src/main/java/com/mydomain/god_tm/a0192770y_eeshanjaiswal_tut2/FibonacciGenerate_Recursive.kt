package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FibonacciGenerate_Recursive : AppCompatActivity() {


    // dynamic programming
    fun fibonacciGenerateRecursive(n:Int) :Array<Int?>{
        var firstAndSecondvalue =  1

        val array = arrayOfNulls<Int>(n+2)
        array.set(0 , firstAndSecondvalue)
        array.set(1,firstAndSecondvalue)


        for(i in 0..n+2){
            if(i==1 || i==0){
                continue
            }
            array.set(i,0)
            if(i>1){
                if(array.get(i)!= null) {
                    var value = array.get(n - 1)!! + array.get(n - 2)!! // !! forcibly converts values into not null types
                    array.set(n,value) // set the value of the index in the array by the next term
                }
            }
        }

        return array

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci_generate__recursive)

        // text input field on the Recursive fibo generator
        var fiboInputRecursive:EditText = findViewById(R.id.fiboInputRecursive)

        // generate button
        var generateButtonRecursive = findViewById<Button>(R.id.generateFiboRecursiveBut)

        // outputArea

        var resultArea = findViewById<TextView>(R.id.fiboRecursiveOutput)

        generateButtonRecursive.setOnClickListener {
            var numberOfTerms:Int ;
            var array:Array<Int?> ;

            try {
                 numberOfTerms = Integer.valueOf(fiboInputRecursive.getText().toString())
                 array = arrayOfNulls<Int?>(numberOfTerms)

                array = fibonacciGenerateRecursive(numberOfTerms)

                // declare a string Builder a append all the elements of the array into the the string and attaching it to the Text Display
                var string = StringBuilder()

                for(i in 0..numberOfTerms){
                    if(i<numberOfTerms-1) {
                        string.append(array.get(i)).append(" , ")
                    }
                    else{
                        string.append(array.get(i))
                    }
                }
                resultArea.setText(string)

            }catch(e:NumberFormatException ){
                println(e.toString())
            }

        }
    }
}
