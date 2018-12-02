package HilosWS;

import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spmendieta.taller1.CrearCiudad;

import org.json.JSONObject;

public class HiloRegistrarCiudad extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    CrearCiudad interfaz;
    String nombre, cantidadHabitantes, latitud, longitud;
    private RequestQueue solicitud;
    private JsonObjectRequest JsonSolicitud;

    public HiloRegistrarCiudad(CrearCiudad interfaz, String nombre, String cantidadHabitantes, String latitud, String longitud) {
        this.interfaz = interfaz;
        this.nombre = nombre;
        this.cantidadHabitantes = cantidadHabitantes;
        this.latitud = latitud;
        this.longitud = longitud;
        solicitud = Volley.newRequestQueue(interfaz.getApplicationContext());
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlWeb = "http://"+VariablesEstaticas.IP+"/bd_android_ciudades/InsertarCiudad.php?id=null&nombre="+
                nombre+"&cantidadHabitantes="+cantidadHabitantes+"&latitud="+latitud+"&longitud="+longitud+"";

        urlWeb = urlWeb.replace(" ", "%20");

        System.out.println(urlWeb);

        JsonSolicitud = new JsonObjectRequest(Request.Method.GET, urlWeb, null, this, this);
        solicitud.add(JsonSolicitud);

        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(interfaz.getApplicationContext(), "Ciudad agregada con éxito.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
