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
import android.widget.Toast;

public class Punto2Fragment extends Fragment {

    Button btn;
    TextView labelFinal;
    EditText campo1, campo2, campo3, campo4, campo5;
    int res1, res2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_punto2, container, false);

        labelFinal = vista.findViewById(R.id.lblResultado);
        campo1 = vista.findViewById(R.id.txtnum1);
        campo2 = vista.findViewById(R.id.txtnum2);
        campo3 = vista.findViewById(R.id.txtnum3);
        campo4 = vista.findViewById(R.id.txtnum4);
        campo5 = vista.findViewById(R.id.txtnum5);
        btn = vista.findViewById(R.id.btnEvaluar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(campo5.getText().toString()) > 0){

                    res1 = Integer.parseInt(campo1.getText().toString()) + Integer.parseInt(campo2.getText().toString())
                            - Integer.parseInt(campo3.getText().toString()) * Integer.parseInt(campo4.getText().toString())
                            / Integer.parseInt(campo5.getText().toString());

                    res2 = Integer.parseInt(campo5.getText().toString()) + Integer.parseInt(campo4.getText().toString())
                            - Integer.parseInt(campo3.getText().toString()) * Integer.parseInt(campo2.getText().toString())
                            / Integer.parseInt(campo1.getText().toString());

                    labelFinal.setText("Los resultados son: " + String.valueOf(res1) +" y "+ String.valueOf(res2));

                }else{
                    Toast.makeText(getContext(), "No se puede dividir por cero.", Toast.LENGTH_LONG).show();
                }


            }
        });
        return vista;
    }
}
