package com.example.hepatitismapping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hepatitismapping.api.Api;
import com.example.hepatitismapping.api.PengenalanJsonApi;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PengenalanHepaActivity extends AppCompatActivity {
    private TextView textViewResult;
    private PengenalanJsonApi pengenalanJsonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_hepa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.108/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PengenalanJsonApi pengenalanJsonApi = retrofit.create(PengenalanJsonApi.class);
        Call<Api> call = pengenalanJsonApi.getInfoHepas();
        call.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Api infohepas = response.body();
                textViewResult.append(infohepas.getIsi_info());
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void buttonkembalipengenalan(View view) {
        Intent intent = new Intent(PengenalanHepaActivity.this, InfoHepaActivity.class);
        startActivity(intent);
    }

}
