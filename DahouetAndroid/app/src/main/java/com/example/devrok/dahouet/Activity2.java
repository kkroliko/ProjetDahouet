package com.example.devrok.dahouet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import models.Regate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.RegateService;

import static com.example.devrok.dahouet.R.id.listRegate;

public class Activity2 extends AppCompatActivity {


    private String BASE_URL = "http://10.0.2.2:8000/";
    private List<Regate> regates = new ArrayList<>();
    private ListView regateListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        int id_challenge = intent.getIntExtra("challenge_id", 0);
        System.out.println(id_challenge);

        regateListView = (ListView) findViewById(listRegate);

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        RegateService RegateService = retrofit.create(RegateService.class);
        Call<List<Regate>> callRegate = RegateService.findByChallenge(id_challenge);

        callRegate.enqueue(new Callback<List<Regate>>() {
            @Override
            public void onResponse(Call<List<Regate>> call, Response<List<Regate>> response) {
                regates = response.body();
                regateListView.setAdapter(new ArrayAdapter<Regate>(Activity2.this, android.R.layout.simple_list_item_1, regates));
                regateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Regate regates = (Regate) regateListView.getItemAtPosition(position);
                        int id_regate = regates.getRegate_id();
                        System.out.println(id_regate);
                        Intent intent = new Intent(Activity2.this, Activity3.class);
                        intent.putExtra("regate_id", id_regate);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Regate>> call, Throwable t) {
                System.out.println("ERRRRRRRRRRRRRRRRRRRRRRREUR");
            }
        });

    }
}
