package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class t3p2 extends Fragment {

    EditText edt;
    Button btn;

    public t3p2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t3p2, container, false);
        edt = vista.findViewById(R.id.numeroParOimpar);
        btn = vista.findViewById(R.id.btnImparPar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(edt.getText().toString())%2==0){
                    Toast.makeText(getContext(), "Su número es par.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "Su número es impar.", Toast.LENGTH_LONG).show();
                }
            }
        });
        return vista;
    }

}
