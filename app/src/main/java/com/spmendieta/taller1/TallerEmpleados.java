package com.spmendieta.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class TallerEmpleados extends AppCompatActivity {

    private CardView tarjetaEmpleados, tarjetaEmpresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_empleados);

        setTarjetaEmpleados((CardView) findViewById(R.id.cardListaEmpleados));
        setTarjetaEmpresas((CardView) findViewById(R.id.cardListaEmpresas));

        getTarjetaEmpleados().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TallerEmpleados.this, ListadoEmpleados.class));
            }
        });

        getTarjetaEmpresas().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TallerEmpleados.this, ListadoEmpresas.class));
            }
        });

    }

    public CardView getTarjetaEmpresas() {
        return tarjetaEmpresas;
    }

    public void setTarjetaEmpresas(CardView tarjetaEmpresas) {
        this.tarjetaEmpresas = tarjetaEmpresas;
    }

    public CardView getTarjetaEmpleados() {
        return tarjetaEmpleados;
    }

    public void setTarjetaEmpleados(CardView tarjetaEmpleados) {
        this.tarjetaEmpleados = tarjetaEmpleados;
    }

}
