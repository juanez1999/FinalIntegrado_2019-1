package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    private ImageButton comenzar;
    private ImageButton perfil;
    private ImageButton notificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        comenzar=findViewById(R.id.btn_comenzar_home);
        perfil=findViewById(R.id.btn_perfil_home);
        notificaciones=findViewById(R.id.btn_notificacion_home);

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}