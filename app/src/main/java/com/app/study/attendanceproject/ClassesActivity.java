package com.app.study.attendanceproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassesActivity extends AppCompatActivity {
    private static final String TAG ="CoursesRegistered" ;
    DatabaseHelper mDatabaseHelper;
    ArrayList<Courses> coursesList;
    ListView listView;
    private Cursor courses;
    private static ListAdapter adapter;
    private TextView courseName, courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabaseHelper = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        listView =  findViewById(R.id.listview);
//        courseId =  findViewById(R.id.courseid);
//        courseName =  findViewById(R.id.coursename);

        coursesList = getCourseData();
        getCourseData();

        adapter = new CourseListAdapter(coursesList, getApplicationContext());
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MarkActivity.class);
                v.getContext().startActivity(intent);
//                String name = parent.getItemAtPosition(position).toString();
////                Log.d(TAG, "onItemClick: You Clicked on " + name);
//
//                Cursor data = mDatabaseHelper.getCourseData(); //get the id associated with that name
//                int itemID = 0;
//                while (data.moveToNext()) {
//                    itemID = data.getInt(0);
//                }
//                if (itemID > 0) {
//                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
//                    Intent editScreenIntent = new Intent(CustomersRegistered.this, EditDetails.class);
//                    editScreenIntent.putExtra("pid", data.getInt(0));
//                    editScreenIntent.putExtra("Firstname", data.getString(1));
//                    editScreenIntent.putExtra("Surname", data.getString(2));
//                    editScreenIntent.putExtra("DOB", data.getString(3));
//                    editScreenIntent.putExtra("ID", data.getString(4));
//                    editScreenIntent.putExtra("Gender", data.getString(5));
//                    editScreenIntent.putExtra("Email", data.getString(6));
////                    editScreenIntent.putExtra("Image", data.getString(7));
//                    Log.i("CR EDIT", "ID FOUND: " );
//                    startActivity(editScreenIntent);
//                } else {
//
//                    Log.i("CR EDIT", "NO ID ASSOCIATED WITH THAT NAME: " );
//                }
            }

        });

    }

    public ArrayList<Courses> getCourseData() {
        Cursor cursor = mDatabaseHelper.getCourseData();
        coursesList= new ArrayList<>();

        courses = mDatabaseHelper.getCourseData();

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Courses courseData = new Courses();
                coursesList.add(courseData);
                courseData.setCourseId(cursor.getInt(1));
//                    FName.setText(cursor.getString(1));
                courseData.setCourseName(cursor.getString(2));
//                    SName.setText(cursor.getString(2));
//                customerData.setCusEmail(cursor.getString(6));
//                    cusEmail.setText(cursor.getString(6));
//                    customerData.setImage(cursor.getString(7));
//                    profilePic.setImageBitmap(BitmapFactory.decodeFile(cursor.getString(7)));

            } while (cursor.moveToNext() );
            CourseListAdapter courseListAdapter = new CourseListAdapter( coursesList,ClassesActivity.this);
            listView.setAdapter(courseListAdapter); //listView is defined in onCreate() method
            courses.close();
        }


        return coursesList;


    }
    private void showList() {
        ArrayList<Courses> customerList = new ArrayList<Courses>();
        mDatabaseHelper = new DatabaseHelper(this);
        courses = mDatabaseHelper.getCourseData();

        // This successfully dumps the db contents to log output. Querying from DB seems to be working fine.
        Log.d("db", DatabaseUtils.dumpCursorToString(courses));
        int itemID = -1;
        Courses courseData = new Courses();


//        while (customers.moveToNext()){
//            customerList.add(customerData);
//            itemID = customers.getInt(0);


        if (courses != null && courses.getCount() != 0) {
            do {

//                    Customer customerData = new Customer();
                customerList.add(courseData);
                courseData.setCourseId(courses.getInt(courses.getColumnIndex("ID")));

                courseData.setCourseName(courses.getString(courses.getColumnIndex("course")));



            } while (courses.moveToNext());
        }
        CourseListAdapter courseListAdapter = new CourseListAdapter(customerList,ClassesActivity.this);
        listView.setAdapter(courseListAdapter); //listView is defined in onCreate() method
        courses.close();

    }


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
