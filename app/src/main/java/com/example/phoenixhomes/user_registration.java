package com.example.phoenixhomes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;

public class user_registration extends AppCompatActivity {


    private FirebaseAuth mAuth; //creating a firebase authentication variable called mAuth
    private TextView typetext;
    private EditText editTextFullnames, editTextPhoneNumber, editTextEmail, editTextPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        mAuth = FirebaseAuth.getInstance();//initializing the firebase mAuth variable

        TextView registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        editTextFullnames = (EditText) findViewById(R.id.fullNames);
        editTextPhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }



    private void registerUser() {

        //Takes the inputs from the registration forms and converting them to strings
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullNames = editTextFullnames.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();





        //if statements to validate the inputs above
        if (fullNames.isEmpty()) {
            editTextFullnames.setError("full names are required");
            editTextFullnames.requestApplyInsets();
            return;
        }
        if (phoneNumber.isEmpty()) {
            editTextPhoneNumber.setError("A phone number is required");
            editTextPhoneNumber.requestApplyInsets();
            return;
        }
        if (email.isEmpty()) {
            editTextEmail.setError("An email is required");
            editTextEmail.requestApplyInsets();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("please provide a valid email");
            editTextEmail.requestFocus();
            return;
        }


        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestApplyInsets();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("password should consist of more than 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Registering...");
        dialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //check to see if the user has been registered//
                        if (task.isSuccessful()) {

                            String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();

                            User user = new User(fullNames, phoneNumber, email, password,userId);

                            //sending the user to the database//
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .child("Personal Details")
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {


                                            if (task.isSuccessful()) {
                                                dialog.setMessage("Checking Verification...");
                                                dialog.show();
                                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                                if (user.isEmailVerified()) {
                                                    dialog.dismiss();
                                                    Intent intent = new Intent(user_registration.this, userLogin.class);
                                                    intent.putExtra("userId", userId);
                                                    startActivity(intent);
                                                } else {

                                                    user.sendEmailVerification();
                                                    Toast.makeText(user_registration.this, "Check your Email to verify account", Toast.LENGTH_LONG).show();
                                                    dialog.dismiss();
                                                    finish();
                                                }
                                            } else {
                                                Toast.makeText(user_registration.this, "Registration Failed! Try again!", Toast.LENGTH_LONG).show();
                                                dialog.dismiss();
                                            }


                                        }
                                    });


                        } else {
                            Toast.makeText(user_registration.this, "Registration Failed! Try again!", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }
                });

    }
}