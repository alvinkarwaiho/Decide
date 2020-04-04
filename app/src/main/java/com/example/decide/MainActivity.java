package com.example.decide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView botnavview = findViewById(R.id.navigation_bottom);
        botnavview.setSelectedItemId(R.id.decisions);

        botnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              switch(menuItem.getItemId()){
                  case R.id.decisions:
                      startActivity(new Intent(getApplicationContext(),Decision.class));
                        return true;
                  case R.id.home1:
                      startActivity(new Intent(getApplicationContext(),Decision.class));
                      return true;
                  case R.id.notepad:
                      startActivity(new Intent(getApplicationContext(),Decision.class));
                      return true;
              }
                return false;
            }
        });
    }
}
