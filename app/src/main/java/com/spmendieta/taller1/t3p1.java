package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class t3p1 extends Fragment {

    EditText numEvaluar;
    Button btn;

    public t3p1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t3p1, container, false);
        numEvaluar = vista.findViewById(R.id.numT3p1);
        btn = vista.findViewById(R.id.btnNumPosNeg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(numEvaluar.getText().toString()) > 0) {
                    Toast.makeText(getContext(), "Su número es positivo.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Su número es negativo.", Toast.LENGTH_LONG).show();
                }
            }
        });

        return vista;

    }

}
