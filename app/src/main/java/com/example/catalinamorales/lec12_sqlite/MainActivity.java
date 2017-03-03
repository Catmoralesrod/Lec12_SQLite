package com.example.catalinamorales.lec12_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.catalinamorales.lec12_sqlite.model.StudentContract;
import com.example.catalinamorales.lec12_sqlite.model.StudentDbHelper;

import static com.example.catalinamorales.lec12_sqlite.Utility.Utility.setStethoWatch;
import static com.example.catalinamorales.lec12_sqlite.model.StudentContract.StudentEntry.COL_ADDRESS;
import static com.example.catalinamorales.lec12_sqlite.model.StudentContract.StudentEntry.COL_AGE;
import static com.example.catalinamorales.lec12_sqlite.model.StudentContract.StudentEntry.COL_DEPT;
import static com.example.catalinamorales.lec12_sqlite.model.StudentContract.StudentEntry.COL_NAME;
import static com.example.catalinamorales.lec12_sqlite.model.StudentContract.TABLE_NAME;

public class MainActivity extends AppCompatActivity {


    private EditText nameField;
    private EditText deptField;
    private EditText ageField;
    private EditText addressField;
    private TextView tv;


    StudentDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStethoWatch(this);
        nameField = (EditText) findViewById(R.id.std_name_ma);
        deptField = (EditText) findViewById(R.id.std_dept_ma);
        ageField = (EditText) findViewById(R.id.std_age_ma);
        addressField = (EditText) findViewById(R.id.std_address_ma);
        tv = (TextView) findViewById(R.id.tv_ma);


        mDbHelper = new StudentDbHelper(this);
    }


    public void addRecord(View view) {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, nameField.getText().toString());
        values.put(COL_DEPT, deptField.getText().toString());
        values.put(COL_AGE, ageField.getText().toString());
        values.put(COL_ADDRESS, addressField.getText().toString());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME, null, values);


    }

    public void checkRecord(View view) {


        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        String[] projection = {
                StudentContract.StudentEntry._ID,
                COL_NAME,
                COL_DEPT,
                COL_AGE,
                COL_ADDRESS
        };

        //String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        //String[] selectionArgs = { "My Title" };

        //String sortOrder =
        //        FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        String tempStr = "";
        while (cursor.moveToNext()) {
            tempStr += cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)) + " ";
            tempStr += cursor.getString(cursor.getColumnIndexOrThrow(COL_DEPT)) + " ";
            tempStr += cursor.getString(cursor.getColumnIndexOrThrow(COL_AGE)) + " ";
            tempStr += cursor.getString(cursor.getColumnIndexOrThrow(COL_ADDRESS)) + "\n ";

        }
        cursor.close();

        tv.setText(tempStr);

    }

    public void updateRecord(View view) {

    }

    public void deleteRecord(View view) {

    }


}

