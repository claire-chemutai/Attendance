package com.app.study.attendanceproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private EditText _emailText,_passwordText;
    private Button _loginButton;
    private TextView _signupLink;

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    Account account;

    @Override
    public void onStart(){
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _emailText= findViewById(R.id.input_email);
        _passwordText= findViewById(R.id.input_password);
        _loginButton= findViewById(R.id.btn_login);
        _signupLink= findViewById(R.id.link_signup);

        database = FirebaseDatabase.getInstance();
        myRef= database.getReference("Account");
        account=new Account();




        _loginButton.setOnClickListener(new View.OnClickListener() {
            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();

            @Override
            public void onClick(View v) {
//                login(email, password);
                Intent intent= new Intent(LoginActivity.this, FacultyActivity.class);
                startActivity(intent);
            }


        });



        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }




    private void updateUI(FirebaseUser currentUser) {
    }



    public void login(final String email, String password) {
//        final String mail=email;

        Log.d(TAG, "Login");

        if (!validate(email, password)) {
            onLoginFailed();
            return;
        }

        if (validate(email, password)) {
            onLoginSuccess(email);
            return;
        }

//            myRef.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    for(DataSnapshot ds: dataSnapshot.getChildren()){
//                        account=ds.getValue(Account.class);
//                        if(account.get_emailText().equals(mail) &&  mail.contains("nurse@")){
//                            onNurseLoginSuccess();
//
//                        }
//                        else if(account.get_emailText().equals(mail) &&  mail.contains("admin@")){
//                            onAdminLoginSuccess();
//
//                        }
//                        else{
//                            Toast.makeText(getBaseContext(), "Account does not exist", Toast.LENGTH_LONG).show();
//
//                        }
//
//
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });




        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });






        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess(email);

                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(String email) {
        _loginButton.setEnabled(true);
        //finish();
        if(email.contains("nurse@")){
            Intent intent= new Intent(LoginActivity.this, NurseActivity.class);
            startActivity(intent);

        }
        else if(email.contains("admin@")) {
            Intent intent= new Intent(LoginActivity.this, FacultyActivity.class);
            startActivity(intent);
        }

    }




    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate(String email, String password) {
        boolean valid = true;

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        }
        else {
            _passwordText.setError(null);
        }



        return valid;
    }
}

