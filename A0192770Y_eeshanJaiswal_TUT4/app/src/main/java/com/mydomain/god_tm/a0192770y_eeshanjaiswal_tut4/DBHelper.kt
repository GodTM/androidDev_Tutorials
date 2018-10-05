package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut4

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper



class DBHelper(context : Context): SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VERSION){

    companion object {
        val DATABASE_NAME = "courses.db" ;
        val DATABASE_VERSION = 1 ;

        private val SQL_CREATE_ENTRIES  = "CREATE TABLE "+ TableInfo.TABLE_NAME +" ("+ TableInfo.COURSE_CODE +" TEXT PRIMARY KEY , "+
                TableInfo.NUMBER_OF_STUDENTS+" TEXT NOT NULL , "+ TableInfo.COURSE_LEVEL+" TEXT) "


        private val DELETE_TABLE = " DROP TABLE IF EXISTS "+ TableInfo.TABLE_NAME ;

    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(DELETE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DELETE_TABLE) ; // delete the table if present before
        onCreate(db) ;

    }




    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int){

        onUpgrade(db , oldVersion , newVersion) ;
    }


    fun insertCourseDetails(course: DataRecord): Boolean{

        val database = writableDatabase ;
        val values = ContentValues()

        values.put(TableInfo.COURSE_CODE , course.name)
        values.put(TableInfo.NUMBER_OF_STUDENTS , course.numberOfStudents)
        values.put(TableInfo.COURSE_LEVEL , course.level)
        /*
       // checking whether the course already exists
       try{
        var query: String  = "SELECT * FROM " + TableInfo.TABLE_NAME + " WHERE " + TableInfo.COURSE_CODE + " = "+ course.name.toString()
        var cursor: Cursor = database.rawQuery(query , null)
        if (cursor.columnCount>0){
            return false
           }
        }catch(e:SQLException){
           return false
       }
       */
        //WHY DO I get an error  by uncommenting this code ??




        // inserting values
        val newRow:Long = database.insert(TableInfo.TABLE_NAME , null , values)
        if(newRow == 1.toLong()){
            return false
        }
        return true
    }

    fun deleteCourseDetails(course: String):Boolean {

        val database = writableDatabase
        val selection = TableInfo.COURSE_CODE +" LIKE ? "
        val selectionArgs = arrayOf(course)

        // if the course code entered is null , return false
        if(course==null){
            return false
        }

        // if the course to be deleted does not exist , return false

        var result:Int = database.delete(TableInfo.TABLE_NAME , selection ,selectionArgs)
        if(result==0){
            return false
        }


        return true
    }


    // returns the arrayList of records with a specific code
    fun readCourse(courseCode:String):ArrayList<DataRecord>{

        val courses = ArrayList<DataRecord>()
        val database = writableDatabase

        var cursor: Cursor? =  null

        try{

            cursor = database.rawQuery("select * FROM "+ TableInfo.TABLE_NAME+ "WHERE " +
                    TableInfo.COURSE_CODE+" =  "+ courseCode  +"", null ) // why selectionArgs at the end ?

        }catch(e: SQLiteException){
            database.execSQL(SQL_CREATE_ENTRIES) // if there is no db , create one
            return ArrayList() // why ?
        }


        var numberOfStudents : String
        var level : String

        // move the cursor to first element in database .. (default = -1 ).. but why include that in an IF statement
        if(cursor!!.moveToFirst()){
            // while the cursor hasnt move past all the entries
            while(cursor.isAfterLast==false){

                numberOfStudents = cursor.getInt(cursor.getColumnIndex(TableInfo.NUMBER_OF_STUDENTS)).toString()
                level = cursor.getString(cursor.getColumnIndex(TableInfo.COURSE_LEVEL)).toString()
                courses.add(DataRecord(courseCode , numberOfStudents.toInt() , level))
                cursor.moveToNext()
            }
        }
        return courses
    }


    fun readAllCourses():ArrayList<DataRecord>{
        var courses = ArrayList<DataRecord>()
        val database = writableDatabase
        var cursor: Cursor? = null

        try{
            cursor = database.rawQuery("SELECT * FROM "+TableInfo.TABLE_NAME , null)
        }catch (e: SQLiteException){
            database.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList() // return blank list as the database is just created
        }

        var courseCode : String
        var numberOfStudents: Int
        var courseLevel:String
        if(cursor!!.moveToFirst()){
            while(cursor.isAfterLast == false){
                courseCode = cursor.getString(cursor.getColumnIndex(TableInfo.COURSE_CODE))
                numberOfStudents = cursor.getInt(cursor.getColumnIndex(TableInfo.NUMBER_OF_STUDENTS))
                courseLevel = cursor.getString(cursor.getColumnIndex(TableInfo.COURSE_LEVEL))

                courses.add(DataRecord(courseCode , numberOfStudents ,courseLevel))
                cursor.moveToNext()
            }
        }

        return courses
    }
}