package com.example.hepatitismapping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void buttonInfo(View view) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }


    public void buttonPeta(View view) {
        Intent intent = new Intent(MainActivity.this, PetaActivity.class);
        startActivity(intent);
    }
    public void buttonInfoHepa(View view) {
        Intent intent = new Intent(MainActivity.this, InfoHepaActivity.class);
        startActivity(intent);
    }

    public void buttongrafikpacitan(View view) {
        Intent intent = new Intent(MainActivity.this, GrafikPacitanActivity.class);
        startActivity(intent);
    }
}