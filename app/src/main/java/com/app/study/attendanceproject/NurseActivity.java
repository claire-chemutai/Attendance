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


public class NurseActivity extends AppCompatActivity {

    private static final String TAG = "Nurse";
    DatabaseHelper mDatabaseHelper;
    private EditText studentId, studentName, studentReason, nurseDate;

//    String studentId, studentName;

    private Button submit;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    Nurse nurse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);

        studentId = findViewById(R.id.nstudentid);
        studentName = findViewById(R.id.nstudentname);
        studentReason = findViewById(R.id.nstudentReason);
        nurseDate = findViewById(R.id.date_nurse);
        submit= findViewById(R.id.submitButton);

        database = FirebaseDatabase.getInstance();
        myRef= database.getReference("Nurse");
        nurse=new Nurse();


    }
    private void getValues(){
        nurse.setStudentId(studentId.getText().toString());
        nurse.setStudentName(studentName.getText().toString());
        nurse.setStudentReason(studentReason.getText().toString());
        nurse.setNurseDate(nurseDate.getText().toString());
    }


    public void AddReport(View view) {


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                getValues();
                myRef.child(nurse.getStudentId()).setValue(nurse);
                Toast.makeText(NurseActivity.this, "Data inserting...",
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

