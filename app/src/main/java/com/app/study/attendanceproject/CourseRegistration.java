package com.app.study.attendanceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CourseRegistration extends AppCompatActivity {

    private static final String TAG = "CourseRegistration";
    DatabaseHelper mDatabaseHelper;
    private EditText CourseId, CourseName;

    String courseid, coursename;

    private Button submit;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    Courses course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_registration);

        CourseId = findViewById(R.id.courseid);
        CourseName = findViewById(R.id.coursename);
        submit= findViewById(R.id.submitButton);

        database = FirebaseDatabase.getInstance();
        myRef= database.getReference("Courses");
        course=new Courses();


    }
    private void getValues(){
        course.setCourseId(CourseId.getText().toString());
        course.setCourseName(CourseName.getText().toString());
    }


    public void AddCourse(View view) {


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                getValues();
                myRef.child(course.getCourseId()).setValue(course);
                Toast.makeText(CourseRegistration.this, "Data inserting...",
                        Toast.LENGTH_SHORT);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }


//    private void toastMessage(String message){
//        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
//    }
}
