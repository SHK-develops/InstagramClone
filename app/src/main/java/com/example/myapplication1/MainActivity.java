/***********************************************************************
 * Original Author: Hemanth Kamal
 * File Creation Date: August 17, 2020
 * Description: Appilication MainScreen Activities.
 ***********************************************************************/


package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;                  // Declare an instance of FirebaseAuth
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();           //Initialize the FirebaseAuth instance
        mCurrentUser= mAuth.getCurrentUser();

    }

    // Checking whether User is signed in or not, if not navigate to Authentication screen

    @Override
    protected void onStart() {
        super.onStart();
        if(mCurrentUser == null){
            Intent loginIntent = new Intent(MainActivity.this, Authentication.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);
            finish();
        }
    }
}