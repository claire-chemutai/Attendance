package com.app.study.attendanceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class FacultyActivity extends AppCompatActivity {
//    private FloatingNavigationView mFloatingNavigationView;
    private Button mark_attendance, view_attendance,view_report,logout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();

        mark_attendance =  findViewById(R.id.mark_attendance);
        view_attendance =  findViewById(R.id.view_attendance);
        view_report =  findViewById(R.id.view_report);
        logout =  findViewById(R.id.log_out);

//        mFloatingNavigationView =  findViewById(R.id.floating_navigation_view);
//        mFloatingNavigationView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mFloatingNavigationView.open();
//            }
//        });
//        mFloatingNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                Snackbar.make((View) mFloatingNavigationView.getParent(), item.getTitle() + " Selected!", Snackbar.LENGTH_SHORT).show();
//                mFloatingNavigationView.close();
//                return true;
//            }
//        });

        mark_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassesActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        if (mFloatingNavigationView.isOpened()) {
//            mFloatingNavigationView.close();
//        } else {
//            super.onBackPressed();
//        }
//    }

//   

}
