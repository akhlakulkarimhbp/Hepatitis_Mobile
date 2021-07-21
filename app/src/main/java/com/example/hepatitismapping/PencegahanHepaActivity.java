package com.example.hepatitismapping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.hepatitismapping.api.Api;
import com.example.hepatitismapping.api.PencegahanJsonApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PencegahanHepaActivity extends AppCompatActivity{
    private TextView textViewResult3;
    private PencegahanJsonApi pencegahanJsonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencegahan_hepa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        textViewResult3 = findViewById(R.id.text_view_result3);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.108/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PencegahanJsonApi pencegahanJsonApi = retrofit.create(PencegahanJsonApi.class);
        Call<Api> call = pencegahanJsonApi.getInfoHepas();
        call.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                if (!response.isSuccessful()) {
                    textViewResult3.setText("Code: " + response.code());
                    return;
                }
                Api infohepas = response.body();
                textViewResult3.append(infohepas.getIsi_info());
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                textViewResult3.setText(t.getMessage());
            }
        });
}

    public void buttonkembalipencegahan(View view) {
        Intent intent = new Intent(PencegahanHepaActivity.this, InfoHepaActivity.class);
        startActivity(intent);
    }
    }
