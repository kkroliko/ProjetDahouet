package com.example.devrok.dahouet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import models.Challenge;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ChallengeService;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "http://10.0.2.2:8000/";
    private List<Challenge> challenges = new ArrayList<>();
    private Spinner spinnerChallenge = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerChallenge = (Spinner) findViewById(R.id.listChallenge);

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        ChallengeService challengeService = retrofit.create(ChallengeService.class);
        Call<List<Challenge>> callChallenge = challengeService.findAll();

        callChallenge.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {
                challenges = response.body();
                spinnerChallenge.setAdapter(new ArrayAdapter<Challenge>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, challenges));
                spinnerChallenge.setSelected(false);
                Button button = (Button) findViewById(R.id.ConfirmButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Challenge challenge = (Challenge) spinnerChallenge.getSelectedItem();
                        int id_Challenge = challenge.getChallenge_id();
                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        intent.putExtra("challenge_id", id_Challenge);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
               t.printStackTrace();
            }
        });

    }




}
