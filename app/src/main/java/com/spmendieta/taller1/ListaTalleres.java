package com.spmendieta.taller1;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaTalleres extends AppCompatActivity {

    private ListView listaTalleres;
    private ArrayList<String> itemsAdaptador;
    private ArrayAdapter adaptadorTalleres;
    private Intent transicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_talleres);

        this.listaTalleres = findViewById(R.id.listViewTalleres);
        this.itemsAdaptador = new ArrayList<>();
        itemsAdaptador.add("Taller # 1 - Ejercicios Básicos I");
        itemsAdaptador.add("Taller # 2 - Ejercicios Básicos II" );
        itemsAdaptador.add("Taller # 3 - Ejercicios Básicos III");
        itemsAdaptador.add("Taller # 4 - Hilos: Semáforo");
        itemsAdaptador.add("Taller # 5 - Hilos: Reloj");
        itemsAdaptador.add("Taller # 6 - Web Services: Empleados y Empresas");
        itemsAdaptador.add("Taller # 7 - Web Services: Ciudades");

        this.adaptadorTalleres = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsAdaptador);
        this.listaTalleres.setAdapter(adaptadorTalleres);

        listaTalleres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        transicion = new Intent(getApplicationContext(), MainActivity.class);
                        break;
                    case 1:
                        transicion = new Intent(getApplicationContext(), Taller2.class);
                        break;
                    case 2:
                        transicion = new Intent(getApplicationContext(), Taller3.class);
                        break;
                    case 3:
                        transicion = new Intent(getApplicationContext(), Semaforo.class);
                        break;
                    case 4:
                        transicion = new Intent(getApplicationContext(), Reloj.class);
                        break;
                    case 5:
                        transicion = new Intent(getApplicationContext(), TallerEmpleados.class);
                        break;
                    case 6:
                        transicion = new Intent(getApplicationContext(), TallerCiudades.class);
                        break;
                }

                startActivity(transicion);
            }
        });
    }
}
