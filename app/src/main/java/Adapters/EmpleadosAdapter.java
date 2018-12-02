package Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spmendieta.taller1.R;

import java.util.List;

import EntidadesConexionBD.Empleado;

public class EmpleadosAdapter extends RecyclerView.Adapter<EmpleadosAdapter.EmpleadosHolder> implements View.OnClickListener {

    List<Empleado> listaDeEmpleados;
    private View.OnClickListener listener;

    public EmpleadosAdapter(List<Empleado> listaDeEmpleados) {
        this.listaDeEmpleados = listaDeEmpleados;
    }

    @Override
    public EmpleadosHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empleados, viewGroup, false);
        RecyclerView.LayoutParams parametrosLayout = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(parametrosLayout);
        vista.setOnClickListener(this);
        return new EmpleadosHolder(vista);
    }

    @Override
    public void onBindViewHolder(EmpleadosHolder empleadosHolder, int i) {
        empleadosHolder.numDocumento.setText(String.valueOf(listaDeEmpleados.get(i).getNumerodoc()));
        empleadosHolder.nombreEmpleado.setText(listaDeEmpleados.get(i).getNombre().toString());
        empleadosHolder.apellidosEmpleado.setText(listaDeEmpleados.get(i).getApellidos().toString());



    }

    @Override
    public int getItemCount() {
        return listaDeEmpleados.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class EmpleadosHolder extends RecyclerView.ViewHolder {
        TextView nombreEmpleado, apellidosEmpleado, numDocumento;

        public EmpleadosHolder(View itemView) {
            super(itemView);
            nombreEmpleado = itemView.findViewById(R.id.txtNombreItemEmpleado);
            apellidosEmpleado = itemView.findViewById(R.id.txtApellidoItemEmpleado);
            numDocumento = itemView.findViewById(R.id.txtDocumentoItemEmpleado);
        }
    }

}

