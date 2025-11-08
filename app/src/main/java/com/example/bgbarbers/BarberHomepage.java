package com.example.bgbarbers;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BarberHomepage extends AppCompatActivity {

    ImageView menuButton; // ✨ Declare the menu button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_homepage);

        // Initialize the menu button
        menuButton = findViewById(R.id.menuButton);

        // ✨ Set a listener for the menu button
        menuButton.setOnClickListener(v -> {
            // Create a PopupMenu
            PopupMenu popup = new PopupMenu(BarberHomepage.this, v);

            // Inflate the menu from the XML file
            popup.getMenuInflater().inflate(R.menu.barber_topmenu, popup.getMenu());

            // Set a listener for menu item clicks
            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.action_logout) {
                    // Handle the logout action
                    logoutUser();
                    return true;
                }
                return false;
            });

            // Show the popup menu
            popup.show();
        });
    }

    /**
     * Handles the user logout process.
     * Navigates back to the RolesActivity and clears the activity stack.
     */
    private void logoutUser() {
        // Show a confirmation message
        Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();

        // Create an Intent to go back to the RolesActivity (the very first screen)
        Intent intent = new Intent(BarberHomepage.this, roles.class);

        // These flags clear the entire task stack and start a new one.
        // This prevents the user from pressing "back" to get into the logged-in area.
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish(); // Close the BarberHomepageActivity
    }
}
