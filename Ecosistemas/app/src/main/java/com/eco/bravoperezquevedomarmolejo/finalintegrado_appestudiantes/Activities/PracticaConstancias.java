package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.ModalConfirmarVolver;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.Comunicacion;

public class PracticaConstancias extends AppCompatActivity implements ModalConfirmarVolver.BottomSheetListener {

    private Comunicacion ref;

    private ImageButton volver;
    private ImageButton forma;
    private ImageButton tamano;
    private ImageButton color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_constancias);

        ref = Comunicacion.getRef();

        volver = findViewById(R.id.btn_volver_practicarConstancias);

        forma = findViewById(R.id.btn_forma_practicarConstancias);
        tamano = findViewById(R.id.btn_tamano_practicar_Constancias);
        color = findViewById(R.id.btn_color_practicarConstancias);

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
                String msg = "Forma";
                ref.enviar(msg);
            }
        });

        tamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Tamano";
                ref.enviar(msg);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Color";
                ref.enviar(msg);
            }
        });

    }

    @Override
    public void OnButtonClicked(String boton) {
        if(boton.matches("Confirmar")) {
            Intent i = new Intent(PracticaConstancias.this, AprendePercepcion.class);
            startActivity(i);
        }
    }
}
