package com.example.bgbarbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Import EditText
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    // --- Declare all UI elements ---
    EditText usernameEditText;
    EditText passwordEditText;
    Button customerSignupButton;
    Button barberSignupButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Link this Java file to your XML layout
        setContentView(R.layout.activity_signup);

        // --- Initialize all UI elements by their ID from the XML ---
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        customerSignupButton = findViewById(R.id.customerSignupButton);
        barberSignupButton = findViewById(R.id.barberSignupButton);
        backButton = findViewById(R.id.backButton);

        // --- Set listener for the CUSTOMER "Sign Up" button ---
        customerSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You can get the text from the EditText fields here if needed
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Show the success message for customers
                Toast.makeText(signup.this, "Sign up successful!", Toast.LENGTH_LONG).show();
                // TODO: Add logic here to save the new customer to your database
            }
        });

        // --- Set listener for the BARBER "Sign Up" button ---
        barberSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You can get the text from the EditText fields here if needed
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Show the success message for barbers
                Toast.makeText(signup.this, "Successfully signed up as a Barber!", Toast.LENGTH_LONG).show();
                // TODO: Add logic here to save the new barber to your database
            }
        });

        // --- Set listener for the "Back" Button ---
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous screen
                finish();
            }
        });
    }
}
