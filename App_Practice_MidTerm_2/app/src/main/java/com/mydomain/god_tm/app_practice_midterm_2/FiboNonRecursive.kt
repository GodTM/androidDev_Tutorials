package com.mydomain.god_tm.app_practice_midterm_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FiboNonRecursive : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibo_non_recursive)

        //the input button :
        var input =  findViewById<EditText>(R.id.input_non_recursive_fibo_generator)



        // the generate button
        var outputArea = findViewById<TextView>(R.id.output_non_recursive_fibo)

        var generate  = findViewById<Button>(R.id.generate_non_recursive_fibo)

        generate.setOnClickListener {

            try{
                var inputValue :Int = Integer.parseInt(input.getText().toString())

                var string = StringBuilder()
                for(i in 1..inputValue){
                    if(i <inputValue) {
                        string.append(fiboNonRecursive(i).toString() + " , ")
                    }else{
                        string.append(fiboNonRecursive(i).toString()+" ")
                    }
                }

                outputArea.setText(string)

            }
            catch(e:NumberFormatException){
                println(e.toString())
            }
        }



        // end the activity
        var backButThis = findViewById<Button>(R.id.back_non_recursive_fibo)
        backButThis.setOnClickListener {

            finish()
        }
    }


    private fun fiboNonRecursive(term:Int?): Int{

        if(term!=null){
            if(term ==1 || term==2){
                return  1 ;
            }
            else{

                return fiboNonRecursive(term -1) + fiboNonRecursive(term-2)
                }
        }
        return -1 // fail safe
         }
    }

