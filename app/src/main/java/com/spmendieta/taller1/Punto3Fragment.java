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
import android.widget.Toast;

public class Punto3Fragment extends Fragment {

    private Button btn;
    private EditText nomb1, nomb2, asig1, asig2, n1e1, n2e1, n3e1, n1e2, n2e2, n3e2;
    private double promedio1, promedio2;

    public Punto3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_punto3, container, false);
        btn = vista.findViewById(R.id.btnEvaluar);
        nomb1 = vista.findViewById(R.id.txtnomb1);
        nomb2 = vista.findViewById(R.id.txtnomb2);
        asig1 = vista.findViewById(R.id.txtmateria1);
        asig2 = vista.findViewById(R.id.txtmateria2);
        n1e1 = vista.findViewById(R.id.txte1n1);
        n2e1 = vista.findViewById(R.id.txte1n2);
        n3e1 = vista.findViewById(R.id.txte1n3);
        n1e2 = vista.findViewById(R.id.txte2n1);
        n2e2 = vista.findViewById(R.id.txte2n2);
        n3e2 = vista.findViewById(R.id.txte2n3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promedio1 = Double.parseDouble((n1e1.getText().toString() + n2e1.getText().toString() + n3e1.getText().toString())) / 3;
                promedio2 = Double.parseDouble(n1e2.getText().toString() + n2e2.getText().toString() + n3e2.getText().toString()) / 3;

                Toast.makeText(getContext(), "Estudiante # 1: " + nomb1.getText().toString() + " Materia: "
                        + asig1.getText().toString() + " Promedio final: " + String.valueOf(promedio1), Toast.LENGTH_LONG).show();

                Toast.makeText(getContext(), "Estudiante # 2: " + nomb2.getText().toString() + " Materia: "
                        + asig2.getText().toString() + " Promedio final: " + String.valueOf(promedio2), Toast.LENGTH_LONG).show();

            }
        });

        return vista;
    }

}
