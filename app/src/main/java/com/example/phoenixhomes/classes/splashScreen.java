package com.example.phoenixhomes.classes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phoenixhomes.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splashScreen extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mFirebaseAuth = FirebaseAuth.getInstance();
        //hide title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent intent = new Intent(splashScreen.this, userLogin.class);
                startActivity(intent);
                finish();

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    //there is some user logged in take to home page
                    startActivity(new Intent(splashScreen.this, MainActivity.class));
                }
                else{
                    startActivity(new Intent(splashScreen.this, userLogin.class));
                }

            }
        },1500);

    }

}