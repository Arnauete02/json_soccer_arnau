package com.example.json_soccer_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerClass;
    private ArrayList<Country> mCountry;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hook();

    }

    private void hook(){
        spinnerClass = findViewById(R.id.spinnerClass);
    }

    private void initList() {
        
    }
}