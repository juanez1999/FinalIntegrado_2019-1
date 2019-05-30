package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ActividadesPercepcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_percepcion);

        setupNav();
    }

    private void setupNav() {
        BottomNavigationViewEx nav;
        nav = findViewById(R.id.nav_actividadpercepcion);
        nav.setSelectedItemId(R.id.menu_perfil);
        BottomNavigationViewHelper.setupBottomNavigationView(nav);
        BottomNavigationViewHelper.enableNavigation(ActividadesPercepcion.this, nav);
    }
}
