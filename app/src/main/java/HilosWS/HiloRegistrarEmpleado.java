package HilosWS;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spmendieta.taller1.R;
import com.spmendieta.taller1.RegistroEmpleados;

import org.json.JSONObject;

public class HiloRegistrarEmpleado extends AsyncTask implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Button btnRegistrar;
    private RequestQueue solicitud;
    private String tipoDocumento;
    private JsonObjectRequest JsonSolicitud;
    private RegistroEmpleados interfazResgistroEmpleados;
    private EditText txtNumDocumento, txtNombre, txtApellidos, txtTelefono, txtDireccion,
            txtEmail, txtIdEmpresa, txtCargo, txtSalario;

    public HiloRegistrarEmpleado(RegistroEmpleados interfazResgistroEmpleados, String tipoDocumento) {
        this.interfazResgistroEmpleados = interfazResgistroEmpleados;
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btnRegistrar = interfazResgistroEmpleados.findViewById(R.id.btnRegistrarEmpleado);
        btnRegistrar.setClickable(false);

        txtNumDocumento = interfazResgistroEmpleados.findViewById(R.id.txtNumDocumento);
        txtNombre = interfazResgistroEmpleados.findViewById(R.id.txtNombre);
        txtApellidos = interfazResgistroEmpleados.findViewById(R.id.txtApellidos);
        txtTelefono = interfazResgistroEmpleados.findViewById(R.id.txtTelefono);
        txtDireccion = interfazResgistroEmpleados.findViewById(R.id.txtDireccion);
        txtEmail = interfazResgistroEmpleados.findViewById(R.id.txtEmail);
        txtIdEmpresa = interfazResgistroEmpleados.findViewById(R.id.txtIdEmpresa);
        txtCargo = interfazResgistroEmpleados.findViewById(R.id.txtCargo);
        txtSalario = interfazResgistroEmpleados.findViewById(R.id.txtSalario);
        solicitud = Volley.newRequestQueue(interfazResgistroEmpleados.getApplicationContext());
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        registrarEmpleado();
        return null;
    }

    private void registrarEmpleado() {
        String urlWeb = "http://" + VariablesEstaticas.IP + "/conexionBD/registrarEmpleado.php?id=null&numerodoc=" +
                txtNumDocumento.getText().toString() +
                "&tipodoc=" + tipoDocumento + "&nombres=" +
                txtNombre.getText().toString() + "&apellidos=" +
                txtApellidos.getText().toString() + "&telefono=" +
                txtTelefono.getText().toString() + "&direccion=" +
                txtDireccion.getText().toString() + "&email=" + txtEmail.getText().toString() +
                "&idEmpresa=" + txtIdEmpresa.getText().toString() +
                "&cargo=" + txtCargo.getText().toString() + "&salario=" + txtSalario.getText().toString() + "";

        urlWeb = urlWeb.replace(" ", "%20");

        System.out.println(urlWeb);

        JsonSolicitud = new JsonObjectRequest(Request.Method.GET, urlWeb, null, this, this);
        solicitud.add(JsonSolicitud);
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(interfazResgistroEmpleados.getApplicationContext(), "Registrado con éxito.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(interfazResgistroEmpleados.getApplicationContext(), "No se logró registrar.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        btnRegistrar.setClickable(true);
    }
}
