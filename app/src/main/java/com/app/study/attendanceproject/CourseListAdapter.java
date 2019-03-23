package com.app.study.attendanceproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by study on 3/5/2019.
 */

public class CourseListAdapter extends ArrayAdapter<Courses> {
    private static final String TAG ="CourseListAdapters" ;
    ArrayList<Courses> courseList;
    Context context;
    DatabaseHelper mDatabaseHelper;
    Courses course;

    private DatabaseReference myRef;

    public CourseListAdapter(ArrayList<Courses> courseList, Context context) {
        super(context, R.layout.row_item, courseList);
        this.courseList = courseList;
        this.context = context;
        mDatabaseHelper = new DatabaseHelper(context);

    }

    public CourseListAdapter(@NonNull Context context, int resource, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }

    public CourseListAdapter(@NonNull Context context, int resource, int textViewResourceId, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource, textViewResourceId);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }

    public CourseListAdapter(@NonNull Context context, int resource, @NonNull Courses[] objects, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource, objects);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }

    public CourseListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Courses[] objects, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource, textViewResourceId, objects);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }

    public CourseListAdapter(@NonNull Context context, int resource, @NonNull List<Courses> objects, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource, objects);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }

    public CourseListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Courses> objects, ArrayList<Courses> courseList, Context context1, DatabaseHelper mDatabaseHelper, Courses course) {
        super(context, resource, textViewResourceId, objects);
        this.courseList = courseList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.course = course;
    }




    // View lookup cache
    private static class ViewHolder {
        TextView courseName;
        TextView courseId;


    }



    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder; // view lookup cache stored in tag
//
        final View result;
        holder = new ViewHolder();
        final String[] name = new String[1];
        final String[] id = new String[1];
        if (convertView == null) {


            final FirebaseDatabase[] database = {FirebaseDatabase.getInstance()};
            myRef = database[0].getReference("Courses");

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            holder.courseId = convertView.findViewById(R.id.courseid);
            holder.courseName = convertView.findViewById(R.id.coursename);

            result = convertView;
            convertView.setTag(holder);

            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                    Courses value = dataSnapshot.getValue(Courses.class);
                    name[0] =value.getcourseName();
                    id[0] =value.getcourseId();

                    Log.d(TAG, "Value is: " + value.getcourseName() + value.getcourseId());
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });


        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        holder.courseId.setText(String.valueOf(name[0]));
        holder.courseName.setText(String.valueOf(id[0]));
        return result;




//
//        final Courses course = getItem(position);
//
////        Log.i("CLA", "Course : " + course);
//        ViewHolder holder; // view lookup cache stored in tag
//
//        final View result;
//
//        if (convertView == null) {
//
//            holder = new ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView = inflater.inflate(R.layout.row_item, parent, false);
//            holder.courseId = convertView.findViewById(R.id.courseid);
//            holder.courseName = convertView.findViewById(R.id.coursename);
////            holder.edit = convertView.findViewById(R.id.editButton);
////            holder.delete = convertView.findViewById(R.id.cancelButton);
//
//            result = convertView;
//
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//            result = convertView;
//        }
//
//
//
//
//        holder.courseId.setText(String.valueOf(course.getCourseId()));
//        holder.courseName.setText(String.valueOf(course.getCourseName()));
////        holder.edit.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View view) {
////                Log.i("CLA", "Customer data: " + mDatabaseHelper.getData());
////                Log.i("CLA", "Customer data: " +mDatabaseHelper.getCustomerDetails(customer.getCusEmail()));
////                Cursor data = mDatabaseHelper.getCustomerDetails(customer.getCusEmail()); //get the id associated with that name
////                int itemID = -1;
////                String itemfname="";
////                while (data.moveToNext()) {
////                    itemID = data.getInt(0);
////
////
////                    if (itemID > -1) {
////                        Log.d(TAG, "onItemClick: The ID is: " + itemID);
////                        Log.d(TAG, "onItemClick: The ID is: " + itemfname);
////                        Intent editScreenIntent = new Intent(context.getApplicationContext(), EditDetails.class);
////                        editScreenIntent.putExtra("Firstname", data.getString(1));
////                        editScreenIntent.putExtra("Surname", data.getString(2));
////                        editScreenIntent.putExtra("DOB", data.getString(3));
////                        editScreenIntent.putExtra("ID", data.getString(4));
////                        editScreenIntent.putExtra("Gender", data.getString(5));
////                        editScreenIntent.putExtra("Email", data.getString(6));
////                        Log.i("CLA", "gender: " + data.getString(5));
////                        Log.i("CLA", "email: " + data.getString(6));
////                        Log.i("CR EDIT", "ID FOUND: ");
////                        editScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////
////                        view.getContext().startActivity(editScreenIntent);
////                    } else {
////
////                        Log.i("CR EDIT", "NO ID ASSOCIATED WITH THAT NAME: ");
////                    }
////                }
////            }
////        });
////        holder.delete.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Cursor customerID= mDatabaseHelper.getCustomerID(customer.getCusEmail());
////                mDatabaseHelper.deleteDetails(customerID);
////
////                Log.i("CLA", "DELETE DETAILS FOR: " + customerID);
////                notifyDataSetChanged();
////
////
////            }
//
//
////        });
//        // Return the completed view to render on screen
////        convertView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context.getApplicationContext(), MarkActivity.class);
////                v.getContext().startActivity(intent);
////            }
////        });
//        return result;
    }

}
