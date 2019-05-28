package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.BottomNavigationViewHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

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

        setupNav();

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

    }

    private void setupNav() {
        BottomNavigationViewEx nav;
        nav = findViewById(R.id.nav_home);
        nav.setSelectedItemId(R.id.menu_perfil);
        BottomNavigationViewHelper.setupBottomNavigationView(nav);
        BottomNavigationViewHelper.enableNavigation(Perfil.this, nav, codigoEstudiante);
    }
}
