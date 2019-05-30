package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.ModalConfirmarVolver;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.Comunicacion;

public class EjemplosConstancias extends AppCompatActivity implements ModalConfirmarVolver.BottomSheetListener {

    private Comunicacion ref;
    private ImageButton volver;

    private ImageButton forma;
    private ImageButton tamano;
    private ImageButton color;
    private ImageButton practica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplos_constancias);

        ref = Comunicacion.getRef();

        volver = findViewById(R.id.btn_volver_ejemplosConstancias);

        forma = findViewById(R.id.btn_forma_ejemplosConstancias);
        tamano = findViewById(R.id.btn_tamano_ejemplosConstancias);
        color = findViewById(R.id.btn_color_ejemplosConstancias);
        practica = findViewById(R.id.btn_practicar_ejemplosConstancias);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModalConfirmarVolver modal = new ModalConfirmarVolver();
                modal.show(getSupportFragmentManager(), "Modal");
            }
        });

        forma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "EjemploForma";
                ref.enviar(msg);
            }
        });

        tamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "EjemploTamano";
                ref.enviar(msg);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "EjemploColor";
                ref.enviar(msg);
            }
        });

        practica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.enviar("Continuar");
                Intent i = new Intent(EjemplosConstancias.this, PracticaConstancias.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void OnButtonClicked(String boton) {
        if(boton.matches("Confirmar")) {

            Intent i = new Intent(EjemplosConstancias.this, AprendePercepcion.class);
            startActivity(i);
        }
    }
}
