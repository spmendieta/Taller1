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

import Adapters.EmpresasAdapter;
import EntidadesConexionBD.Empresa;
import HilosWS.VariablesEstaticas;

public class ListadoEmpresas extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue consulta;
    JsonObjectRequest json;
    private Button btn;
    private RecyclerView recyclerEmpresas;
    private ArrayList<Empresa> listadoEmpresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_empresas);
        btn = findViewById(R.id.btnCrearEmpresa);
        generarListado();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListadoEmpresas.this, RegistroEmpresas.class));
            }
        });
    }

    private void generarListado() {

        listadoEmpresas = new ArrayList<>();
        recyclerEmpresas = findViewById(R.id.recyclerEmpresas);
        recyclerEmpresas.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerEmpresas.setHasFixedSize(true);

        consulta = Volley.newRequestQueue(this);
        solicitarLista();
    }

    private void solicitarLista() {

        String url = "http://" + VariablesEstaticas.IP + "/conexionBD/consultarEmpresas.php";
        json = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        consulta.add(json);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se puede realizar la operación.", Toast.LENGTH_LONG).show();
        Log.e("ErrorVolley: ", String.valueOf(error));
    }

    @Override
    public void onResponse(JSONObject response) {
        Empresa empresa;
        JSONArray arregloJson = response.optJSONArray("empresa");
        try {
            listadoEmpresas.clear();

            for (int i = 0; i < arregloJson.length(); i++) {
                empresa = new Empresa();
                JSONObject obj;
                obj = arregloJson.getJSONObject(i);

                empresa.setId(obj.optInt("id"));
                empresa.setNit(obj.optInt("nit"));
                empresa.setTipoempresa(obj.getString("tipoempresa"));
                empresa.setNombre(obj.getString("nombre"));
                empresa.setTelefono(obj.getString("telefono"));
                empresa.setDireccion(obj.getString("direccion"));
                empresa.setEmail(obj.getString("email"));
                listadoEmpresas.add(empresa);
            }

            EmpresasAdapter adapterEmpresas = new EmpresasAdapter(listadoEmpresas);
            adapterEmpresas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: Crear metodo para acceder a cada item del Recycler. Ahora tengo sueño :u.
                }
            });

            recyclerEmpresas.setAdapter(adapterEmpresas);

        } catch (JSONException jEx) {
            Log.e("Error 'for' JSON:", String.valueOf(jEx));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        listadoEmpresas.clear();
        solicitarLista();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
