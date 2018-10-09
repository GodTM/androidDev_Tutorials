package sg.edu.nus.ngtk.is3261sep14

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class ActivitySharedPreferences : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var NAME = "name"
    private var AGE = "age"
    private var HEIGHT = "height"
    private var EMPTY = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val btnSave = findViewById<Button>(R.id.btn_Save)
        btnSave.setOnClickListener{
            saveData()
        }

        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)

        if (sharedPreferences.getString(NAME, EMPTY) != EMPTY) {
            val name = sharedPreferences.getString(NAME, EMPTY)
            val age = sharedPreferences.getString(AGE, EMPTY)
            val height = sharedPreferences.getString(HEIGHT, EMPTY)

            var str: String = "name " + name + " age = " + age + "  height " + height
            Toast.makeText(this, str, Toast.LENGTH_LONG).show()

        }
    }

    fun saveData() {
        val name = "this is hardcoded name"
        val age = "this is hardcoded age"
        val height = "this is hardcoded height"

        val editor = sharedPreferences.edit()

        editor.putString(NAME, name)
        editor.putString(AGE, age)
        editor.putString(HEIGHT, height)
        editor.apply()


    }
}










