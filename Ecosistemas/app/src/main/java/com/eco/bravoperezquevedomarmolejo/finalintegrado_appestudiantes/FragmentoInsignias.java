package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;

public class FragmentoInsignias extends Fragment {

    private String codigo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insignias, container, false);

        return view;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
