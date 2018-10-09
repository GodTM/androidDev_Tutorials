package com.mydomain.god_tm.tut4_practice

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addCourse = findViewById<Button>(R.id.addBut)
        var deleteCourse = findViewById<Button>(R.id.deleteBut)
        var displayBut = findViewById<Button>(R.id.displayBut)

        addCourse.setOnClickListener { addCourse() }

        deleteCourse.setOnClickListener { deleteCourse() }

        displayBut.setOnClickListener { displayCourses() }

        dbHelper = DBHelper(this)
    }

    fun addCourse(){


        var courseCode = this.courseCode.text.toString()
        var numberOfStudents = this.numberOfStudents.toString().trim().toInt()
        var level = this.level.toString()

        var result = false

        result = dbHelper.insertCourseDetails(DataRecord(courseCode, numberOfStudents ,level))

        // set the original values back
        resetValues()

        this.displayInScroll.text = "Added Course : "+ result.toString() ;
        Toast.makeText(this , "Added Course : "+result.toString() , Toast.LENGTH_LONG).show()
        closeKeyboard()
    }


    private fun closeKeyboard(){
        var view : View = this.currentFocus
        if(view!= null){

            var manager: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager?
            manager?.hideSoftInputFromWindow(view.windowToken , 0)// why the flags

        }
    }

    private fun resetValues(){

        this.courseCode.setHint(R.string.courseCode)
        this.numberOfStudents.setHint(R.id.numberOfStudents)
        this.level.setHint(R.id.level)
    }
}
