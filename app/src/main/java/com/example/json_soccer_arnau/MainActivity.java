package com.example.json_soccer_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerClass;
    private ArrayList<Country> mCountry;
    private CountryAdapter countryAdapter;

    private static String JSON_COUNTRIES = "https://www.thesportsdb.com/api/v1/json/2/all_countries.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hook();

        initList();

        countryAdapter = new CountryAdapter(this, mCountry);
        spinnerClass.setAdapter(countryAdapter);
        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Country selectedItem = (Country) parent.getItemAtPosition(position);
                String selectedCountryName = selectedItem.getNameCountry();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Any country selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hook(){
        spinnerClass = findViewById(R.id.spinnerClass);
    }

    private void initList() {
        mCountry = new ArrayList<>();
        mCountry.add(new Country(getString(R.string.spain), R.drawable.spain));
        mCountry.add(new Country(getString(R.string.argentina), R.drawable.argentina));
        mCountry.add(new Country(getString(R.string.australia), R.drawable.australia));
        mCountry.add(new Country(getString(R.string.canada), R.drawable.canada));
        mCountry.add(new Country(getString(R.string.congo), R.drawable.congo));
    }
}