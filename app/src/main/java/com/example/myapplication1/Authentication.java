/***********************************************************************
 * Original Author: Hemanth Kamal
 * File Creation Date: August 17, 2020
 * Description: Generating OTP by using Phone Number and Country code.
 ***********************************************************************/

package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Authentication extends AppCompatActivity {

    // declaring variables
    private FirebaseAuth mAuth;                     // Declare an instance of FirebaseAuth
    private FirebaseUser mCurrentUser;

    // variables which are designed in activity_authentication.XML file

    private EditText mCountryCode;
    private EditText mPhoneNumber;
    private Button mGenerateButton;
    private ProgressBar mAuthProgress;
    private TextView mAuthFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

         // Initializing all declared variables

        mAuth=FirebaseAuth.getInstance();               //Initialize the FirebaseAuth instance
        mCurrentUser= mAuth.getCurrentUser();

        mCountryCode = findViewById(R.id.CountryCodeText);
        mPhoneNumber = findViewById(R.id.PhoneNumberText);
        mGenerateButton = findViewById(R.id.GenerateButton);
        mAuthProgress = findViewById(R.id.AuthProgressBar);
        mAuthFeedback = findViewById(R.id.AuthFeedback);

        // Assigning the input values when the user clicks on the GenerateOTP Button.

        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String countryCode = mCountryCode.getText().toString();
                String phoneNumber = mPhoneNumber.getText().toString();
            }
        });
    }

    // Checking whether User is signed in or not, if not navigate to Authentication screen

    @Override
    protected void onStart() {
        super.onStart();
        if(mCurrentUser == null){
            Intent homeIntent = new Intent(Authentication.this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(homeIntent);
            finish();
        }
    }
}