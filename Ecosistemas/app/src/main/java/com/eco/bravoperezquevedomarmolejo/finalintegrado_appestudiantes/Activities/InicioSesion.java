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
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InicioSesion extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText codigo;
    private EditText contrasena;
    private TextView olvidar;
    private TextView registrar;
    private ImageButton login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
                db = FirebaseDatabase.getInstance();

        codigo = findViewById(R.id.edt_codigo_inicio);
        contrasena = findViewById(R.id.edt_contrasena_inicio);
        registrar = findViewById(R.id.tv_registrate_inicio);

        login = findViewById(R.id.btn_incio_inicio);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InicioSesion.this, Registro.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String cod = codigo.getText().toString();
                final String contra = contrasena.getText().toString();

                if(cod.length() == 9) {
                    db.getReference().child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            boolean codigoValido = false;
                            boolean contraCorrecta = false;

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Usuario user = ds.getValue(Usuario.class);
                                if(cod.matches(user.getCodigo())) {
                                    codigoValido = true;
                                }

                                if(codigoValido && contra.matches(user.getContra1())) {
                                    contraCorrecta = true;
                                }

                                if(!codigoValido) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(InicioSesion.this, "Código no registrado", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    if(contraCorrecta) {
                                        Intent i = new Intent(InicioSesion.this, Home.class);
                                        i.putExtra("Codigo", user.getCodigo());
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(InicioSesion.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InicioSesion.this, "Código incorrecto. Intenta cambiarlo.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}
