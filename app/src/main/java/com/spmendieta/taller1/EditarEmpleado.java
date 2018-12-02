package com.spmendieta.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import HilosWS.HiloActualizarEmpleado;
import HilosWS.HiloEliminarEmpleado;

public class EditarEmpleado extends AppCompatActivity {

    int id;
    String tipoDocumento;
    Button btnActualizar, btnEliminar;
    RadioButton rCedula, rPasaporte, rTarjeta;
    EditText numerodoc, nombres, apellidos, telefono, direccion, email, idEmpresa, cargo, salario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_empleado);

        numerodoc = findViewById(R.id.txtNumDocumentoED);
        rCedula = findViewById(R.id.rbCedulaED);
        rPasaporte = findViewById(R.id.rbContraED);
        rTarjeta = findViewById(R.id.rbTarjetaIdentidadED);
        nombres = findViewById(R.id.txtNombreED);
        apellidos = findViewById(R.id.txtApellidosED);
        telefono = findViewById(R.id.txtTelefonoED);
        direccion = findViewById(R.id.txtDireccionED);
        email = findViewById(R.id.txtEmailED);
        idEmpresa = findViewById(R.id.txtIdEmpresaED);
        cargo = findViewById(R.id.txtCargoED);
        salario = findViewById(R.id.txtSalarioED);
        btnActualizar = findViewById(R.id.btnActualizarEmpleado);
        btnEliminar = findViewById(R.id.btnEliminarEmpleado);

        Bundle datosRecibidos = this.getIntent().getExtras();
        id = datosRecibidos.getInt("id");
        tipoDocumento = datosRecibidos.getString("tipodoc");

        if(datosRecibidos != null){
            numerodoc.setText(String.valueOf(datosRecibidos.getInt("numerodoc")));
            if (tipoDocumento.equalsIgnoreCase("Cedula")){
                rCedula.setChecked(true);
            }else if(tipoDocumento.equalsIgnoreCase("Pasaporte")) {
                rPasaporte.setChecked(true);
            } else {
                rTarjeta.setChecked(true);
            }

            nombres.setText(datosRecibidos.getString("nombres"));
            apellidos.setText(datosRecibidos.getString("apellidos"));
            telefono.setText(datosRecibidos.getString("telefono"));
            direccion.setText(datosRecibidos.getString("direccion"));
            email.setText(datosRecibidos.getString("email"));
            idEmpresa.setText(String.valueOf(datosRecibidos.getInt("idEmpresa")));
            cargo.setText(datosRecibidos.getString("cargo"));
            salario.setText(datosRecibidos.getString("salario"));

            Log.e("Valor ID: ", String.valueOf(id));
        }


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rCedula.isChecked()){
                    tipoDocumento = "Cedula";
                }else if(rPasaporte.isChecked()){
                    tipoDocumento = "Pasaporte";
                }else if(rTarjeta.isChecked()){
                    tipoDocumento = "Tarjeta de Identidad";
                }

            new HiloActualizarEmpleado(EditarEmpleado.this, String.valueOf(id),
                    numerodoc.getText().toString(), tipoDocumento, nombres.getText().toString(),
                    apellidos.getText().toString(), telefono.getText().toString(), direccion.getText().toString(),
                    email.getText().toString(), idEmpresa.getText().toString(), cargo.getText().toString(),
                    salario.getText().toString()).execute();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HiloEliminarEmpleado(String.valueOf(id), EditarEmpleado.this).execute();
            }
        });

    }
}
