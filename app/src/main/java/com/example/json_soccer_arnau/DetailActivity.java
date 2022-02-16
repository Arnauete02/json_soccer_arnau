package com.example.json_soccer_arnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ArrayList<League> leagues = new ArrayList<>();
    private RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.recyclerView);

        getLeagues();
    }

    private void getLeagues(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                getUrl(),
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
                                    league.setStrBadge(leagueObject.getString("strBadge"));
                                    league.setStrLeague(leagueObject.getString("strLeague"));
                                    league.setStrDescriptionEN(leagueObject.getString("strDescriptionEN"));
                                    league.setStrWebsite(leagueObject.getString("strWebsite"));
                                    league.setStrFanart1(leagueObject.getString("strFanart1"));
                                    league.setStrFanart1(leagueObject.getString("strFanart2"));
                                    league.setStrFanart1(leagueObject.getString("strFanart3"));
                                    league.setStrFanart1(leagueObject.getString("strFanart4"));
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

    private String getUrl(){
        Intent intent = getIntent();
        String country = intent.getStringExtra(MainActivity.EXTRA_JSON_URL);
        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=" + country + "&s=Soccer";
        return url;
    }
}