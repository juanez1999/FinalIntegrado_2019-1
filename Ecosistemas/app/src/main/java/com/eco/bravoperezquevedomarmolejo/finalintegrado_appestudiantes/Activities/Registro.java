package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.ProgresoUsuario;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

public class Registro extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference ref;
    private ImageButton registrar;
    private EditText codigo;
    private EditText correo;
    private EditText contra1;
    private EditText contra2;
    private TextView iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar=findViewById(R.id.btn_registro_registro);
        codigo=findViewById(R.id.edt_codigo_olvidar);
        correo=findViewById(R.id.edt_contra_olvidar);
        contra1=findViewById(R.id.edt_contra1_olvidar);
        contra2=findViewById(R.id.edt_contra2_registro);
        db= FirebaseDatabase.getInstance();
        ref= db.getReference();

        iniciar = findViewById(R.id.tv_iniciar_registro);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, InicioSesion.class);
                startActivity(i);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final boolean[] registrado = {false};

                ref.child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot child : dataSnapshot.getChildren()) {
                            Usuario usuario = child.getValue(Usuario.class);
                            if(codigo.getText().toString().trim().matches(usuario.getCodigo())) {
                                registrado[0] = true;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(contra1.getText().toString().trim().equals(contra2.getText().toString().trim())){

                    if(!registrado[0]) {
                        Usuario user = new Usuario(codigo.getText().toString().trim(), correo.getText().toString().trim(), contra1.getText().toString().trim());
                        db.getReference().child("Usuarios").child(codigo.getText().toString().trim()).setValue(user);
                        ProgresoUsuario progreso = new ProgresoUsuario("0", "0", "0");
                        db.getReference().child("Progresos").child("PercepcionVisual").child(codigo.getText().toString().trim()).setValue(progreso);
                        db.getReference().child("Progresos").child("Memoria").child(codigo.getText().toString().trim()).setValue(progreso);
                        Intent i = new Intent(Registro.this, Home.class);
                        i.putExtra("Codigo", user.getCodigo());
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(Registro.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }

                if(registrado[0]) {
                    Toast.makeText(Registro.this, "Código ya registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
