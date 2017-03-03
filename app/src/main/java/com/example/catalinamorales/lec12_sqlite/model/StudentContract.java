package com.example.catalinamorales.lec12_sqlite.model;

import android.provider.BaseColumns;

/**
 * Created by catalinamorales on 3/1/17.
 */

public class StudentContract {


        private StudentContract() {}


        public static class StudentEntry implements BaseColumns {
            public static final String COL_NAME = "name";
            public static final String COL_DEPT = "dept";
            public static final String COL_AGE = "age";
            public static final String COL_ADDRESS = "address";

    }




    public static final String TABLE_NAME = "student_table";


    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    StudentEntry._ID + " INTEGER PRIMARY KEY," +
                    StudentEntry.COL_NAME + " TEXT," +
                    StudentEntry.COL_DEPT + " TEXT," +
                    StudentEntry.COL_AGE + " INTEGER," +
                    StudentEntry.COL_ADDRESS + " TEXT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
