package com.app.study.attendanceproject;

/**
 * Created by study on 3/16/2019.
 */

class Nurse {
    String studentId;
    String studentName;
    String studentReason;
    String nurseDate;
    public Nurse() {
    }


    public Nurse(String studentId, String studentName, String studentReason, String nurseDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentReason = studentReason;
        this.nurseDate = nurseDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentReason() {
        return studentReason;
    }

    public void setStudentReason(String studentReason) {
        this.studentReason = studentReason;
    }

    public String getNurseDate() {
        return nurseDate;
    }

    public void setNurseDate(String nurseDate) {
        this.nurseDate = nurseDate;
    }
}
