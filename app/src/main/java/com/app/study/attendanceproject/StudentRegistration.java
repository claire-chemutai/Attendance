package com.app.study.attendanceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentRegistration extends AppCompatActivity {

    private static final String TAG = "AgentRegistration";
    DatabaseHelper mDatabaseHelper;
    private EditText FirstName, SecondName,dateOfBirth,studentEmail,identification;
    String genderType,emailPattern,fname,sname,DOB,email;
    Integer id;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        mDatabaseHelper = new DatabaseHelper(this);

        FirstName = findViewById(R.id.FNameStudent);
        SecondName = findViewById(R.id.SNameStudent);
        studentEmail = findViewById(R.id.emailStudent);
        dateOfBirth = findViewById(R.id.DOB);
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        identification = findViewById(R.id.IDNumber);

        final Spinner genderSpinner =  findViewById(R.id.SpinnerGenderType);

        submit= findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = FirstName.getText().toString();
                sname = SecondName.getText().toString();
                email = studentEmail.getText().toString().trim();
                DOB = dateOfBirth.getText().toString();
                id = Integer.parseInt(identification.getText().toString());
                genderType = genderSpinner.getSelectedItem().toString();
                if (fname.length() != 0 && sname.length() != 0 && email.length() != 0
                        && DOB.length() != 0 && id!=null) {


                    Log.d(TAG, "DATE OF BIRTH: " + DOB);
                    AddStudent(fname,sname, DOB, id, genderType,email);
                    FirstName.setText("");
                    SecondName.setText("");
                    studentEmail.setText("");
                    dateOfBirth.setText("");
                    identification.setText("");


                }
                else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });


    }

    public void AddStudent(String fname,String sname,String date,int id,
                         String gender, String email) {
        boolean insertData = mDatabaseHelper.addStudent(fname,sname, date,id,
                gender, email);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
//                Intent cameraIntent = new
//                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//            } else {
//                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
//            }
//
//        }
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
////            image.setImage(data.get("data"));
////            imageView.setImageBitmap(photo);
//
//
//
//        }
//    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
