package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class ModalConfirmarVolver extends BottomSheetDialogFragment {

    private BottomSheetListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.modal_volver, container, false);

        ImageButton si = v.findViewById(R.id.btn_confirmar_modal);
        ImageButton no = v.findViewById(R.id.btn_rechazar_modal);

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnButtonClicked("Confirmar");
                dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnButtonClicked("Rechazar");
                dismiss();
            }
        });
        return v;
    }

    public interface BottomSheetListener {
        void OnButtonClicked(String boton);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
