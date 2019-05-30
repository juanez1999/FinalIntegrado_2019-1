package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ActividadesPercepcion extends AppCompatActivity {

    private ImageButton volver;
    private ImageButton imgAprende;
    private ImageButton imgPractica;
    private ImageButton imgExperimenta;
    private TextView textAprende;
    private TextView textPractica;
    private TextView textExperimenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_percepcion);

        volver = findViewById(R.id.btn_volver_percepcion);
        imgAprende = findViewById(R.id.img_aprende_percepcion);
        imgPractica = findViewById(R.id.img_practica_percepcion);
        imgExperimenta = findViewById(R.id.img_experimenta_percepcion);
        textAprende = findViewById(R.id.tv_aprender_percepcion);
        textPractica = findViewById(R.id.tv_practicar_percepcion);
        textExperimenta = findViewById(R.id.tv_experimenta_percepcion);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActividadesPercepcion.this, Home.class);
                startActivity(i);
            }
        });

        View.OnClickListener listenerAprende = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActividadesPercepcion.this, AprendePercepcion.class);
                startActivity(i);
            }
        };

        imgAprende.setOnClickListener(listenerAprende);
        textAprende.setOnClickListener(listenerAprende);

        View.OnClickListener listenerPractica = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        imgPractica.setOnClickListener(listenerPractica);
        textPractica.setOnClickListener(listenerPractica);

        View.OnClickListener listenerExperimenta = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        imgExperimenta.setOnClickListener(listenerExperimenta);
        textExperimenta.setOnClickListener(listenerExperimenta);
    }

}
