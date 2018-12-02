package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p3 extends Fragment {


    private TextView txtFinal;
    private Button btnCalcularArea;
    private EditText base, altura;

    public t2p3() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p3, container, false);
        base = vista.findViewById(R.id.txtBaseTriangulo);
        altura = vista.findViewById(R.id.txtAlturaTriangulo);
        txtFinal = vista.findViewById(R.id.txtResultadoTriangulo);
        btnCalcularArea = vista.findViewById(R.id.btnTriangulo);

        btnCalcularArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFinal.setText("Área: " + String.valueOf((Double.parseDouble(base.getText().toString()) *
                        Double.parseDouble(altura.getText().toString())) / 2));
            }
        });

        return vista;
    }

}
