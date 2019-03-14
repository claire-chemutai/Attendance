package com.app.study.attendanceproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MarkActivity extends AppCompatActivity {
    private static final String TAG ="StudentsRegistered" ;
    ArrayList<String> studentList;
    ArrayAdapter<String> adapter;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    Student student;
    private TextView studentName, studentId;
    ImageButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);


        addBtn=findViewById(R.id.imageBtnMark);


        student= new Student();
        listView =  findViewById(R.id.listviewMark);
        database= FirebaseDatabase.getInstance();
        ref=database.getReference("Student");
        studentList= new ArrayList<>();
        adapter= new ArrayAdapter<String>(this, R.layout.row_item_mark,
                R.id.studentname, studentList);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    student=ds.getValue(Student.class);

                    studentList.add(student.getId()+"  "+
                            student.getFirstname()+"  "+ student.getSurname());
                    Log.d(TAG, "onDataChange student: " + student.getId()+"  "+
                            student.getFirstname()+" "+ student.getSurname());

                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addFingerprint(View view){
        Intent intent = new Intent(getApplicationContext(),FingerprintActivity.class);
        startActivity(intent);

    }

//        Bundle bundle = getIntent().getExtras();
//        String value = bundle.getString("CourseId");
//        String value2 = bundle.getString("Coursename");
//
//        studentList = getStudentData();
////        getStudentData();
//
//        adapter = new StudentListAdapter(studentList, getApplicationContext());
//        listView.setAdapter(adapter);
//
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                registerStudent();
//            }
//        });




//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            Student studentData = new Student();
//            int stdid=studentData.getStudentId();
//            String stdname=studentData.getStudentName();
//
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
////                String name = parent.getItemAtPosition(position).toString();
////                Log.d(TAG, "onItemClick: The item is: " + name);
//
////                Cursor data = mDatabaseHelper.getCourseData(); //get the id associated with that name
////                String course= data.getString(1);
////                Log.d(TAG, "onItemClick: The item is: " + course);
////                Intent editScreenIntent = new Intent(CustomersRegistered.this, EditDetails.class);
////                editScreenIntent.putExtra("pid", data.getInt(0));
//
//                Intent intent = new Intent(getApplicationContext(), MarkActivity.class);
//                intent.putExtra("CourseId", stdid);
//                intent.putExtra("Coursename", stdname);
//                v.getContext().startActivity(intent);
//
//////                Log.d(TAG, "onItemClick: You Clicked on " + name);
////
////                Cursor data = mDatabaseHelper.getCourseData(); //get the id associated with that name
////                int itemID = 0;
////                while (data.moveToNext()) {
////                    itemID = data.getInt(0);
////                }
////                if (itemID > 0) {
////                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
////                    Intent editScreenIntent = new Intent(CustomersRegistered.this, EditDetails.class);
////                    editScreenIntent.putExtra("pid", data.getInt(0));
////                    editScreenIntent.putExtra("Firstname", data.getString(1));
////                    editScreenIntent.putExtra("Surname", data.getString(2));
////                    editScreenIntent.putExtra("DOB", data.getString(3));
////                    editScreenIntent.putExtra("ID", data.getString(4));
////                    editScreenIntent.putExtra("Gender", data.getString(5));
////                    editScreenIntent.putExtra("Email", data.getString(6));
//////                    editScreenIntent.putExtra("Image", data.getString(7));
////                    Log.i("CR EDIT", "ID FOUND: " );
////                    startActivity(editScreenIntent);
////                } else {
////
////                    Log.i("CR EDIT", "NO ID ASSOCIATED WITH THAT NAME: " );
////                }
//            }
//
//        });
//        showList();


//    }

//    public ArrayList<Student> getStudentData() {
//        Bundle bundle = getIntent().getExtras();
//        String value = bundle.getString("CourseId");
//
//
//        Cursor cursor = mDatabaseHelper.getStudentData(value);
//        studentList= new ArrayList<>();
//
//        students = mDatabaseHelper.getStudentData(value);
//
//        // looping through all rows and adding to list
//
//        if (cursor.moveToFirst()) {
//            do {
//                Student studentData = new Student();
//                studentList.add(studentData);
//                studentData.setStudentId(cursor.getInt(1));
//                studentData.setStudentName(cursor.getString(2));
//
//            } while (cursor.moveToNext() );
//            StudentListAdapter studentListAdapter = new StudentListAdapter( studentList,MarkActivity.this);
//            listView.setAdapter(studentListAdapter); //listView is defined in onCreate() method
//            students.close();
//        }
//
//
//        return studentList;
//
//
//    }

    public void registerStudent(){
        Intent intent= new Intent(MarkActivity.this, AddStudentToClass.class);
        startActivity(intent);

    }
//    private void showList() {
//        ArrayList<Courses> customerList = new ArrayList<Courses>();
//        mDatabaseHelper = new DatabaseHelper(this);
//        courses = mDatabaseHelper.getCourseData();
//
//        // This successfully dumps the db contents to log output. Querying from DB seems to be working fine.
//        Log.d("db", DatabaseUtils.dumpCursorToString(courses));
//        int itemID = -1;
//        Courses courseData = new Courses();
//
//
////        while (customers.moveToNext()){
////            customerList.add(customerData);
////            itemID = customers.getInt(0);
//
//
//        if (courses != null && courses.getCount() != 0) {
//            do {
//
////                    Customer customerData = new Customer();
//
//                coursesList.add(courseData);
//                courseData.setCourseId(courses.getString(courses.getColumnIndex("courseid")));
//
//                courseData.setCourseName(courses.getString(courses.getColumnIndex("coursename")));
//
//
//
//
//            } while (courses.moveToNext());
//        }
//        CourseListAdapter courseListAdapter = new CourseListAdapter(coursesList,ClassesActivity.this);
//        listView.setAdapter(courseListAdapter); //listView is defined in onCreate() method
//        courses.close();
//
//    }


//    private void editDetails(){
//        Intent intent= new Intent(CustomersRegistered.this, EditDetails.class);
//        startActivity(intent);
//
//    }
    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
