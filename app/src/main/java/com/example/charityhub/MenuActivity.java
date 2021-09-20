package com.example.charityhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;


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


public class MenuActivity extends AppCompatActivity  {

    ImageView menu;
    ImageView events;
    ImageView money;
    ImageView food;
    ImageView clothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);


        menu= (ImageView) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, SidemenuActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        events = (ImageView) findViewById(R.id.events);

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, EventActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        money = (ImageView) findViewById(R.id.money);

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, MoneyActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        food = (ImageView) findViewById(R.id.food);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, FoodActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        clothes = (ImageView) findViewById(R.id.clothes);

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MenuActivity.this, ClothesActivity.class);
              startActivity(intentLoadNewActivity);
            }
        });



    }
}
