package com.example.decide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class General extends AppCompatActivity {
    private Button generateTwo;
    private Button generateThree;
    private Button generateFour;
    private TextView optionTwo;
    private TextView optionThree;
    private TextView optionFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        generateTwo = findViewById(R.id.generate2);
        generateThree = findViewById(R.id.generate3);
        generateFour = findViewById(R.id.generate4);
        optionTwo = findViewById(R.id.decision1);
        optionThree = findViewById(R.id.decision2);
        optionFour = findViewById(R.id.decision3);
        generateTwoOptions();
        generateThreeOptions();
        generateFourOptions();
    }

    public void generateTwoOptions(){
        generateTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(2) +1 ;
                optionTwo.setText(String.valueOf(result));
            }
        });
    }
    public void generateThreeOptions(){
        generateThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(3)+1;
                optionThree.setText(String.valueOf(result));
            }
        });

    }
    public void generateFourOptions(){
        generateFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(4)+1;
                optionFour.setText(String.valueOf(result));
            }
        });
    }
}
