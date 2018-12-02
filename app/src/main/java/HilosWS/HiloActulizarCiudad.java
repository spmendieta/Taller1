package HilosWS;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spmendieta.taller1.EditarCiudad;

import org.json.JSONObject;

public class HiloActulizarCiudad extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditarCiudad interfaz;
    private RequestQueue solicitud;
    private JsonObjectRequest JsonSolicitud;
    private String id, nombre, cantidadHabitantes, latitud, longitud;

    public HiloActulizarCiudad(EditarCiudad interfaz, String id, String nombre, String cantidadHabitantes, String latitud, String longitud) {
        this.interfaz = interfaz;
        this.id = id;
        this.nombre = nombre;
        this.cantidadHabitantes = cantidadHabitantes;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        solicitud = Volley.newRequestQueue(interfaz.getApplicationContext());
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        String urlWeb = "http://" + VariablesEstaticas.IP + "/bd_android_ciudades/ActualizarCiudad.php?nombre=" +
                nombre + "&cantidadHabitantes=" + cantidadHabitantes + "&latitud=" + latitud + "&longitud=" + longitud + "&id=" + id + "";

        urlWeb = urlWeb.replace(" ", "%20");

        Log.e("URL", urlWeb);

        JsonSolicitud = new JsonObjectRequest(Request.Method.GET, urlWeb, null, this, this);
        solicitud.add(JsonSolicitud);

        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(interfaz.getApplicationContext(), "Edición exitosa.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
