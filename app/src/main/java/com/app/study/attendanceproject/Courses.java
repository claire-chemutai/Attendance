package com.app.study.attendanceproject;

/**
 * Created by study on 3/5/2019.
 */

public class Courses {
    DatabaseHelper mDatabaseHelper;
    String CourseName;
    Integer CourseId;


    public Courses() {
    }


    public Courses(DatabaseHelper mDatabaseHelper, String courseName, Integer courseId) {
        this.mDatabaseHelper = mDatabaseHelper;
        CourseName = courseName;
        CourseId = courseId;
    }


    public DatabaseHelper getmDatabaseHelper() {
        return mDatabaseHelper;
    }

    public String getCourseName() {
        return CourseName;
    }
    public Integer getCourseId() {
        return CourseId;
    }

    public void setCourseId(Integer courseId) {
        CourseId = courseId;
    }

    public void setmDatabaseHelper(DatabaseHelper mDatabaseHelper) {
        this.mDatabaseHelper = mDatabaseHelper;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
