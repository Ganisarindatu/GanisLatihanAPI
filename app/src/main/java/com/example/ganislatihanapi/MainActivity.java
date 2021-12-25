package com.example.ganislatihanapi;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ganislatihanapi.model.DataSystem;
import com.example.ganislatihanapi.R;

import com.bumptech.glide.Glide;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
//Ganis Arindatu
public class MainActivity extends AppCompatActivity {

    ArrayList<DataSystem> datasystems= new ArrayList();
    JSONObject jsonObject;
    ListView listview;
    FloatingActionButton btnRefresh;
    ProgressBar loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingIndicator = findViewById(R.id.loading);
        getDataSystem();
    }

    void setupListviewSystem () {
        listview = findViewById(R.id.list);
        AdapterSystem adapter = new AdapterSystem(this, datasystems);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onItemClick);
    }

    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DataSystem system = datasystems.get(position);
            Intent intent = new Intent(MainActivity.this, DetailSystem.class);
            intent.putExtra("System", system);
            startActivity(intent);
        }
    };
    final String url = "https://ewinsutriandi.github.io/mockapi/operating_system.json";
    void getDataSystem() {
        datasystems.clear();
        loadingIndicator.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        jsonObject = response;
                        refreshView();
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Not Found", error.toString());
                        loadingIndicator.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Hubungkan prangkat anda dengan internet", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
        setupListviewSystem();
    }

    void refreshView() {
        Iterator<String> key = jsonObject.keys();
        while(key.hasNext()) {
            String nameSystem = key.next();
            try {
                JSONObject data = jsonObject.getJSONObject(nameSystem);
                String description = data.getString("description");
                String logo = data.getString("logo");
                String versi = data.getString("latest_version");
                String developer = data.getString("developer");
                String website = data.getString("website");
                String smodel = data.getString("source_model");
                datasystems.add(new DataSystem(nameSystem,versi,developer,website,smodel, description, logo));
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        loadingIndicator.setVisibility(View.GONE);
        setupListviewSystem();
    }

}