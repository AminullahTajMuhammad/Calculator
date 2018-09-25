package com.myfirstapplication.amin.calclutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    TextView textView;
    Button counterbtn, resetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvcounter);
        counterbtn = (Button) findViewById(R.id.btncounter);
        resetbtn = (Button) findViewById(R.id.reset);

        counterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                textView.setText("Your Counter is: "+counter);
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                textView.setText("Your Counter is: "+counter);
            }
        });
    }
}