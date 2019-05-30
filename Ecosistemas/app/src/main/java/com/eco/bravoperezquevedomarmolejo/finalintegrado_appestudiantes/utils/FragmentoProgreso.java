package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Home;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Perfil;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;

public class FragmentoProgreso extends Fragment {

    private String codigo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progreso, container, false);

        codigo = Home.codigoEstudiante;

        return view;
    }
}
