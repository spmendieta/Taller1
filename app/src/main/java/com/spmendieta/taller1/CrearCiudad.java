package com.spmendieta.taller1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import HilosWS.HiloRegistrarCiudad;

public class CrearCiudad extends AppCompatActivity {

    Button btn;
    TextView txtNombre, txtCantidadHabitantes, txtLatitud, txtLongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ciudad);
        btn = findViewById(R.id.btnInsertarCiudad);
        txtNombre = findViewById(R.id.txtNombCiudad);
        txtCantidadHabitantes = findViewById(R.id.txtCantHabitantes);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HiloRegistrarCiudad(CrearCiudad.this, txtNombre.getText().toString(),
                        txtCantidadHabitantes.getText().toString(), txtLatitud.getText().toString(),
                        txtLongitud.getText().toString()).execute();

                finish();
            }
        });
    }
}
