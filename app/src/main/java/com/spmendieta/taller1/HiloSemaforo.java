package com.spmendieta.taller1;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HiloSemaforo extends AsyncTask<Void, Integer, Void> {

    private Button btn;
    private Activity activity;
    private TextView txtSegundos;
    private ImageView imgRojo, imgAmarillo, imgVerde;
    private short indicador = 0, indicadorRojo = 61, indicadorAmarillo = 3, indicadorVerde = 31;

    @Override
    protected Void doInBackground(Void... voids) {
        btn = activity.findViewById(R.id.btnIniciarSemaforo);
        imgRojo = activity.findViewById(R.id.imgRojo);
        imgAmarillo = activity.findViewById(R.id.imgAmarillo);
        imgVerde = activity.findViewById(R.id.imgVerde);
        txtSegundos = activity.findViewById(R.id.txtSegundos);

        btn.setClickable(false);

        while (!isCancelled()) {
            indicador++;
            publishProgress();
            try {
                Thread.sleep(100);
                System.out.println("Valor del iterador: " + indicador + "Seg");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... params) {

        if (indicador >= 0 && indicador <= 60) {
            imgAmarillo.setImageResource(R.drawable.color_blanco);
            imgRojo.setImageResource(R.drawable.color_rojo);
            indicadorRojo--;
            txtSegundos.setText("Segundos: " + indicadorRojo + "Segs");
        } else if (indicador > 60 && indicador <= 62) {
            imgRojo.setImageResource(R.drawable.color_blanco);
            imgAmarillo.setImageResource(R.drawable.color_amarillo);
            indicadorAmarillo--;
            txtSegundos.setText("Segundos: " + indicadorAmarillo + "Segs");
        } else if (indicador > 61 && indicador <= 92) {
            imgAmarillo.setImageResource(R.drawable.color_blanco);
            imgVerde.setImageResource(R.drawable.color_verde);
            indicadorVerde--;
            txtSegundos.setText("Segundos: " + indicadorVerde + "Segs");
            if (indicador == 92) {
                indicadorAmarillo = 3;
            }
        } else if (indicador > 92 && indicador < 95) {
            imgVerde.setImageResource(R.drawable.color_blanco);
            imgAmarillo.setImageResource(R.drawable.color_amarillo);
            indicadorAmarillo--;
            if (indicador == 94) {
                indicadorRojo = 61;
                indicadorAmarillo = 3;
                indicadorVerde = 31;
                indicador = 0;
            }
        }

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        restartIterators();
    }

    private void restartIterators() {
        this.indicador = 0;
        this.indicadorRojo = 61;
        this.indicadorAmarillo = 3;
        this.indicadorVerde = 31;
    }

    void setActivityParent(Activity activity) {
        this.activity = activity;
    }

}
