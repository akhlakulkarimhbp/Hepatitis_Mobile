package com.example.hepatitismapping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InfoHepaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infohepa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void buttonkembaliinformasi(View view) {
        Intent intent = new Intent(InfoHepaActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void buttonPengenalanHepa(View view) {
        Intent intent = new Intent(InfoHepaActivity.this, PengenalanHepaActivity.class);
        startActivity(intent);
    }

    public void buttonGejalaHepa(View view) {
        Intent intent = new Intent(InfoHepaActivity.this, GejalaHepaActivity.class);
        startActivity(intent);
    }

    public void buttonPencegahanHepa(View view) {
        Intent intent = new Intent(InfoHepaActivity.this, PencegahanHepaActivity.class);
        startActivity(intent);
    }

    public void buttonPengobatanHepa(View view) {
        Intent intent = new Intent(InfoHepaActivity.this, PengobatanHepaActivity.class);
        startActivity(intent);
    }
}
