package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut4

import android.provider.BaseColumns

class TableInfo : BaseColumns{

    companion object {
        val TABLE_NAME = "courses"

        // all the columns
        val COURSE_CODE = "course_code"
        val NUMBER_OF_STUDENTS = "number_of_students"
        val COURSE_LEVEL= "course_level"
    }
}