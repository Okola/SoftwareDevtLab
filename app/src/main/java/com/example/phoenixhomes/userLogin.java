package com.example.phoenixhomes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class userLogin extends AppCompatActivity {

    private TextView register; //private variable for register button
    private TextView forgotPassword;//private variable for forgot password
    private EditText editTextEmail, editTextPassword;//private variable to detect the email and password
    private Button signIn;
    private FirebaseAuth mAuth;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        register = (TextView) findViewById(R.id.register); //initializing register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(userLogin.this,user_registration.class));

            }
        });

        signIn = (Button) findViewById(R.id.signIn);//initializing the sign in button
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login();
            }
        });

        //initializing the edit text email and password
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        //initializing the progress bar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //initializing the mauth firebase variable
        mAuth = FirebaseAuth.getInstance();

    }


    private void Login() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //validation of credentials
        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid Email!");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Password should contain a minimum of  6 characters");
            editTextPassword.requestFocus();
            return;
        }


        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Signing In...");
        dialog.show();


        //sign user in with email and password
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            //checking to see if email is verified
                            dialog.setMessage("Checking Verification...");
                            dialog.show();
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


                            assert user != null;
                            if (user.isEmailVerified()) {
                                dialog.dismiss();
                                String currentUserId = user.getUid();

                                db = FirebaseDatabase.getInstance();
                                ref = db.getReference();

                                FirebaseDatabase db = FirebaseDatabase.getInstance();
                                DatabaseReference ref = db.getReference()
                                        .child("Users")
                                        .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                        .child("Personal Details");


                                startActivity(new Intent(userLogin.this, MainActivity.class));


                            } else {
                                //send email verification link
                                user.sendEmailVerification();
                                Toast.makeText(userLogin.this, "Check your Email to verify account To sign In", Toast.LENGTH_LONG).show();
                                dialog.dismiss();


                            }

                        } else {
                            Toast.makeText(userLogin.this, "Failed to login!", Toast.LENGTH_LONG).show();
                            dialog.dismiss();

                        }
                    }
                });



    }
    


}
  








    