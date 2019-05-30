package com.eco.bravoperezquevedomarmolejo.astromind_profesor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

                ref.child("Profesores").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot child : dataSnapshot.getChildren()) {
                            Usuario usuario = child.getValue(Usuario.class);
                            if(correo.getText().toString().trim().matches(usuario.getCorreo())) {
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
                        db.getReference().child("Profesores").child(correo.getText().toString().trim()).setValue(user);
                        ProgresoUsuario progreso = new ProgresoUsuario("0", "0", "0");
                        db.getReference().child("Progresos").child("PercepcionVisual").child(correo.getText().toString().trim()).setValue(progreso);
                        db.getReference().child("Progresos").child("Memoria").child(correo.getText().toString().trim()).setValue(progreso);
                        Intent i = new Intent(Registro.this, Home.class);
                        i.putExtra("Correo", user.getCorreo());
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(Registro.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }

                if(registrado[0]) {
                    Toast.makeText(Registro.this, "Correo ya registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
