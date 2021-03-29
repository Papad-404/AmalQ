package com.example.myamal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class Isi extends AppCompatActivity {
    CardView m1,m2;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.isi);

            m1 = findViewById(R.id.jumlah);
            m2 = findViewById(R.id.penuh);

            m1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),Hitung.class));
                    finish();
                }
            });

            m2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),Kapasitas.class));
                    finish();
                }
            });
        }


        @Override
        public void onBackPressed() {
            super.onBackPressed();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
}
