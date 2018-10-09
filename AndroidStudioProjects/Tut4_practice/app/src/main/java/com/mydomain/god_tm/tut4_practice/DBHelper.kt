package com.mydomain.god_tm.tut4_practice

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VERSION){

    companion object {

        val DATABASE_NAME = "courses.db"
        val DATABASE_VERSION = 1

        private val SQL_CREATE_ENTRIES = "CREATE TABLE "+ TableInfo.TABLE_NAME +"( "+ TableInfo.COLUMN_COURSE_CODE +" TEXT PRIMARY KEY  , "+
                TableInfo.COLUMN_NUMBER_OF_STUDENTS+ " INT NOT NULL  , " + TableInfo.COLUMN_LEVEL +" TEXY )  "

        private val DELETE_TABLE = "DROP TABLE IF EXISTS " + TableInfo.TABLE_NAME ;

    }


    // deletes any previous table by the same name
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DELETE_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DELETE_TABLE)
        onCreate(db)

    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int){

        onUpgrade(db , oldVersion , newVersion) ;
    }


    fun insertCourseDetails(course:DataRecord):Boolean{
        // now we can add data to the database
        val database = writableDatabase

        val values = ContentValues()
        values.put(TableInfo.COLUMN_COURSE_CODE , course.courseCode)
        values.put(TableInfo.COLUMN_NUMBER_OF_STUDENTS , course.numberOfStudents)
        values.put(TableInfo.COLUMN_LEVEL , course.level)


        val newRowId = database.insert(TableInfo.TABLE_NAME , null , values)

        return true
    }


    fun deleteCourseDetails(course:String):Boolean{

        val database = writableDatabase ;
        val selection = TableInfo.COLUMN_COURSE_CODE +"  LIKE ? "

        var selectionArgs = arrayOf(course)
        if(course ==null){
            return false
        }
        else{

            database.delete(TableInfo.TABLE_NAME , selection , selectionArgs)

            return true
        }
    }


    fun readCourse(courseCode :String):ArrayList<DataRecord>{

        //define the array list to be returned
        val courses = ArrayList<DataRecord>()
        var database = writableDatabase


        var cursor: Cursor? = null

        try{

            var rawQuery = database.rawQuery(" SELECT * FROM "+TableInfo.TABLE_NAME +" WHERE "+TableInfo.COLUMN_COURSE_CODE +" = "+courseCode +"", null)

        }catch (e:SQLException){
            println(e)
            database.execSQL(SQL_CREATE_ENTRIES) // if there is no db , create one
            return ArrayList()
        }


        var numberOfStudents:String
        var level:String

        if(cursor!!.moveToFirst()){

            while(cursor.isAfterLast==false){

                numberOfStudents = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_NUMBER_OF_STUDENTS)).toString()
                level = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_LEVEL)).toString()
                courses.add(DataRecord(courseCode , numberOfStudents.toInt() , level))
                cursor.moveToNext()

            }
        }

        return  courses

    }


    fun readAllCourses():ArrayList<DataRecord>{

        val courses = ArrayList<DataRecord>()
        val database = writableDatabase
        var cursor:Cursor? = null

        try{

           cursor = database.rawQuery("SELECT * FROM "+TableInfo.TABLE_NAME+"" , null)

        }catch (e:SQLException){
            println(e)
            database.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var courseCode:String
        var numberOfStudents:Int
        var level:String



        if(cursor!!.moveToFirst()){
            while(cursor.isAfterLast){

                courseCode = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_COURSE_CODE)).toString()
                numberOfStudents = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_NUMBER_OF_STUDENTS))
                level = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_LEVEL))

                courses.add(DataRecord(courseCode , numberOfStudents , level))

            }

        }

        return courses ;
    }


}