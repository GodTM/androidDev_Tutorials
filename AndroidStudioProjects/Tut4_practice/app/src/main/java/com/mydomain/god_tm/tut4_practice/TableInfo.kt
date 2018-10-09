package com.mydomain.god_tm.tut4_practice

import android.provider.BaseColumns

class TableInfo:BaseColumns {

    companion object {

        val TABLE_NAME = "courses"
        val COLUMN_COURSE_CODE  = "course_code"
        val COLUMN_NUMBER_OF_STUDENTS = "number_of_students"
        val COLUMN_LEVEL = "level_of_course"
    }

}