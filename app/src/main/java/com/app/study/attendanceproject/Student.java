package com.app.study.attendanceproject;

/**
 * Created by study on 3/10/2019.
 */

public class Student {
    String firstname;
    String surname;
    int id;

    public Student(){

    }

    public Student(String firstname, String surname, int id) {
        this.firstname = firstname;
        this.surname = surname;
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
