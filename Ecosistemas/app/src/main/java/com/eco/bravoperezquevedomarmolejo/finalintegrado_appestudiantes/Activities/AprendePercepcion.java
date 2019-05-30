package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;

public class AprendePercepcion extends AppCompatActivity {

    private ImageButton volver;
    private ImageButton constanciaStart;
    private ImageButton leyesStart;
    private ImageButton indiciosStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_percepcion);

        volver = findViewById(R.id.btn_volver_aprendeP);
        constanciaStart = findViewById(R.id.btn_constancias_aprendeP);
        leyesStart = findViewById(R.id.btn_leyes_aprendeP);
        indiciosStart = findViewById(R.id.btn_indicios_aprendeP);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AprendePercepcion.this, ActividadesPercepcion.class);
                startActivity(i);
            }
        });

        constanciaStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AprendePercepcion.this, AprendeConstancias.class);
                startActivity(i);
            }
        });
    }
}
