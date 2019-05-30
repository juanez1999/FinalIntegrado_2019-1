package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.FragmentoInsignias;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.FragmentoProgreso;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.SectionPageAdapter;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.BottomNavigationViewHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Perfil extends AppCompatActivity {

    private SectionPageAdapter adapter;
    private ImageView fotoPerfil;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        fotoPerfil = findViewById(R.id.img_foto_perfil);
        fotoPerfil.bringToFront();

        setupNav();

        adapter = new SectionPageAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.container);
        viewPager.setVerticalScrollBarEnabled(true);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupNav() {
        BottomNavigationViewEx nav;
        nav = findViewById(R.id.nav_home);
        nav.setSelectedItemId(R.id.menu_perfil);
        BottomNavigationViewHelper.setupBottomNavigationView(nav);
        BottomNavigationViewHelper.enableNavigation(Perfil.this, nav);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.clear();
        viewPager.removeAllViews();
        adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentoProgreso(), "Progreso");
        adapter.addFragment(new FragmentoInsignias(), "Insignias");
        viewPager.setAdapter(adapter);

    }
}
