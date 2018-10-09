package sg.edu.nus.ngtk.is3261sep14

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,
        DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "People.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TableInfo.TABLE_NAME + " (" +
                        TableInfo.COLUMN_NRIC + " TEXT PRIMARY KEY," +
                        TableInfo.COLUMN_NAME + " TEXT," +
                        TableInfo.COLUMN_AGE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
                TableInfo.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?,
                             oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun insertPerson(person: DataRecord): Boolean {
        val db = writableDatabase
        val values = ContentValues()

        values.put(TableInfo.COLUMN_NRIC, person.NRIC)
        values.put(TableInfo.COLUMN_NAME, person.name)
        values.put(TableInfo.COLUMN_AGE, person.age)

        val newRowId = db.insert(TableInfo.TABLE_NAME,
                null, values)
        return true
    }

    fun deletePerson(nric: String):Boolean {
        val db = writableDatabase
        val selection = TableInfo.COLUMN_NRIC + " LIKE ?"
        val selectionArgs = arrayOf(nric)

        db.delete(TableInfo.TABLE_NAME, selection, selectionArgs)

        return true
    }

    fun readPerson(nric: String): ArrayList<DataRecord> {
        val people = ArrayList<DataRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("select * from " +
                 TableInfo.TABLE_NAME + " WHERE " +
                 TableInfo.COLUMN_NRIC + "=" + nric + "", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var name: String
        var age: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                age = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_AGE))
                name= cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_NAME))
                people.add(DataRecord(nric, name, age))
                cursor.moveToNext()
            }
        }
        return people
    }

    fun readAllPeople(): ArrayList<DataRecord> {
        val people = ArrayList<DataRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from "+ TableInfo.TABLE_NAME, null)

        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var nric: String
        var name: String
        var age: Int
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                nric = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_NRIC))
                name = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_NAME))
                age = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_AGE))
                people.add(DataRecord(nric, name, age))
                cursor.moveToNext()
            }
        }
        return people
    }

}
















