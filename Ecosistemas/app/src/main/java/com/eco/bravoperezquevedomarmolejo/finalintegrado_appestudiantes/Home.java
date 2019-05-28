package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    private ImageButton comenzar;
    private ImageButton perfil;
    private ImageButton notificaciones;
    private String codigoEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        codigoEstudiante = i.getStringExtra("Codigo");

        comenzar=findViewById(R.id.btn_comenzar_home);
        perfil=findViewById(R.id.btn_perfil_home);
        notificaciones=findViewById(R.id.btn_notificacion_home);



        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Perfil.class);
                i.putExtra("Codigo", codigoEstudiante);
                startActivity(i);
            }
        });

    }
}
