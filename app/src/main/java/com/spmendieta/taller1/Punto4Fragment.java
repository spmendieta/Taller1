package com.spmendieta.taller1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Punto4Fragment extends Fragment {

    private Button btnMul;
    private EditText num;
    private TextView labelResultado;
    private short factor = 0;
    private String cadena = "";

    public Punto4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_punto4, container, false);

        btnMul = vista.findViewById(R.id.btnMultiplicar);
        num = vista.findViewById(R.id.txtnumeroMul);
        labelResultado = vista.findViewById(R.id.lblMultiResultado);

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factor = Short.parseShort(num.getText().toString());

                for (int i = 1; i <= 10; i++){
                    cadena += i + " x " + factor + " = " + (i * factor) + "\n";
                }

                labelResultado.setText(cadena);
                cadena = "";
            }
        });

        return vista;
    }

}
