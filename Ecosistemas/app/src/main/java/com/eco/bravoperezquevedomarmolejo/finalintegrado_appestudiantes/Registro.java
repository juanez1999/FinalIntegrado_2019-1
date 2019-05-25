package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference ref;
    private ImageButton registrar;
    private EditText codigo;
    private EditText correo;
    private EditText contra1;
    private EditText contra2;
    private String codigos;
    private String correos;
    private String contras1;
    private String contras2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar=findViewById(R.id.btn_registro_registro);
        codigo=findViewById(R.id.edt_codigo_registro);
        correo=findViewById(R.id.edt_correo_registro);
        contra1=findViewById(R.id.edt_contra1_registro);
        contra2=findViewById(R.id.edt_contra2_registro);
        db= FirebaseDatabase.getInstance();
        ref= db.getReference();

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codigos= codigo.getText().toString().trim();
                correos= correo.getText().toString().trim();
                contras1= contra1.getText().toString().trim();
                contras2= contra2.getText().toString().trim();
                if(contras1.equals(contras2)){
                    crearUsuario();
                    Intent i = new Intent(Registro.this, Home.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Registro.this,"Error confirmacion contraseña",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void crearUsuario(){
        Usuario user= new Usuario(codigos,correos,contras1);
        ref.child("Usuarios").child(codigos).setValue(user);
    }

}
