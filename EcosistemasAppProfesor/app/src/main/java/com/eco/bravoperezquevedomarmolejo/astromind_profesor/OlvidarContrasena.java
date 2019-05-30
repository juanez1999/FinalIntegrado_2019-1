package com.eco.bravoperezquevedomarmolejo.astromind_profesor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OlvidarContrasena extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText codigo;
    private EditText contra;
    private EditText contra1;

    private ImageButton confirmar;
    private ImageButton volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar_contrasena);

        db = FirebaseDatabase.getInstance();

        codigo = findViewById(R.id.edt_codigo_olvidar);
        contra = findViewById(R.id.edt_contra_olvidar);
        contra1 = findViewById(R.id.edt_contra1_olvidar);

        volver = findViewById(R.id.btn_back_olvidar);
        confirmar = findViewById(R.id.btn_confirmar_olvidar);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OlvidarContrasena.this, InicioSesion.class);
                startActivity(i);
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String contrasena = contra.getText().toString();
                String contrasena1 = contra1.getText().toString();

                db.getReference().child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot child : dataSnapshot.getChildren()) {
                            Usuario user = child.getValue(Usuario.class);
                            if(codigo.getText().toString().trim().matches(user.getCodigo())) {
                                db.getReference().child("Usuarios").child(codigo.getText().toString().trim()).child("contra1").setValue(contrasena);
                                Intent i = new Intent(OlvidarContrasena.this, InicioSesion.class);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
