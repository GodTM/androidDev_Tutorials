package com.mydomain.god_tm.tut3_practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class ActivityInterface : AppCompatActivity() , FI{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)





        var backBut = findViewById<Button>(R.id.backButActivityInterface)
        backBut.setOnClickListener {

            finish()
        }

    }

    // this function uses the function given in the interface defined in the InterfaceFragment
    override fun onFragmentInterface(str:String){

        Toast.makeText(this , str ,Toast.LENGTH_LONG).show()
    }
}
