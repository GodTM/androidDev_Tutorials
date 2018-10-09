package com.mydomain.god_tm.tut3_practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ActivityDynamic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)


        var fragmentManager = supportFragmentManager

        var transaction = fragmentManager.beginTransaction()

        //defining the 1st fragment
        var fragment = Fragment_1()
        transaction.add(R.id.frameLayout1 , fragment)

        // defining the second fragment
        var fragment2 = Fragment_2()
        transaction.add(R.id.frameLayout2, fragment2)

        transaction.commit()


        var backBut = findViewById<Button>(R.id.backButDyn)
        backBut.setOnClickListener {

            finish()
        }




    }
}
