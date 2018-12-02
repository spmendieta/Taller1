package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spmendieta.taller1.R;

import java.util.List;

import EntidadesConexionBD.Empresa;

public class EmpresasAdapter extends RecyclerView.Adapter<EmpresasAdapter.EmpresasHolder> implements View.OnClickListener {

    List<Empresa> listaEmpresas;
    private View.OnClickListener listener;

    public EmpresasAdapter(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    @Override
    public EmpresasHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empresas, viewGroup, false);
        RecyclerView.LayoutParams parametrosLayout = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(parametrosLayout);
        vista.setOnClickListener(this);
        return new EmpresasHolder(vista);
    }

    @Override
    public void onBindViewHolder(EmpresasHolder empresasHolder, int i) {
        empresasHolder.nombreEmpresa.setText(listaEmpresas.get(i).getNombre());
        empresasHolder.nitEmpresa.setText(String.valueOf(listaEmpresas.get(i).getNit()));
    }

    @Override
    public int getItemCount() {
        return listaEmpresas.size();
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

    public class EmpresasHolder extends RecyclerView.ViewHolder {
        TextView nombreEmpresa, nitEmpresa;

        public EmpresasHolder(View itemView) {
            super(itemView);
            nombreEmpresa = itemView.findViewById(R.id.txtNombreItemEmpresa);
            nitEmpresa = itemView.findViewById(R.id.txtNumeroNIT);
        }

    }
}
