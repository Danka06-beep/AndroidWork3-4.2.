package com.example.androidwork3_42;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.onActivityCreateSetTheme(this);

        Button buttonOk = findViewById(R.id.ok);
        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinnerSize = findViewById(R.id.spinnerSize);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.local, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<?> adapterSize = ArrayAdapter.createFromResource(this, R.array.Size, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(adapterSize);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = (String) spinner.getSelectedItem();
                switch (selected) {
                    case ("Английский"):
                        createLocal("en");
                        break;
                    case ("Russian"):
                        createLocal("ru");
                        break;
                }
                String selectedSize = (String) spinnerSize.getSelectedItem();
                switch (selectedSize){
                    case ("Крупная"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_LARGE);
                        break;
                    case ("Средняя"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_AVERAGE);
                        break;
                    case ("Мелкая"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                        break;
                    case ("Large"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_LARGE);
                        break;
                    case ("Average"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_AVERAGE);
                        break;
                    case ("Small"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                        break;
                }
            }
        });
    }
    void createLocal(String local) {
        Configuration config = new Configuration();
        config.locale = new Locale(local);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}