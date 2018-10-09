package sg.edu.nus.ngtk.is3261sep14

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class TheRealMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_real_main)

        val btnGoToSQLite = findViewById<Button>(R.id.btn_sqlite)
        btnGoToSQLite.setOnClickListener{
             val myIntent = Intent(this, MainActivity::class.java)
             startActivity(myIntent)
        }

        val btnGoToSharedPreferences = findViewById<Button>(R.id.btn_SharedPreferences)
        btnGoToSharedPreferences.setOnClickListener{
            val myIntent = Intent(this, ActivitySharedPreferences::class.java)
            startActivity(myIntent)
        }
    }
}
