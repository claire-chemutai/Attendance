package com.app.study.attendanceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddStudentToClass extends AppCompatActivity {

    private static final String TAG = "AddStudent";
    DatabaseHelper mDatabaseHelper;
    private EditText FirstName, SecondName,identification;
    String fname,sname,DOB,email;
    Integer studentId;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_class);

        mDatabaseHelper = new DatabaseHelper(this);

        FirstName = findViewById(R.id.studentFname);
        SecondName = findViewById(R.id.studentSurname);
        identification = findViewById(R.id.studentIdentification);


        submit= findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = FirstName.getText().toString();
                sname = SecondName.getText().toString();
                studentId = Integer.parseInt(identification.getText().toString());
                if (fname.length() != 0 && sname.length() != 0 && studentId!=null) {


                    Log.d(TAG, "Student: " + fname);
                    AddStudentToClass(fname,sname, studentId);
                    FirstName.setText("");
                    SecondName.setText("");
                    identification.setText("");


                }
                else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });


    }

    public void AddStudentToClass(String fname,String sname,int studentId) {
        boolean insertData = mDatabaseHelper.addStudentToClass(fname,sname,studentId);

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

