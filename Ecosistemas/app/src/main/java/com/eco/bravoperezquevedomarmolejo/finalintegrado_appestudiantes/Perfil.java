package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.content.Intent;
import android.service.autofill.Dataset;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Perfil extends AppCompatActivity {

    private ImageButton home;
    private ProgressBar barra;
    private String codigoEstudiante;
    private int progreso;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Intent i = getIntent();
        codigoEstudiante = i.getStringExtra("Codigo");

        db = FirebaseDatabase.getInstance();

        db.getReference().child("Pruebas").child("Visual").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        barra = findViewById(R.id.pb_visual_perfil);

        barra.setProgress(progreso);

        home=findViewById(R.id.btn_home_perfil);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Perfil.this, Home.class);
                startActivity(i);
            }
        });

    }
}
