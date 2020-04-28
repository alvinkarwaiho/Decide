package com.example.decide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Holiday extends AppCompatActivity {
    private Button generateTwo;
    private Button generateThree;
    private Button generateFour;
    private TextView optionTwo;
    private TextView optionThree;
    private TextView optionFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        generateTwo = findViewById(R.id.generate2holiday);
        generateThree = findViewById(R.id.generate3holiday);
        generateFour = findViewById(R.id.generate4holiday);
        optionTwo = findViewById(R.id.decision1holiday);
        optionThree = findViewById(R.id.decision2holiday);
        optionFour = findViewById(R.id.decision3holiday);
        twoGeneratedButton();
        threeGeneratedButton();
        fourGeneratedButton();
    }
    public void twoGeneratedButton() {
        generateTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(2) + 1;
                optionTwo.setText(String.valueOf(result));
            }
        });
    }

    public void threeGeneratedButton() {
        generateThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(3) + 1;
                optionThree.setText(String.valueOf(result));
            }
        });

    }

    public void fourGeneratedButton() {
        generateFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(4) + 1;
                optionFour.setText(String.valueOf(result));
            }
        });
    }
}
