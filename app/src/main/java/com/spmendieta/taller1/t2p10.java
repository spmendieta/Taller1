package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p10 extends Fragment {

    EditText txtCantHoras;
    TextView textoFinal;
    Button btn;

    public t2p10() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p10, container, false);
        txtCantHoras = vista.findViewById(R.id.txtCantidadHoras);
        textoFinal = vista.findViewById(R.id.txtCantDiasTotales);
        btn = vista.findViewById(R.id.btnHoras);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoFinal.setText("Cantidad de segundos: " + String.valueOf(Integer.parseInt(txtCantHoras.getText().toString()) * 3600) +
                        "\n" + "Cantidad de minutos: " + String.valueOf(Integer.parseInt(txtCantHoras.getText().toString()) * 60) +
                        "\n" + "Cantidad de días: " + String.valueOf(Integer.parseInt(txtCantHoras.getText().toString()) * 0.0417));
            }
        });
        return vista;
    }

}
