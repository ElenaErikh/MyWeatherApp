package com.example.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnBtnClickBehaviour();
    }

    private void initViews(){
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
    }

    private void setOnBtnClickBehaviour(){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textView.setText(R.string.weather_text);
                int color = ContextCompat.getColor(getApplicationContext(), R.color.colorAccent);
                textView.setTextColor(color);
            }
        });
    }
}