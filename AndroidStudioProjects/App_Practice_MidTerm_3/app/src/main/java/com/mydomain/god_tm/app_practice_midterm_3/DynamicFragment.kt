package com.mydomain.god_tm.app_practice_midterm_3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class DynamicFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment)

        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()

        val fragment1 = Fragment_1()
        transaction.add(R.id.fragment , fragment1)

        val fragment2= Fragment_2()
        transaction.add(R.id.fragment2 , fragment2)

        transaction.commit()


        transaction.replace(R.id.frameLayout1 , fragment1)
        transaction.replace(R.id.frameLayout2 , fragment2)


        // finish the activity
        var back = findViewById<Button>(R.id.backBut_Dynamic)
        back.setOnClickListener {
            finish()
        }



    }
}
