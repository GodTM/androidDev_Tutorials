package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val Code:Int = 1 // what is this code used for ??

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        // activity 1
        /// simply links the current page to the desired activity
        val fibo = findViewById<Button>(R.id.button1)
        fibo.setOnClickListener {
            val intent1 = Intent(this, Fibonacci_Numbers::class.java)
            startActivity(intent1)
        }

        // activity 2 // for Toast Message
        val intentWithDataPassing = findViewById<Button>(R.id.button2)
        intentWithDataPassing.setOnClickListener {
            val dataPassingIntent = Intent(this ,IntentDataPassing::class.java )
            dataPassingIntent.putExtra("Country", "Singapore")
            dataPassingIntent.putExtra("Sports", "FootBall")
            dataPassingIntent.putExtra("TeamSize", 11)

            startActivity(dataPassingIntent)
        }

        //activity 3 // Toast Message using Bundle
        val intentWithDataPassingBundle = findViewById<Button>(R.id.button3)
        intentWithDataPassingBundle.setOnClickListener {
            val dataPassingBundleIntent = Intent(this , DataPassingBundle::class.java)
            val bundle:Bundle = Bundle()
            bundle.putString("Country" ,"Indonesia")
            bundle.putString("Sports" , "Badminton")
            bundle.putBoolean("Team Size",true)
            dataPassingBundleIntent.putExtras(bundle)
            startActivity(dataPassingBundleIntent)

        }

        //activity 4
        val intentRequestDataPass  = findViewById<Button>(R.id.button4)
        intentRequestDataPass.setOnClickListener{
            val dataBackIntent = Intent(this , DataBack::class.java)
            startActivityForResult(dataBackIntent,Code)
        }
    }

    // toast Message when the data is Passed Back
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==Code && resultCode== Activity.RESULT_OK){
            if(data!!.hasExtra("Continent")){
                val returnedMessage = data.getStringExtra("Continent")

                Toast.makeText(this , "Returned Continent = "+ returnedMessage ,Toast.LENGTH_LONG).show()
            }
        }
    }
}
