package com.app.study.attendanceproject;

/**
 * Created by study on 3/10/2019.
 */

public class Student {
    DatabaseHelper mDatabaseHelper;
    String StudentName;
    int StudentId;

    public Student(){

    }


    public Student(DatabaseHelper mDatabaseHelper, String studentName, int studentId) {
        this.mDatabaseHelper = mDatabaseHelper;
        StudentName = studentName;
        StudentId = studentId;
    }

    public DatabaseHelper getmDatabaseHelper() {
        return mDatabaseHelper;
    }

    public void setmDatabaseHelper(DatabaseHelper mDatabaseHelper) {
        this.mDatabaseHelper = mDatabaseHelper;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }
}
