package com.example.bgbarbers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView; // ✨ Import TextView
import androidx.appcompat.app.AppCompatActivity;

public class roles extends AppCompatActivity {

    Button customerLoginButton;
    Button barberLoginButton;
    TextView signupTextView; // ✨ Declare the signup TextView

    public static final String ROLE_KEY = "USER_ROLE"; // Key to send the role

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);

        // Initialize buttons and the new TextView
        customerLoginButton = findViewById(R.id.customerLoginButton);
        barberLoginButton = findViewById(R.id.barberLoginButton);
        signupTextView = findViewById(R.id.signupTextView); // ✨ Initialize the TextView

        // --- Set Styled Text for the TextView ---
        String text = "Don't have an account?  <b><u>Sign up</u></b>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            signupTextView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        } else {
            signupTextView.setText(Html.fromHtml(text));
        }

        // --- Set listener for the "Sign up" TextView ---
        signupTextView.setOnClickListener(v -> {
            // Create an Intent to go to the signup activity
            Intent intent = new Intent(roles.this, signup.class);
            startActivity(intent);
        });

        // Set listener for the Customer Login button
        customerLoginButton.setOnClickListener(v -> {
            // Go to MainActivity and tell it the role is "Customer"
            Intent intent = new Intent(roles.this, MainActivity.class);
            intent.putExtra(ROLE_KEY, "Customer");
            startActivity(intent);
        });

        // Set listener for the Barber Login button
        barberLoginButton.setOnClickListener(v -> {
            // Go to MainActivity and tell it the role is "Barber"
            Intent intent = new Intent(roles.this, MainActivity.class);
            intent.putExtra(ROLE_KEY, "Barber");
            startActivity(intent);
        });
    }
}
