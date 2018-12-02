package HilosWS;

import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spmendieta.taller1.EditarEmpleado;
import org.json.JSONObject;

public class HiloEliminarEmpleado extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    private String id;
    private RequestQueue consulta;
    private JsonObjectRequest json;
    EditarEmpleado interfazGestion;

    public HiloEliminarEmpleado(String id, EditarEmpleado interfazGestion) {
        this.id = id;
        this.interfazGestion = interfazGestion;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        eliminarEmpleado();
        return null;
    }

    private void eliminarEmpleado() {
        consulta = Volley.newRequestQueue(interfazGestion.getApplicationContext());

        String urlWeb = "http://"+VariablesEstaticas.IP+"/conexionBD/eliminarEmpleado.php?id= "+id+"";
        json = new JsonObjectRequest(Request.Method.GET, urlWeb, null, this, this);
        consulta.add(json);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Error JSON: ", String.valueOf(error));
    }

    @Override
    public void onResponse(JSONObject response) {

    }

}
