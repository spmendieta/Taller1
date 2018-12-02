package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class t3p3 extends Fragment {

    Button btn;
    EditText txt;

    public t3p3() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t3p3, container, false);
        txt = vista.findViewById(R.id.txtCifras);
        btn = vista.findViewById(R.id.btnCifras);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Short.parseShort(txt.getText().toString()) > 0 && Short.parseShort(txt.getText().toString()) < 10 ){
                    Toast.makeText(getContext(), "Su número sólo tiene una cifra.", Toast.LENGTH_LONG).show();
                }else if(Short.parseShort(txt.getText().toString()) < 100){
                    Toast.makeText(getContext(), "Su número tiene dos cifras.", Toast.LENGTH_LONG).show();
                }else if (Short.parseShort(txt.getText().toString()) < 1000){
                    Toast.makeText(getContext(), "Su número tiene tres cifras.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "Su número tiene más de tres cifras.", Toast.LENGTH_LONG).show();
                }
            }
        });
        return vista;
    }

}
