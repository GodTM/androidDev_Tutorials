package com.mydomain.god_tm.eeshanjaiswal_tut1a

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val XYZ:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnItent1 = findViewById<Button>(R.id.button)
        btnItent1.setOnClickListener {
            val intent = Intent(this, ActivityIntent1::class.java)
            startActivity(intent)

        }


        val btnItent3 = findViewById<Button>(R.id.button2)
        btnItent3.setOnClickListener {

             val intent2 = Intent(this, Main3Activity::class.java)
             intent2.putExtra("sports" , "football")
            intent2.putExtra("indoor", 1)
            startActivity(intent2)
        }

        val btnItent_3 = findViewById<Button>(R.id.button3)
        btnItent3.setOnClickListener {

            val intent2 = Intent(this, Main3Activity::class.java)
            val bundle:Bundle = Bundle()
            bundle.putString("Sports" ,"football")
            bundle.putInt("indoor" , 1)
            intent2.putExtras(bundle)
            startActivity(intent2)

        }

        val btnIntent4 = findViewById<Button>(R.id.button4)

        btnIntent4.setOnClickListener {

            val intent = Intent(this, Main4Activity::class.java)
            startActivityForResult(intent , XYZ)

        }


    }

    override fun onActivityResult(requestCode:Int , resultCode:Int , data:Intent?){

        super.onActivityResult(requestCode , resultCode ,data )

        if(requestCode==XYZ && resultCode== Activity.RESULT_OK){
            if(data!!.hasExtra("message")){

                val returnedMessage = data.
            }
        }
    }
}
