package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p9 extends Fragment {

    EditText x;
    TextView txtFinal;
    Button btn;

    public t2p9() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p9, container, false);
        x = vista.findViewById(R.id.valX);
        txtFinal = vista.findViewById(R.id.txtDespejarY);
        btn = vista.findViewById(R.id.btnY);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFinal.setText("El valor de 'Y' es: " +
                        String.valueOf((3 * Integer.parseInt(x.getText().toString()) * 2)
                                + (7 * Integer.parseInt(x.getText().toString()) ) - 15));
            }
        });
        return vista;
    }

}
