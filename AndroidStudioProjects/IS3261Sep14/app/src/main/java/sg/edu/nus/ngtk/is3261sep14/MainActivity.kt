package sg.edu.nus.ngtk.is3261sep14

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var peopleDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btn_Add)
        btnAdd.setOnClickListener{
            addPerson()
        }

        val btnDelete = findViewById<Button>(R.id.btn_Delete)
        btnDelete.setOnClickListener{
            deletePerson()
        }

        val btnDisplay = findViewById<Button>(R.id.btn_Display)
        btnDisplay.setOnClickListener{
            displayPerson()
        }

        peopleDBHelper = DBHelper(this)

    }

    fun addPerson() {
        var nric = this.et_NRIC.text.toString()
        var name = this.et_Name.text.toString()
        var age  = this.et_Age.text.toString().toInt()

        var result = peopleDBHelper.insertPerson(DataRecord(nric, name, age))

        this.et_NRIC.setText("")
        this.et_Name.setText("")
        this.et_Age.setText("")

        this.tv_Display.text = "Added person: " + result

        Toast.makeText(this, "Added person : " + result, Toast.LENGTH_LONG).show()

    }

    fun deletePerson() {
        var nric = this.et_NRIC.text.toString
        val result = peopleDBHelper.deletePerson(nric)
        this.tv_Display.text = "Deleted Person: " + result
        Toast.makeText(this, "Deleted Person : " + result, Toast.LENGTH_LONG).show()
    }

    fun displayPerson() {
        var people = peopleDBHelper.readAllPeople()

        var str: String? = null
        str = "Fetched " + people.size + " persons: \n"

        people.forEach {
            str = str + it.NRIC.toString() + " - " + it.name.toString() + " " + it.age + "\n"
        }

        this.tv_Display.text = "All People: " + str
    }

}












