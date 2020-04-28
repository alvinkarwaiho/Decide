package com.example.decide;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Notepad extends AppCompatActivity {
    private EditText enterInformation;
    private Toolbar decoratedTitle;
    private String detail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        decoratedTitle = findViewById(R.id.toolbar);
        decoratedTitle.setTitle("Notepad");


        enterInformation = findViewById(R.id.enter);
        enterInformation.setText(Open("theNotes.txt"));
        bottomNav();
        clearNotes();
        saveNotes();
    }
    public void saveNotes(){
        FloatingActionButton save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save("theNotes.txt");
            }
        });
    }
    public void clearNotes(){
        FloatingActionButton clear = findViewById(R.id.delete);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterInformation.getText().clear();
            }
        });
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
       enterInformation = findViewById(R.id.enter);
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(nameOfFile,0));
            outputStreamWriter.write(enterInformation.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, "New note has been saved", Toast.LENGTH_SHORT).show();

        }
        catch (Throwable exception){
            Toast.makeText(this,"Exception" + exception.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public String Open(String nameOfFile){
            try {
                InputStream inputStream = openFileInput(nameOfFile);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader read = new BufferedReader(inputStreamReader);
                String local;
                StringBuilder stringBuilder = new StringBuilder();
                while((local = read.readLine()) != null){
                    stringBuilder.append(local +"\n");
                } inputStream.close();
                    detail = stringBuilder.toString();
            } catch (FileNotFoundException fileNotFound){
                Toast.makeText(this, "File not found Exception"+ fileNotFound.toString(),Toast.LENGTH_LONG).show();
            }
            catch (IOException io){
                Toast.makeText(this, "Input or Output Exception"+io.toString(),Toast.LENGTH_SHORT).show();
            }
        return detail;
    }


}
