package HilosWS;

import android.app.Activity;
import android.os.AsyncTask;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class HiloEliminarCiudad extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    Activity interfaz;
    private String id;
    private RequestQueue consulta;
    private JsonObjectRequest json;

    public HiloEliminarCiudad(Activity interfaz, String id) {
        this.interfaz = interfaz;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        consulta = Volley.newRequestQueue(interfaz.getApplicationContext());
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlWeb = "http://" + VariablesEstaticas.IP + "/bd_android_ciudades/EliminarCiudad.php?id=" + id + "";
        json = new JsonObjectRequest(Request.Method.GET, urlWeb, null, this, this);
        consulta.add(json);

        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
