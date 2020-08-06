package com.example.myweatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView optionsView;
    private TextView userCity;
    private TextView windSpeedView;
    private TextView atmPressureView;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setOnClickToOptionsView();
        showDataFromOptionsActivity();
    }

    private void findViews(){
        optionsView = findViewById(R.id.optionsView);
        userCity = findViewById(R.id.userCity);
        windSpeedView = findViewById(R.id.windSpeed_textview);
        atmPressureView = findViewById(R.id.atmospheric_pressure_textview);
    }

    private void setOnClickToOptionsView(){
        optionsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(intent);
                Log.d(TAG, "launch OptionsActivity");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

    private void showDataFromOptionsActivity(){
        String data = getIntent().getStringExtra(OptionsActivity.dataKey);
        userCity.setText(data);

        String windData = getIntent().getStringExtra(OptionsActivity.dataKeyWind);
        windSpeedView.setText(windData);

        String pressureData = getIntent().getStringExtra(OptionsActivity.dataKeyPressure);
        atmPressureView.setText(pressureData);
    }
}