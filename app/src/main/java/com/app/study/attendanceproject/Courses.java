package com.app.study.attendanceproject;

/**
 * Created by study on 3/5/2019.
 */

public class Courses {
    DatabaseHelper mDatabaseHelper;
    String courseName,courseId;



    public Courses() {
    }
    public Courses( String courseName, String courseId) {
        courseName = courseName;
        courseId = courseId;
    }


    public Courses(DatabaseHelper mDatabaseHelper, String courseName, String courseId) {
        this.mDatabaseHelper = mDatabaseHelper;
        courseName = courseName;
        courseId = courseId;
    }


    public DatabaseHelper getmDatabaseHelper() {
        return mDatabaseHelper;
    }

    public String getcourseName() {
        return courseName;
    }
    public String getcourseId() {
        return courseId;
    }

    public void setcourseId(String courseId) {
        courseId = courseId;
    }

    public void setmDatabaseHelper(DatabaseHelper mDatabaseHelper) {
        this.mDatabaseHelper = mDatabaseHelper;
    }

    public void setcourseName(String courseName) {
        courseName = courseName;
    }
}
