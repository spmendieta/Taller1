package HilosWS;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spmendieta.taller1.EditarEmpleado;
import com.spmendieta.taller1.ListadoEmpleados;

import org.json.JSONObject;

public class HiloActualizarEmpleado extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditarEmpleado interfazGestion;
    String id, numeroDocumento, tipoDoc, nombres, apellidos, telefono, direccion, email, idEmpresa, cargo, salario;
    private RequestQueue solicitud;
    private JsonObjectRequest JsonSolicitud;

    public HiloActualizarEmpleado(EditarEmpleado interfazGestion, String id, String numeroDocumento, String tipoDoc, String nombres, String apellidos, String telefono, String direccion, String email, String idEmpresa, String cargo, String salario) {
        this.interfazGestion = interfazGestion;
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.tipoDoc = tipoDoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.idEmpresa = idEmpresa;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        solicitud = Volley.newRequestQueue(interfazGestion.getApplicationContext());
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        actualizarEmpleado();
        return null;
    }

    private void actualizarEmpleado() {

        String urlWeb = "http://" + VariablesEstaticas.IP + "/conexionBD/actualizarEmpleados.php?numerodoc="
                + numeroDocumento + "&tipodoc=" + tipoDoc + "&nombres=" + nombres + "&apellidos=" + apellidos + "&telefono="
                + telefono + "&direccion=" + direccion + "&email=" + email + "&idEmpresa=" + idEmpresa + "&cargo=" + cargo
                + "&salario=" + salario + "&id=" + id;

        urlWeb = urlWeb.replace(" ", "%20");

        Log.e("Dir WEB: ", urlWeb);

        JsonSolicitud = new JsonObjectRequest(Request.Method.POST, urlWeb, null, this, this);
        solicitud.add(JsonSolicitud);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Error Volley: ", String.valueOf(error));
    }

    @Override
    public void onResponse(JSONObject response) {

    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

    }
}
