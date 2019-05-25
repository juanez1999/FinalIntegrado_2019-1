package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class Registro extends AppCompatActivity {

    private ImageButton registrar;
    private EditText codigo;
    private EditText correo;
    private EditText contra1;
    private EditText contra2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar=findViewById(R.id.btn_registro_registro);
        codigo=findViewById(R.id.edt_codigo_registro);
        correo=findViewById(R.id.edt_correo_registro);
        contra1=findViewById(R.id.edt_contra1_registro);
        contra2=findViewById(R.id.edt_contra2_registro);


    }

}
