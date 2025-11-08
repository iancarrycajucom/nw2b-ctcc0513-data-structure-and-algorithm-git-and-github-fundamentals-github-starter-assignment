package com.example.bgbarbers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;

    private String userRole; // Variable to store the role passed from RolesActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Your standard login layout

        // Initialize views
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        // --- RECEIVE THE ROLE from RolesActivity ---
        Intent intent = getIntent();
        userRole = intent.getStringExtra(roles.ROLE_KEY);
        if (userRole == null) {
            // Default to "Customer" if something goes wrong, or handle the error
            userRole = "Customer";
        }

        // Set the text on the login button to be more specific
        loginButton.setText("Login as " + userRole);


        // --- UNIVERSAL LOGIN BUTTON LISTENER ---
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Check if the role is "Customer"
            if (userRole.equals("Customer")) {
                if (username.equals("John do") && password.equals("1234")) {
                    // SUCCESS: Go to customer homepage
                    Intent customerIntent = new Intent(MainActivity.this, homepage.class);
                    startActivity(customerIntent);
                    finish();
                } else {
                    // FAILURE
                    Toast.makeText(MainActivity.this, "Invalid Customer credentials", Toast.LENGTH_SHORT).show();
                }
            }
            // Check if the role is "Barber"
            else if (userRole.equals("Barber")) {
                // Using "barber" and "shop123" as example barber credentials
                if (username.equals("Miguel") && password.equals("1234")) {
                    // SUCCESS: Go to barber homepage
                    Intent barberIntent = new Intent(MainActivity.this, BarberHomepage.class);
                    startActivity(barberIntent);
                    finish();
                } else {
                    // FAILURE
                    Toast.makeText(MainActivity.this, "Invalid Barber credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
