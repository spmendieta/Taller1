package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p7 extends Fragment {

    TextView txtFinal;
    Button btn;
    EditText cantHoras, valorHora;


    public t2p7() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p7, container, false);
        cantHoras = vista.findViewById(R.id.txtCantHoras);
        valorHora = vista.findViewById(R.id.txtValorHora);
        btn = vista.findViewById(R.id.btnEjercicioHoras);
        txtFinal = vista.findViewById(R.id.txtSalarioFinal);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFinal.setText("El salario neto es: $" + String.valueOf(Integer.parseInt(cantHoras.getText().toString()) * Integer.parseInt(valorHora.getText().toString())) + " pesos.");
            }
        });
        return vista;
    }

}
