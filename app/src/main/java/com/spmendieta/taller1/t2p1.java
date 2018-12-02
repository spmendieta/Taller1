package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p1 extends Fragment {

    private TextView txtResultadoCuadrado;
    private EditText txtnum;
    private Button btnCuadrado;

    public t2p1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_t2p1, container, false);
        txtResultadoCuadrado = vista.findViewById(R.id.txtresultadocuadrado);
        txtnum = vista.findViewById(R.id.txtnumCuadrado);
        btnCuadrado = vista.findViewById(R.id.btnCuadrado);

        btnCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultadoCuadrado.setText(String.valueOf(Math.pow(Integer.parseInt(txtnum.getText().toString()), 2)));
            }
        });
        return vista;
    }

}
