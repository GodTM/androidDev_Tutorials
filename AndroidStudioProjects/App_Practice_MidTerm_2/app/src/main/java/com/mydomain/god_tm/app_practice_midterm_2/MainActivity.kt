package com.mydomain.god_tm.app_practice_midterm_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var REQUEST_CODE :Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fiboBut = findViewById<Button>(R.id.fibo_main)
        fiboBut.setOnClickListener {
            var fiboIntent = Intent(this, Fibonacci::class.java)
            startActivity(fiboIntent)
        }

        var normalIntent = findViewById<Button>(R.id.normal_intent)

        normalIntent.setOnClickListener {

            var thisIntent= Intent(this,NormalIntent::class.java)
            thisIntent.putExtra("sports" , "football")
            thisIntent.putExtra("country","Singapore")
            thisIntent.putExtra("team size", 11)

            startActivity(thisIntent)// start the act

        }



        var intentBundle =  findViewById<Button>(R.id.intent_bundle)
        intentBundle.setOnClickListener {

            var thisIntent  = Intent(this, BundleIntent::class.java)
            var myBundle:Bundle = Bundle()
            myBundle.putString("country" , "Indonesia")
            myBundle.putString("sport" , "Badminton")
            myBundle.putBoolean("team size" , true)

            thisIntent.putExtras(myBundle) // add the bundle to the intent
            startActivity(thisIntent)// start the act

        }




        var dataPassBack = findViewById<Button>(R.id.data_pass_back)
        dataPassBack.setOnClickListener {

            var myIntent= Intent(this, DataPassBack ::class.java)


            // starts the activity to get a result back
            startActivityForResult(myIntent , REQUEST_CODE) /// this activity is only started to get some result back

        }
    }

    // have to write this function for data Pass Back  print the data returned from  an activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            if(data!!.hasExtra("Continent")){

                val returnedContinent = data.extras.getString("Continent")
                Toast.makeText(this, " Returned Continent = "+ returnedContinent , Toast.LENGTH_LONG).show()
            }
        }
    }
}
