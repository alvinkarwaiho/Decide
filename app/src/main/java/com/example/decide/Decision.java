package com.example.decide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Decision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);
        bottomNav();
        buttonOnClick();
    }
    public void bottomNav(){
        BottomNavigationView botNavView = findViewById(R.id.navigation_bottom);
        botNavView.setSelectedItemId(R.id.decisions);
        botNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.decisions:
                        return true;
                    case R.id.home1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                    case R.id.notepad:
                        startActivity(new Intent(getApplicationContext(),Notepad.class));
                        return true;
                }
                return false;
            }
        });
    }
    public void buttonOnClick(){
        Button general = findViewById(R.id.general);
        Button tasks = findViewById(R.id.task);
        Button furniture = findViewById(R.id.furniture);
        Button holiday = findViewById(R.id.holiday);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGeneral();
            }
        });
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTasks();
            }
        });
        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFurniture();
            }
        });
        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHoliday();
            }
        });
    }
    public void startGeneral(){
        Intent intent = new Intent(this, General.class);
        startActivity(intent);
    }
    public void startFurniture(){
        Intent intent = new Intent(this, Furniture.class);
        startActivity(intent);
    }
    public void startTasks(){
        Intent intent = new Intent(this, Tasks.class);
        startActivity(intent);
    }
    public void startHoliday(){
        Intent intent = new Intent(this, Holiday.class);
        startActivity(intent);
    }
}
