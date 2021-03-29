package com.example.myamal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Kapasitas extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private TextView kapasitas, ket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kapasitas);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Float");
        ket = findViewById(R.id.keterangan);
        kapasitas = findViewById(R.id.penuh);

        getData();
    }

    private void getData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String jarak = snapshot.child("Distance").getValue().toString();

                int i = Integer.parseInt(jarak);
                int a = 12;
                int total = a - i;
                if (i  <= 3) {
                    ket.setText("Full Alert");
                    kapasitas.setText("\n" + total + "/" + a);
                } else {
                    ket.setText("Remaining...");
                    kapasitas.setText("\n" + total + "/" + a);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Kapasitas.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Isi.class));
        finish();
        super.onBackPressed();
    }
}
