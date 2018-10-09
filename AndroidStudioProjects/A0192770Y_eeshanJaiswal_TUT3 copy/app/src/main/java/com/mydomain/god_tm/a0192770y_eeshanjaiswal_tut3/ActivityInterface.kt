package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut3

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class ActivityInterface : AppCompatActivity() , FragmentWithInterface.InterfaceToImplement {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)


        var toBeDisplayed = "This toast message is from Fragment 4 !"

        fun callBackListener(act: Activity) {

            
        }

        // will destroy the current activity and return to the homepage
        var backButton = findViewById<Button>(R.id.backButActivityInterface)
        backButton.setOnClickListener {

            finish() ;
        }
        // call fragment manager and add a new fragment to the manager
        val fragmentManager = supportFragmentManager
        val transaction  = fragmentManager.beginTransaction()

        val fragment3 = android.support.v4.app.Fragment()
        transaction.add(R.id.fragment_with_interface , fragment3)
        onFragmentInteraction(toBeDisplayed)
        transaction.commit()

    }

    fun onFragmentInteraction(str:String){
        Toast.makeText(this , str , Toast.LENGTH_LONG).show()
    }

}
