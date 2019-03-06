package com.app.study.attendanceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CourseRegistration extends AppCompatActivity {

    private static final String TAG = "CourseRegistration";
    DatabaseHelper mDatabaseHelper;
    private EditText CourseId, CourseName;

    String courseid, coursename;

    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_registration);

        mDatabaseHelper = new DatabaseHelper(this);

        CourseId = findViewById(R.id.courseid);
        CourseName = findViewById(R.id.coursename);

        submit= findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseid = CourseId.getText().toString();
                coursename = CourseName.getText().toString();
                if (courseid.length()!= 0&& coursename.length()!= 0 ) {


                    AddCourse(courseid,coursename);
                    CourseId.setText("");
                    CourseName.setText("");


                }
                else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });


    }

    public void AddCourse(String courseid,  String coursename) {
        boolean insertData = mDatabaseHelper.addCourse(courseid,coursename);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
