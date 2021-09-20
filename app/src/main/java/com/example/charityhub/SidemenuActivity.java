package com.example.charityhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class SidemenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidemenu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close );
        //drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState== null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_profile);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.ProfileFragment()).commit();
                break;
            case R.id.nav_donation_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.DonationHistoryFragment()).commit();
                break;
            case R.id.nav_track_donation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.TrackDonationFragment()).commit();
                break;
            case R.id.nav_edit_my_location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.EditLocationFragment()).commit();
                break;
            case R.id.nav_settings_applications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.SettingsApplicationFragment()).commit();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.charityhub.HelpFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
