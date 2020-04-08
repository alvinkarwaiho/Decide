package com.example.decide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Holiday extends AppCompatActivity {
    private Button randomOnClick2;
    private Button randomOnClick3;
    private Button randomOnClick4;
    private TextView option2;
    private TextView option3;
    private TextView option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        randomOnClick2 = findViewById(R.id.generate2holiday);
        randomOnClick3 = findViewById(R.id.generate3holiday);
        randomOnClick4 = findViewById(R.id.generate4holiday);
        option2 = findViewById(R.id.decision1holiday);
        option3 = findViewById(R.id.decision2holiday);
        option4 = findViewById(R.id.decision3tasks);
        twoGeneratedButton();
        threeGeneratedButton();
        fourGeneratedButton();
    }
    public void twoGeneratedButton() {
        randomOnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(2) + 1;
                option2.setText(String.valueOf(result));
            }
        });
    }

    public void threeGeneratedButton() {
        randomOnClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(3) + 1;
                option3.setText(String.valueOf(result));
            }
        });

    }

    public void fourGeneratedButton() {
        randomOnClick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int result = random.nextInt(4) + 1;
                option4.setText(String.valueOf(result));
            }
        });
    }
}
