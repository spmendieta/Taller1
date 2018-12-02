package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spmendieta.taller1.R;

import java.util.List;

import EntidadesCiudades.Ciudad;

public class CiudadesAdapter extends RecyclerView.Adapter<CiudadesAdapter.CiudadesHolder> implements View.OnClickListener {

    List<Ciudad> listaCiudades;
    private View.OnClickListener listener;

    public CiudadesAdapter(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    @NonNull
    @Override
    public CiudadesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ciudades, viewGroup, false);
        RecyclerView.LayoutParams parametrosLayout = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(parametrosLayout);
        vista.setOnClickListener(this);
        return new CiudadesHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadesHolder ciudadesHolder, int i) {
        ciudadesHolder.id.setText(String.valueOf(listaCiudades.get(i).getId()));
        ciudadesHolder.nombre.setText(listaCiudades.get(i).getNombre());
        ciudadesHolder.cantidadHabitantes.setText(String.valueOf(listaCiudades.get(i).getCantidadHabitantes()));
        ciudadesHolder.latitud.setText(listaCiudades.get(i).getLatitud());
        ciudadesHolder.longitud.setText(listaCiudades.get(i).getLongitud());
    }

    @Override
    public int getItemCount() {
        return listaCiudades.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public class CiudadesHolder extends RecyclerView.ViewHolder {

        TextView nombre, id, cantidadHabitantes, latitud, longitud;

        public CiudadesHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtMostrarNombreCiudad);
            id = itemView.findViewById(R.id.txtMostrarID);
            cantidadHabitantes = itemView.findViewById(R.id.txtMostrarHabitantes);
            latitud = itemView.findViewById(R.id.txtMostrarLatitud);
            longitud = itemView.findViewById(R.id.txtMostrarLongitud);
        }

    }

}
