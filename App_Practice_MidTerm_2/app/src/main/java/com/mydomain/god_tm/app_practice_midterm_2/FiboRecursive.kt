package com.mydomain.god_tm.app_practice_midterm_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FiboRecursive : AppCompatActivity() {

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
        setContentView(R.layout.activity_fibo_recursive)


        // input and output area
        var outputArea = findViewById<TextView>(R.id.output_recursive_fibo)
        var inputArea  = findViewById<EditText>(R.id.input_recursive_fibo)




        var generate = findViewById<Button>(R.id.generate_recursive_fibo)

        generate.setOnClickListener{

            var numberOfTerms:Int ;
            var array:Array<Int?> ;

            try{
                numberOfTerms = Integer.parseInt(inputArea.getText().toString().trim())
                array = fibonacciGenerateRecursive(numberOfTerms)

                var string = StringBuilder()

                for(i in 0..numberOfTerms){
                    if(i<numberOfTerms-1){
                        string.append(array.get(i)).append(", ")
                    }
                    else{
                        string.append(array.get(i))
                    }
                }

                // display output
                outputArea.setText(string)

            }catch(e:NumberFormatException){
                println(e.toString()) ;
            }


        }

        // end the activity
        var backButThis = findViewById<Button>(R.id.back_recursive_fibo)
        backButThis.setOnClickListener {
            finish()
        }


    }


}
