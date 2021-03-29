package com.example.myamal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Hitung extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitung);


    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Isi.class));
        finish();
        super.onBackPressed();
    }
}
