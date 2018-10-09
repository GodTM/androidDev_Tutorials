package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ActivityDynamic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        /*
        * need to call the Fragment Manager . The fragment manager calls the interface that attaches
        * a particular fragment to the activity
        * */

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        // declare a new fragment and attach it to the Fragment manager

        //DOUBT
        val fragment_1 = Fragment_1() // why are we calling the constructor by the variable name ???
        transaction.add(R.id.frameLayout1 , fragment_1) // attaching the declared fragment to the first FrameLayout

        val fragment_2 = Fragment_2()  // declaring the second fragment
        transaction.add(R.id.frameLayout2, fragment_2)

        // changes wont happen until the following commit hasn't been made
        transaction.commit()

        // replacing the fragments with
        transaction.replace(R.id.frameLayout1 , fragment_1)
        transaction.replace(R.id.frameLayout2 , fragment_2)


        // finish the activity
        val backButton = findViewById<Button>(R.id.dynamicActBackBut)
        backButton.setOnClickListener {
            finish()
        }



    }



}
