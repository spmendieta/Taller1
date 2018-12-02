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

import Adapters.EmpleadosAdapter;
import EntidadesConexionBD.Empleado;
import HilosWS.VariablesEstaticas;

public class ListadoEmpleados extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Button btn;
    RecyclerView recyclerEmpleados;
    ArrayList<Empleado> listadoDeEmpleados;

    RequestQueue solicitud;
    JsonObjectRequest jsonSolictado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_empleados);
        btn = findViewById(R.id.btnAgregarEmpleado);
        generarLista();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListadoEmpleados.this, RegistroEmpleados.class));
            }
        });

    }

    private void generarLista() {
        listadoDeEmpleados = new ArrayList<>();
        recyclerEmpleados = findViewById(R.id.recyclerEmpleados);
        recyclerEmpleados.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerEmpleados.setHasFixedSize(true);

        solicitud = Volley.newRequestQueue(this);
        solicitarListado();
    }

    private void solicitarListado() {

        String url = "http://"+VariablesEstaticas.IP +"/conexionBD/consultarEmpleados.php";
        jsonSolictado = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        solicitud.add(jsonSolictado);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se puede realizar la operación.", Toast.LENGTH_LONG).show();
        Log.e("ErrorVolley: ", String.valueOf(error));
    }

    @Override
    public void onResponse(JSONObject response) {
        Empleado empleado;
        JSONArray arregloJson = response.optJSONArray("empleado");

        try {
            listadoDeEmpleados.clear();
            for (int i = 0; i < arregloJson.length(); i++) {
                empleado = new Empleado();
                JSONObject obj;
                obj = arregloJson.getJSONObject(i);

                empleado.setId(obj.optInt("id"));
                empleado.setNumerodoc(obj.optInt("numerodoc"));
                empleado.setTipodoc(obj.optString("tipodoc"));
                empleado.setNombre(obj.optString("nombres"));
                empleado.setApellidos(obj.optString("apellidos"));
                empleado.setTelefono(obj.optString("telefono"));
                empleado.setDireccion(obj.optString("direccion"));
                empleado.setEmail(obj.optString("email"));
                empleado.setIdEmpresa(obj.optInt("idEmpresa"));
                empleado.setCargo(obj.optString("cargo"));
                empleado.setSalario(obj.optString("salario"));

                listadoDeEmpleados.add(empleado);
            }
            EmpleadosAdapter adaptador = new EmpleadosAdapter(listadoDeEmpleados);

            adaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enviarDatosGestionarEmpleados(v);

                }
            });

            recyclerEmpleados.setAdapter(adaptador);
        } catch (JSONException jsonEx) {
            Log.e("Error 'for' JSON:", String.valueOf(jsonEx));
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        listadoDeEmpleados.clear();
        generarLista();
    }

    private void enviarDatosGestionarEmpleados(View v) {

        Intent intent = new Intent(ListadoEmpleados.this, EditarEmpleado.class);
        Bundle datos = new Bundle();
        datos.putInt("id", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getId());
        datos.putInt("numerodoc", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getNumerodoc());
        datos.putString("tipodoc", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getTipodoc());
        datos.putString("nombres", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getNombre());
        datos.putString("apellidos", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getApellidos());
        datos.putString("telefono", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getTelefono());
        datos.putString("direccion", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getDireccion());
        datos.putString("email", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getEmail());
        datos.putInt("idEmpresa", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getIdEmpresa());
        datos.putString("cargo", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getCargo());
        datos.putString("salario", listadoDeEmpleados.get(recyclerEmpleados.getChildAdapterPosition(v)).getSalario());

        intent.putExtras(datos);
        startActivity(intent);
    }

}
