package com.spmendieta.taller1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Punto1Fragment extends Fragment {

    private Button btn;
    private TextView label;
    private EditText txtNum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_punto1, container, false);
        btn = vista.findViewById(R.id.btnEvaluar);
        label = vista.findViewById(R.id.lblResultado);
        txtNum = vista.findViewById(R.id.txtnum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNum.getText().toString().equals("")){

                    if (Integer.parseInt(txtNum.getText().toString()) == 0){
                        label.setText("Su número es cero.");
                    }else if(Integer.parseInt(txtNum.getText().toString()) > 0){
                        label.setText("Su número es positivo.");
                    }else{
                        label.setText("Su número es negativo.");
                    }
                }else{
                    Toast.makeText(getContext(), "No puede dejar el campo vacio.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return vista;

    }
}