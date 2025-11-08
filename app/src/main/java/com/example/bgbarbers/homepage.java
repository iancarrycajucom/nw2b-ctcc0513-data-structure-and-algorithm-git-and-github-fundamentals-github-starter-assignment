package com.example.bgbarbers;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // --- Initialize All Views ---
        TextView userText = findViewById(R.id.textView4);
        bottomNav = findViewById(R.id.bottomNav);


        // --- Set Listeners ---
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        // Set the Home item as selected initially
        bottomNav.setSelectedItemId(R.id.nav_home);

        // Bottom Navigation item selected listener
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                // You are already on the Home page, do nothing.
                return true;
            } else if (itemId == R.id.nav_appointment) {
                // Go to Appointment page
                //startActivity(new Intent(getApplicationContext(), AppointmentActivity.class));
                overridePendingTransition(0, 0); // No animation
                finish(); // Finish this activity to prevent stacking
                return true;
            } else if (itemId == R.id.nav_add) {
                // Go to Add page
                //startActivity(new Intent(getApplicationContext(), AddActivity.class));
                overridePendingTransition(0, 0);
                finish(); // Finish this activity to prevent stacking
                return true;
            } else if (itemId == R.id.nav_profile) {
                // Go to Profile page
              //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                overridePendingTransition(0, 0);
                finish(); // Finish this activity to prevent stacking
                return true;
            }
            return false;
        });
    }

    // This method is no longer needed because we now call finish() when switching activities,
    // which makes this behavior more reliable and standard.
    // @Override
    // protected void onResume() {
    //     super.onResume();
    //     // Keep the Home icon selected when the user returns to this page
    //     bottomNav.setSelectedItemId(R.id.nav_home);
    // }
}
