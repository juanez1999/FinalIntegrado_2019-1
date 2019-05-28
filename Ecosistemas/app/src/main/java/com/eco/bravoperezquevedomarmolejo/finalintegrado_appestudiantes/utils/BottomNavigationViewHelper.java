package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Home;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Perfil;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bnv) {
        bnv.enableAnimation(false);
        bnv.enableItemShiftingMode(false);
        bnv.enableShiftingMode(false);
        bnv.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_notificacion:

                        break;

                    case R.id.menu_home:
                        Intent i1 = new Intent(context, Home.class);
                        context.startActivity(i1);
                        break;

                    case R.id.menu_perfil:
                        Intent i2 = new Intent(context, Perfil.class);
                        context.startActivity(i2);
                        break;
                }
                return false;
            }
        });

    }
}
