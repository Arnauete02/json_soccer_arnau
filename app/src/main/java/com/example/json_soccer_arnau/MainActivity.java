package com.example.json_soccer_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

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

        //initList();

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Country selectedItem = (Country) parent.getItemAtPosition(position);
                String selectedCountry = selectedItem.getNameCountry();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void hook(){
        spinnerClass = findViewById(R.id.spinnerClass);
    }

    private void initList() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                JSON_COUNTRIES,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject countryOject = response.getJSONObject(i);
                                Country country = new Country();
                                country.setNameCountry(countryOject.getString("name_en"));
                                mCountry.add(country);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        countryAdapter = new CountryAdapter(getApplicationContext(), mCountry);
                        spinnerClass.setAdapter(countryAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        queue.add(jsonArrayRequest);
    }
}