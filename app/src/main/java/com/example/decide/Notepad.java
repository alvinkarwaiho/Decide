package com.example.decide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Notepad extends AppCompatActivity {
    private EditText input1;
    private Toolbar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        bar = findViewById(R.id.toolbar);
        bar.setTitle("Notepad");
        FloatingActionButton delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.getText().clear();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Save("theNotes.txt");

            }
        });
        input1 = findViewById(R.id.enter);
        input1.setText(Open("theNotes.txt"));
        bottomNav();


    }
    public void bottomNav(){
        BottomNavigationView botNavView = findViewById(R.id.navigation_bottom);
        botNavView.setSelectedItemId(R.id.decisions);
        botNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.decisions:
                        startActivity(new Intent(getApplicationContext(),Decision.class));
                        return true;
                    case R.id.home1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                    case R.id.notepad:
                        return true;
                }
                return false;
            }
        });
    }
    public void Save(String nameOfFile){
       input1 = findViewById(R.id.enter);
        try{
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(nameOfFile,0));
            osw.write(input1.getText().toString());
            osw.close();
            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();

        }
        catch (Throwable exception){
            Toast.makeText(this,"Exception" + exception.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public String Open(String nameOfFile){
        String content = "";
        if(FileExists(nameOfFile)){
            try {
                InputStream input = openFileInput(nameOfFile);
                if(input != null){
                    InputStreamReader temporarily = new InputStreamReader(input);
                    BufferedReader read = new BufferedReader(temporarily);
                    String s;
                    StringBuilder buffer = new StringBuilder();
                    while((s = read.readLine()) != null){
                        buffer.append(s +"\n");
                    } input.close();
                    content = buffer.toString();
                }
            } catch(java.io.FileNotFoundException exception){ }catch (Throwable t){
                Toast.makeText(this, "Exception :"+ t.toString(),Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }
    public boolean FileExists(String fileName) {
        File theFile = getBaseContext().getFileStreamPath(fileName);
        return  theFile.exists();
    }

}
