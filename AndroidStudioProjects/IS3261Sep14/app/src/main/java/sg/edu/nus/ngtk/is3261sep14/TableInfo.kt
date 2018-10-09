package sg.edu.nus.ngtk.is3261sep14

import android.provider.BaseColumns

class TableInfo : BaseColumns {

    companion object {
        val TABLE_NAME = "people"
        val COLUMN_NRIC = "nric"
        val COLUMN_NAME = "name"
        val COLUMN_AGE = "age"
    }


}