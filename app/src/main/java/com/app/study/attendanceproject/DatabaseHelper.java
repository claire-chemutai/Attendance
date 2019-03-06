package com.app.study.attendanceproject;

/**
 * Created by Claire on 1/3/2019.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String COURSE_TABLE = "courses";
    private static final String COL1 = "courseid";
    private static final String COL2 = "coursename";

    private static final String STUDENT_TABLE = "Students";
    private static final String COLUMN1 = "idnumber";
    private static final String COLUMN2 = "firstname";
    private static final String COLUMN3 = "surname";
    private static final String COLUMN4 = "date";
    private static final String COLUMN5 = "gender";
    private static final String COLUMN6 = "email";



    public DatabaseHelper(Context context) {
        super(context, COURSE_TABLE, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createClassTable = "CREATE TABLE " + COURSE_TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT NOT NULL, " +
                COL2 + " TEXT NOT NULL)";

        String createStudentTable = "CREATE TABLE " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN1 +" INTEGER NOT NULL, " +
                COLUMN2 + " TEXT NOT NULL, " +
                COLUMN3 + " TEXT NOT NULL, " +
                COLUMN4 + " TEXT NOT NULL, " +
                COLUMN5 + " TEXT NOT NULL, " +
                COLUMN6 + " TEXT NOT NULL)";

        db.execSQL(createClassTable);
        db.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    public boolean addCourse(String courseid,String coursename) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,courseid);
        contentValues.put(COL2,coursename);

        Log.d(TAG, "addData: Adding course to " + COURSE_TABLE);

        long result = db.insert(COURSE_TABLE, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addStudent(String fname,String sname, String date,int idnumber, String gender, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1, idnumber);
        contentValues.put(COLUMN2, fname);
        contentValues.put(COLUMN3, sname);
        contentValues.put(COLUMN4, date);
        contentValues.put(COLUMN5, gender);
        contentValues.put(COLUMN6, email);

        Log.d(TAG, "addData: Adding Student to " + STUDENT_TABLE);

        long result = db.insert(STUDENT_TABLE, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getCourseData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + COURSE_TABLE;
        Cursor data = db.rawQuery(query, null);
        return data;

    }

    /**
     * Returns only the ID that matches the name passed in
     * @param email
     * @return
     */
//    public Cursor getCustomerID(String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT " + COL0 + " FROM " + CUSTOMER_TABLE +
//                " WHERE " + COL6 + " = '" + email + "'";
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }

//    public Cursor getStudentDetails(String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM " + STUDENT_TABLE +
//                " WHERE " + COL6 + " = '" + email + "'";
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }

//    public Cursor getAdminID(String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT " + COLUMN0 + " FROM " + ADMIN_TABLE +
//                " WHERE " + COLUMN3 + " = '" + email + "'";
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }

    /**
     * Updates the custoemr details field
     * @param newfName
     * @param newSName
     * @param newDate
     * @param id
     * @param newGender
     * @param newEmail
     */
//    public void updateCustomerDetails(int pid,String newfName, String newSName,String newDate,
//                                      String id, String newGender,String newEmail ){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "UPDATE " + CUSTOMER_TABLE + " SET " +
//                COL1 + " = '" + newfName + "', " +
//                COL2 + " = '" + newSName + "', " +
//                COL3 + " = '" + newDate + "', " +
//                COL4 + " = '" + id + "', " +
//                COL5 + " = '" + newGender + "', " +
//                COL6 + " = '" + newEmail + "' " +
//                "WHERE " + COL0 + " = '" + pid + "'";
//
//        Log.d(TAG, "updateCustomerDetails: query: " + query);
//        Log.d(TAG, "updateCustomerDetails: " );
//        db.execSQL(query);
//    }

    /**
     * Delete from database
     * @param id
     */
//    public void deleteDetails(Cursor id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "DELETE FROM " + CUSTOMER_TABLE + " WHERE "
//                + COL0 + " = '" + id + "'" ;
//        Log.d(TAG, "deleteName: query: " + query);
//        Log.d(TAG, "deleteName: Deleting customer" + id + " from database.");
//        db.execSQL(query);
//
//    }

}



