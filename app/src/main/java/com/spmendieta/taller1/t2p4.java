package com.spmendieta.taller1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t2p4 extends Fragment {

    private TextView txtFinal;
    private Button btnCalcular;
    private EditText base, altura;
    private Float perimetro, area;

    public t2p4() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_t2p4, container, false);
        base = vista.findViewById(R.id.txtBaseRectangulo);
        altura = vista.findViewById(R.id.txtAlturaRectangulo);
        txtFinal = vista.findViewById(R.id.txtResultadoRectangulo);
        btnCalcular = vista.findViewById(R.id.btnRectangulo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setArea(Float.parseFloat(base.getText().toString()) * Float.parseFloat(altura.getText().toString()));
                setPerimetro(2 * Float.parseFloat(base.getText().toString()) + 2 * Float.parseFloat(altura.getText().toString()));

                txtFinal.setText("El Área del rectángulo es:" + String.valueOf(getArea()) + "\n" +
                        "El Perimetro del rectángulo es:" + String.valueOf(getPerimetro()));
            }
        });

        return vista;
    }

    public Float getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Float perimetro) {
        this.perimetro = perimetro;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }
}
