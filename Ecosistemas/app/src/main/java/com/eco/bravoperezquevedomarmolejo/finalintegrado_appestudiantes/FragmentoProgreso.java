package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Home;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.Activities.Perfil;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.R;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.Codigo;
import com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils.ProgresoUsuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentoProgreso extends Fragment {

    private ProgressBar barra;
    private TextView porcentaje;
    private FirebaseDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progreso, container, false);

        db = FirebaseDatabase.getInstance();

        barra = view.findViewById(R.id.pb_visual_perfil);
        porcentaje = view.findViewById(R.id.tv_porcentajevisual_fragmento);

        db.getReference().child("Progresos").child("PercepcionVisual").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    ProgresoUsuario progreso = child.getValue(ProgresoUsuario.class);
                    if(progreso != null) {
                        if (progreso.getCodigo().matches(Codigo.getCodigo())) {
                            int prueba1 = Integer.parseInt(progreso.getPrueba1());
                            int prueba2 = Integer.parseInt(progreso.getPrueba2());
                            int prueba3 = Integer.parseInt(progreso.getPrueba3());

                            int total = (prueba1 + prueba2 + prueba3) / 3;

                            barra.setProgress(total);
                            String porcent = total + "%";
                            porcentaje.setText(porcent);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}
