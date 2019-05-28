package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Home extends AppCompatActivity {

    private String codigoEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        codigoEstudiante = i.getStringExtra("Codigo");

        setupNav();

    }

    private void setupNav() {
        BottomNavigationViewEx nav;
        nav = findViewById(R.id.nav_home);
        nav.setSelectedItemId(R.id.menu_home);
        BottomNavigationViewHelper.setupBottomNavigationView(nav);
        BottomNavigationViewHelper.enableNavigation(Home.this, nav, codigoEstudiante);
    }
}
