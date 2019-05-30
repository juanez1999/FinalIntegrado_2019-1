package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.ModalConfirmarVolver;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.ProgresoUsuario;

public class AprendeConstancias extends AppCompatActivity implements ModalConfirmarVolver.BottomSheetListener {

    private ImageButton volver;
    private ImageButton continuar;
    private ProgresoUsuario progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_constancias);

        volver = findViewById(R.id.btn_volver_constanciasA);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModalConfirmarVolver modal = new ModalConfirmarVolver();
                modal.show(getSupportFragmentManager(), "Modal");
            }
        });

        continuar = findViewById(R.id.btn_continuar_constanciasAprender);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AprendeConstancias.this, EjemplosConstancias.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void OnButtonClicked(String boton) {
        if(boton.matches("Confirmar")) {
            Intent i = new Intent(AprendeConstancias.this, AprendePercepcion.class);
            startActivity(i);
        }
    }
}
