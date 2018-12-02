package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p6 extends Fragment {
    Button btn;
    TextView txt;
    EditText nombre, edad;

    public t2p6() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p6, container, false);
        nombre = vista.findViewById(R.id.txtNombreT2);
        edad = vista.findViewById(R.id.txtEdadT2);
        txt = vista.findViewById(R.id.txtNombreyEdad);
        btn = vista.findViewById(R.id.btnEdadNombreT2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Nombre: " + nombre.getText().toString() + "\n" + "Edad: " + edad.getText().toString());
            }
        });
        return vista;
    }

}
