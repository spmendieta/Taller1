package com.spmendieta.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapters.CiudadesAdapter;
import EntidadesCiudades.Ciudad;
import HilosWS.VariablesEstaticas;

public class TallerCiudades extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RecyclerView recyclerCiudades;
    ArrayList<Ciudad> listaCiudades;
    RequestQueue solicitud;
    JsonObjectRequest jsonSolictado;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_ciudades);
        btn = findViewById(R.id.btnAgregarCiudad);
        generarLista();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TallerCiudades.this, CrearCiudad.class));
            }
        });
    }

    private void generarLista() {
        listaCiudades = new ArrayList<>();
        recyclerCiudades = findViewById(R.id.recyclerCiudades);
        recyclerCiudades.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerCiudades.setHasFixedSize(true);
        solicitud = Volley.newRequestQueue(this);
        solicitarListado();
    }

    private void solicitarListado() {
        String url = "http://" + VariablesEstaticas.IP + "/bd_android_ciudades/ConsultarCiudad.php";
        jsonSolictado = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        solicitud.add(jsonSolictado);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "Imposible consultar lista.", Toast.LENGTH_SHORT).show();
        Log.e("EV: ", String.valueOf(error));
    }

    @Override
    public void onResponse(JSONObject response) {
        Ciudad ciudad;
        JSONArray arregloJson = response.optJSONArray("ciudades");

        try {
            listaCiudades.clear();
            for (int i = 0; i < arregloJson.length(); i++) {
                ciudad = new Ciudad();
                JSONObject obj;
                obj = arregloJson.getJSONObject(i);

                ciudad.setId(obj.optInt("id"));
                ciudad.setNombre(obj.optString("nombre"));
                ciudad.setCantidadHabitantes(obj.optInt("cantidadHabitantes"));
                ciudad.setLatitud(obj.optString("latitud"));
                ciudad.setLongitud(obj.optString("longitud"));

                listaCiudades.add(ciudad);
            }
            CiudadesAdapter ciudadesAdapter = new CiudadesAdapter(listaCiudades);

            ciudadesAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getionarCiudades(v);
                }
            });
            recyclerCiudades.setAdapter(ciudadesAdapter);

        } catch (JSONException jsonEx) {
            Log.e("Error 'for' JSON:", String.valueOf(jsonEx));
        }
    }

    public void getionarCiudades(View v) {

        Intent intent = new Intent(TallerCiudades.this, EditarCiudad.class);
        Bundle datos = new Bundle();
        datos.putInt("id", listaCiudades.get(recyclerCiudades.getChildAdapterPosition(v)).getId());
        datos.putString("nombre", listaCiudades.get(recyclerCiudades.getChildAdapterPosition(v)).getNombre());
        datos.putInt("cantidadHabitantes", listaCiudades.get(recyclerCiudades.getChildAdapterPosition(v)).getCantidadHabitantes());
        datos.putString("latitud", listaCiudades.get(recyclerCiudades.getChildAdapterPosition(v)).getLatitud());
        datos.putString("longitud", listaCiudades.get(recyclerCiudades.getChildAdapterPosition(v)).getLongitud());

        intent.putExtras(datos);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaCiudades.clear();
        generarLista();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
