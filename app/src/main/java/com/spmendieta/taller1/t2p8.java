package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p8 extends Fragment {

    TextView txt;
    Button btn;
    EditText nombElefante, pesoElefante, longElefante;

    public t2p8() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p8, container, false);
        txt = vista.findViewById(R.id.txtConversionElefante);
        btn = vista.findViewById(R.id.btnConvertirCalculo);
        nombElefante = vista.findViewById(R.id.txtElefanteNombre);
        pesoElefante = vista.findViewById(R.id.txtElefantePeso);
        longElefante = vista.findViewById(R.id.txtElefanteLongitud);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("El nombre del elefante es: " + nombElefante.getText().toString() +
                        "\n" + "El peso en Kilos: " + String.valueOf(Integer.parseInt(pesoElefante.getText().toString()) * 0.4535) +
                        "\n" + "La longitud en Metros: " + String.valueOf(Integer.parseInt(longElefante.getText().toString()) * 0.3048));
            }
        });
        return vista;
    }

}
