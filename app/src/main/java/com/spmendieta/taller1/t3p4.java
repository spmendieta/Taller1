package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class t3p4 extends Fragment {

    EditText num2, num1;
    Button btn;

    public t3p4() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t3p4, container, false);
        num1 = vista.findViewById(R.id.txtNumt3p4);
        num2 = vista.findViewById(R.id.txtNum2t3p4);
        btn = vista.findViewById(R.id.btnEqualNum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(num1.getText().toString()) == Integer.parseInt(num2.getText().toString())){
                    Toast.makeText(getContext(),"Los números son iguales.", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(),"Los números no son iguales.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return vista;
    }

}
