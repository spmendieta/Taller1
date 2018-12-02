package com.spmendieta.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import HilosWS.HiloRegistrarEmpleado;

public class RegistroEmpleados extends AppCompatActivity {

    private String tipoDoc;
    private Button btnRegistrar;
    private RadioButton radioButtonCedula, radioButtonContra, radioButtonTI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleados);
        radioButtonCedula = findViewById(R.id.rbCedula);
        radioButtonContra = findViewById(R.id.rbContra);
        radioButtonTI = findViewById(R.id.rbTarjetaIdentidad);
        btnRegistrar = findViewById(R.id.btnRegistrarEmpleado);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonCedula.isChecked()){
                    tipoDoc = "Cedula";
                }else if (radioButtonContra.isChecked()){
                    tipoDoc = "Pasaporte";
                } else if (radioButtonTI.isChecked()){
                    tipoDoc = "Tarjeta de Identidad";
                }

                new HiloRegistrarEmpleado(RegistroEmpleados.this, tipoDoc).execute();

            }
        });
    }
}
