package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InicioSesion extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText codigo;
    private EditText contrasena;
    private ImageButton login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
                db = FirebaseDatabase.getInstance();

        db.getReference().child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(Usuario.class) != null) {
                    Usuario user = dataSnapshot.getValue(Usuario.class);
                    String val = user.getCodigo();
                    Log.e("Alfa", "Llega hasta aquí");

                    if(user == null) {
                        Log.e("Alfa", "NO HAY USER");
                    }

                    Log.e("Alfa", val);
                } else {
                    Log.e("Alfa", "Está null");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        codigo = findViewById(R.id.edt_codigo_inicio);
        contrasena = findViewById(R.id.edt_contrasena_inicio);

        login = findViewById(R.id.btn_incio_inicio);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
