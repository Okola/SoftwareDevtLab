package com.example.phoenixhomes.classes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.phoenixhomes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotten_password extends AppCompatActivity {

    //creation of variables//
    private EditText emailEditText;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);


        //initialize the variables
        emailEditText = (EditText) findViewById(R.id.email);
        Button resetPasswordButton = (Button) findViewById(R.id.resetPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        //making the reset button clickable//
        resetPasswordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetPassword();//when clicked calls the method resetPassword
            }

            private void resetPassword() {
                String email = emailEditText.getText().toString().trim();//gets the email and converts it to a string, trim is to cater for any space that might be added by the user

                //validation of the email
                if(email.isEmpty()){
                    emailEditText.setError("Email is required!");
                    emailEditText.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailEditText.setError("Enter a valid email");
                    emailEditText.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(forgotten_password.this,"Check your email to reset password!",Toast.LENGTH_LONG).show();


                            Intent i = new Intent(forgotten_password.this, userLogin.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(forgotten_password.this, "Try again! An error occured!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}