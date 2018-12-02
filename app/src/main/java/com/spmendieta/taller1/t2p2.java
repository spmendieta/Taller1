package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p2 extends Fragment {

    private TextView txtResultadoRadio;
    private EditText txtnum;
    private Button btnRadio;

    public t2p2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p2, container, false);
        txtResultadoRadio = vista.findViewById(R.id.txtRadio);
        txtnum = vista.findViewById(R.id.txtnumRadio);
        btnRadio = vista.findViewById(R.id.btnRadio);

        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultadoRadio.setText("Resultado: "+String.valueOf(Float.parseFloat(txtnum.getText().toString()) * 2 * Math.PI));
            }
        });

        return vista;
    }

}
