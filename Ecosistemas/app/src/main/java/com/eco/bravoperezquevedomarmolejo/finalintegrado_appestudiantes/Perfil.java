package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Perfil extends AppCompatActivity {

    private ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        home=findViewById(R.id.btn_home_perfil);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Perfil.this, Home.class);
                startActivity(i);
            }
        });

    }
}
