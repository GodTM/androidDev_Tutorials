package sg.edu.nus.ngtk.is3261sep7

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToStaticFragment = findViewById<Button>(R.id.btn_GoToStaticFragment)
        btnGoToStaticFragment.setOnClickListener{
            val myIntent = Intent(this, ActivityStaticFragment::class.java)
            startActivity(myIntent)
        }

        val btnGoToDynamicFragment = findViewById<Button>(R.id.btn_GoToDynamicFragment)
        btnGoToDynamicFragment.setOnClickListener{
            val myIntent = Intent(this, ActivityDynamicFragment::class.java)
            startActivity(myIntent)
        }

        val btnGoToFragmentWithInterface = findViewById<Button>(R.id.btn_GoToFragmentWithInterface)
        btnGoToFragmentWithInterface.setOnClickListener{
            val myIntent = Intent(this, ActivityFragmentWithInterface::class.java)
            startActivity(myIntent)
        }

    }
}








