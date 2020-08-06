package com.example.myweatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.Objects;

public class OptionsActivity extends AppCompatActivity {

    final static String dataKey = "dataKey";
    final static String dataKeyWind = "dataKeyWind";
    final static String dataKeyPressure = "dataKeyPressure";
    private Button btnOK;
    private Spinner spinnerChooseCity;
    private CheckBox windSpeed;
    private CheckBox pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        findViews();
        showBackBtn();
        setOnClickToBtnOK();
    }

    private void findViews(){
        btnOK = findViewById(R.id.btnOK);
        spinnerChooseCity = findViewById(R.id.spinnerChooseCity);
        windSpeed = findViewById(R.id.windSpeed);
        pressure = findViewById(R.id.pressure);
    }

    private void showBackBtn() {
        try {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setOnClickToBtnOK() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionsActivity.this, MainActivity.class);

                String userCity = spinnerChooseCity.getSelectedItem().toString();
                intent.putExtra(dataKey, userCity);

                if (windSpeed.isChecked()){
                    String wind = "Wind speed: 3 m/s";
                    intent.putExtra(dataKeyWind, wind);
                }
                if (pressure.isChecked()){
                    String pressure = "Pressure: 1019 hPa";
                    intent.putExtra(dataKeyPressure, pressure);
                }

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }

}