package com.example.hepatitismapping;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hepatitismapping.api.Api;
import com.example.hepatitismapping.api.GejalaJsonApi;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GejalaHepaActivity extends AppCompatActivity {
    private TextView textViewResult2;
    private GejalaJsonApi gejalaJsonApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejala_hepa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        textViewResult2 = findViewById(R.id.text_view_result2);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.108/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GejalaJsonApi gejalaJsonApi = retrofit.create(GejalaJsonApi.class);
        Call<Api> call = gejalaJsonApi.getInfoHepas();
        call.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                if (!response.isSuccessful()) {
                    textViewResult2.setText("Code: " + response.code());
                    return;
                }
                Api infohepas = response.body();
                textViewResult2.append(infohepas.getIsi_info());
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                textViewResult2.setText(t.getMessage());
            }
        });
    }

    public void buttonkembaligejalan(View view) {
        Intent intent = new Intent(GejalaHepaActivity.this, InfoHepaActivity.class);
        startActivity(intent);
    }
}
