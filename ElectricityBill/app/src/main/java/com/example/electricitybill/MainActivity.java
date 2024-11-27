package com.example.electricitybill;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the app name as the title in the top bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        // Initialize the Bottom Navigation View
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Set up AppBarConfiguration with all top-level destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,    // Home -> Electricity Calculation
                R.id.navigation_formula, // Formula page
                R.id.navigation_about    // About Us page
        ).build();

        // Set up NavController for navigation handling
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Link the NavigationUI to the Bottom Navigation View and Toolbar
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
