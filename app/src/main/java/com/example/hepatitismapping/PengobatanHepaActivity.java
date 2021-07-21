package com.example.hepatitismapping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hepatitismapping.api.Api;
import com.example.hepatitismapping.api.PencegahanJsonApi;
import com.example.hepatitismapping.api.PengobatanJsonApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PengobatanHepaActivity extends AppCompatActivity {
    private TextView textViewResult4;
    private PengobatanJsonApi pengobatanJsonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengobatan_hepa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        textViewResult4 = findViewById(R.id.text_view_result4);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.108/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PengobatanJsonApi pengobatanJsonApi = retrofit.create(PengobatanJsonApi.class);
        Call<Api> call = pengobatanJsonApi.getInfoHepas();
        call.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                if (!response.isSuccessful()) {
                    textViewResult4.setText("Code: " + response.code());
                    return;
                }
                Api infohepas = response.body();
                textViewResult4.append(infohepas.getIsi_info());
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                textViewResult4.setText(t.getMessage());
            }
        });
}

    public void buttonkembalipengobatan(View view) {
        Intent intent = new Intent(PengobatanHepaActivity.this, InfoHepaActivity.class);
        startActivity(intent);
    }
    }
