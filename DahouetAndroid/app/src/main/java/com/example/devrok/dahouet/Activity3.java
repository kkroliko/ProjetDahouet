package com.example.devrok.dahouet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import models.Resultat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ResultatService;

import static com.example.devrok.dahouet.R.id.listResultat;

public class Activity3 extends AppCompatActivity {

    private String BASE_URL = "http://10.0.2.2:8000/";
    private List<Resultat> resultats = new ArrayList<>();
    private ListView resultatListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        int id_regate = intent.getIntExtra("regate_id", 0);
        System.out.println(id_regate);

        resultatListView = (ListView) findViewById(listResultat);

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        ResultatService ResultatService = retrofit.create(ResultatService.class);
        Call<List<Resultat>> callResultat = ResultatService.findByResultat(id_regate);

        callResultat.enqueue(new Callback<List<Resultat>>() {
            @Override
            public void onResponse(Call<List<Resultat>> call, Response<List<Resultat>> response) {
                resultats= response.body();
                resultatListView.setAdapter(new ArrayAdapter<Resultat>(Activity3.this, android.R.layout.simple_list_item_1, resultats));
            }

            @Override
            public void onFailure(Call<List<Resultat>> call, Throwable t) {
                System.out.println("ERRRRRRRRRRRRRRRRRRRRRRREUR");
            }
        });

    }
}
