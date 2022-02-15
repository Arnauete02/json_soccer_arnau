package com.example.json_soccer_arnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DetailActivity extends AppCompatActivity {

    ArrayList<League> leagues = new ArrayList<>();
    private RecyclerView recyclerView;

    private String getIntent;
    private static String JSON_URL = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=";
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getIntent = getIntent().getStringExtra("countryName");
        JSON_URL = JSON_URL + getIntent + "&s=Soccer";

        recyclerView = findViewById(R.id.recyclerView);

        getLeagues();
    }

    private void getLeagues(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                JSON_URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray leagueArray = response.getJSONArray("countrys");
                            for (int i = 0; i < response.length(); i++){
                                try {
                                    JSONObject leagueObject = leagueArray.getJSONObject(i);
                                    League league = new League();
                                    league.setFlag(leagueObject.getString("strBadge"));
                                    league.setTextTitle(leagueObject.getString("strLeague"));
                                    league.setTextDescription(leagueObject.getString("strDescriptionEN"));
                                    leagues.add(league);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                        myAdapter = new MyAdapter(getApplicationContext(), leagues);
                        recyclerView.setAdapter(myAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: "+ error.getMessage());
                    }
                }
        );
        queue.add(jsonObjectRequest);
    }
}