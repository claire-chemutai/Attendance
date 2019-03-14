package com.app.study.attendanceproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by study on 3/10/2019.
 */

public class StudentListAdapter extends ArrayAdapter<Student> {
    private static final String TAG ="StudentListAdapters" ;
    ArrayList<Student> studentList;
    Context context;
    DatabaseHelper mDatabaseHelper;
    Student student;

    public StudentListAdapter(ArrayList<Student> studentList, Context context) {
        super(context, R.layout.row_item, studentList);
        this.studentList = studentList;
        this.context = context;
        mDatabaseHelper = new DatabaseHelper(context);

    }

    public StudentListAdapter(@NonNull Context context, int resource, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }

    public StudentListAdapter(@NonNull Context context, int resource, int textViewResourceId, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource, textViewResourceId);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }

    public StudentListAdapter(@NonNull Context context, int resource, @NonNull Student[] objects, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource, objects);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }

    public StudentListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Student[] objects, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource, textViewResourceId, objects);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }

    public StudentListAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource, objects);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }

    public StudentListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Student> objects, ArrayList<Student> studentList, Context context1, DatabaseHelper mDatabaseHelper, Student student) {
        super(context, resource, textViewResourceId, objects);
        this.studentList = studentList;
        this.context = context1;
        this.mDatabaseHelper = mDatabaseHelper;
        this.student = student;
    }



    public static class DataHolder {
        TextView studentName;
        TextView studentId;
        ToggleButton toggleButton;

    }
//    public View getView(final int position, View convertView, ViewGroup parent) {
//
////        final Student student = getItem(position);
//
////        Log.i("CLA", "Course : " + course);
//        DataHolder holder; // view lookup cache stored in tag
//
//        final View result;
//
//        if (convertView == null) {
//
//            holder = new DataHolder();
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView = inflater.inflate(R.layout.row_item_mark, parent, false);
//            holder.studentId = convertView.findViewById(R.id.studentid);
//            holder.studentName = convertView.findViewById(R.id.studentname);
//            holder.toggleButton = convertView.findViewById(R.id.toggleButton);
////            holder.edit = convertView.findViewById(R.id.editButton);
////            holder.delete = convertView.findViewById(R.id.cancelButton);
//
//            result = convertView;
//
//            convertView.setTag(holder);
//        } else {
//            holder = (StudentListAdapter.DataHolder) convertView.getTag();
//            result = convertView;
//        }
//
//
//
//
//        holder.studentId.setText(String.valueOf(student.getStudentId()));
//        holder.studentName.setText(String.valueOf(student.getStudentName()));
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
//    }




    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "StudentListAdapter{}";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
