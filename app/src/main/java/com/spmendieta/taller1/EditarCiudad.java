package com.spmendieta.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import HilosWS.HiloActualizarEmpleado;
import HilosWS.HiloActulizarCiudad;
import HilosWS.HiloEliminarCiudad;
import HilosWS.HiloEliminarEmpleado;

public class EditarCiudad extends AppCompatActivity {

    Button btnActualizar, btnEliminar;
    String id, nombre, cantidadHabitantes, latitud, longitud;
    TextView txtnombre, txtcantidadHabitantes, txtlatitud, txtlongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_ciudad);

        txtnombre = findViewById(R.id.txtNombCiudadED);
        txtcantidadHabitantes = findViewById(R.id.txtCantHabitantesED);
        txtlatitud = findViewById(R.id.txtLatitudED);
        txtlongitud = findViewById(R.id.txtLongitudED);

        btnActualizar = findViewById(R.id.btnActualizarCiudad);
        btnEliminar = findViewById(R.id.btnEliminarCiudad);

        Bundle datosRecibidos = this.getIntent().getExtras();
        id = String.valueOf(datosRecibidos.getInt("id"));
        nombre = datosRecibidos.getString("nombre");
        cantidadHabitantes = String.valueOf(datosRecibidos.getInt("cantidadHabitantes"));
        latitud = datosRecibidos.getString("latitud");
        longitud = datosRecibidos.getString("longitud");

        txtnombre.setText(nombre);
        txtcantidadHabitantes.setText(cantidadHabitantes);
        txtlatitud.setText(latitud);
        txtlongitud.setText(longitud);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HiloActulizarCiudad(EditarCiudad.this, id, txtnombre.getText().toString(),
                        txtcantidadHabitantes.getText().toString(), txtlatitud.getText().toString(),
                        txtlongitud.getText().toString()).execute();
                finish();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HiloEliminarCiudad(EditarCiudad.this, id).execute();
                finish();
            }
        });
    }
}
