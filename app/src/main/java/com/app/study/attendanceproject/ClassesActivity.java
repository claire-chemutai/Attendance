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

public class ClassesActivity extends AppCompatActivity {
    private static final String TAG ="CoursesRegistered" ;
//    DatabaseHelper mDatabaseHelper;

//    private Cursor courses;
//    private static ListAdapter adapter;
//    private TextView courseName, courseId;

    ArrayList<String> coursesList;
    ArrayAdapter<String> adapter;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    Courses course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        mDatabaseHelper = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);


        course= new Courses();
        listView =  findViewById(R.id.listviewClass);
        database= FirebaseDatabase.getInstance();
        ref=database.getReference("Courses");
        coursesList= new ArrayList<>();
        adapter= new ArrayAdapter<String>(this, R.layout.row_item,
                R.id.coursename, coursesList);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                   course=ds.getValue(Courses.class);

                   coursesList.add(course.getCourseId()+" "+
                           course.getCourseName());

                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        final Courses courseData = new Courses();
//        final String crsid=courseData.getCourseId();
//        final String crsname=courseData.getCourseName();



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             Courses courseData = new Courses();
//             String crsid=courseData.getCourseId();
//             String crsname=courseData.getCourseName();
//
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
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
//                intent.putExtra("CourseId", crsid);
//                intent.putExtra("Coursename", crsname);
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


    }
    public void markPage(View view){
        Intent intent = new Intent(getApplicationContext(),MarkActivity.class);
        startActivity(intent);
    }

//    public ArrayList<Courses> getCourseData() {
//        Cursor cursor = mDatabaseHelper.getCourseData();
//        coursesList= new ArrayList<>();
//
//        courses = mDatabaseHelper.getCourseData();
//
//        // looping through all rows and adding to list
//
//        if (cursor.moveToFirst()) {
//            do {
//                Courses courseData = new Courses();
//                coursesList.add(courseData);
//                courseData.setCourseId(cursor.getString(1));
//                courseData.setCourseName(cursor.getString(2));
//
//            } while (cursor.moveToNext() );
//            CourseListAdapter courseListAdapter = new CourseListAdapter( coursesList,ClassesActivity.this);
//            listView.setAdapter(courseListAdapter); //listView is defined in onCreate() method
//            courses.close();
//        }
//
//
//        return coursesList;
//
//
//    }
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
