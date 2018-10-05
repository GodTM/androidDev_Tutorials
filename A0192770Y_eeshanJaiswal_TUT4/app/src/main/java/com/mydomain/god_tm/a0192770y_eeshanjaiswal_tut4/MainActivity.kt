package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut4

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper :DBHelper ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addCourse  = findViewById<Button>(R.id.add)
        val deleteCourse = findViewById<Button>(R.id.delete)
        val display = findViewById<Button>(R.id.display)


        addCourse.setOnClickListener {

             addCourse()

        }

        deleteCourse.setOnClickListener {
                deleteCourse()
        }

        display.setOnClickListener {
            displayCourses()
        }
        dbHelper = DBHelper(this)

    }


    fun addCourse(){
        var courseCode = this.courseCode.text.toString() ;
        var numberOfStudents = this.numberOfStudents.text.toString()
        var levelOfCourse = this.courseLevel.text.toString()


        var result =  dbHelper.insertCourseDetails(DataRecord(courseCode , numberOfStudents.toInt() , levelOfCourse))

        // set the original state back (of the input fields)
        resetValues()

        // add a notification to the scroll view as well

            this.displayInScroll.text = "Added course : " + result.toString()
            Toast.makeText(this, "Added Course : " + result.toString(), Toast.LENGTH_LONG).show()
            closeKeyboard()


    }

    fun deleteCourse() {
        var toDelete = this.courseCode.text.toString()
        var result = dbHelper.deleteCourseDetails(toDelete)

        // add a notification to the scroll view for deletion as well
        this.displayInScroll.text = "Deleted course : " + result
        Toast.makeText(this , "Deleted Course : " + result , Toast.LENGTH_LONG).show()
        resetValues()
        closeKeyboard()
    }

    fun displayCourses(){

        var courses = dbHelper.readAllCourses()
        var string: String? = null
        string = "Fetched "+courses.size + " courses: \n"

        courses.forEach{
            string = string + it.name.toString() + " - "+ it.numberOfStudents.toString()+" - " + it.level.toString()+ "\n"
        }

        this.displayInScroll.text = "All courses : " + string
        resetValues()
        closeKeyboard()
    }

    // closes the keyboard after input
    private fun closeKeyboard(){
        var view: View = this.currentFocus
        if(view!=null){
            var manager:InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            manager?.hideSoftInputFromWindow(view.windowToken , 0)
        }
    }

    private fun resetValues(){

        this.courseCode.setHint(R.string.main_page_edit_text_course_code)
        this.numberOfStudents.setHint(R.string.main_page_title_number_of_students)
        this.courseLevel.setHint(R.string.main_page_title_level)
    }
}
