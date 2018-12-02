package com.spmendieta.taller1;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class HiloRelojMilitar extends AsyncTask<Void, Integer, Void> {

    private Button btn;
    private Activity activity;
    private String scheduleTag = "";
    private TextView txtHora, txtHoraNormal;
    private int i = 0, hour, horaComun, hTemp, minutes, seconds;

    @Override
    protected Void doInBackground(Void... voids) {
        txtHora = activity.findViewById(R.id.txtTiempo);
        txtHoraNormal = activity.findViewById(R.id.txtTiempoNormal);
        btn = activity.findViewById(R.id.btnTiempo);
        btn.setClickable(false);
        this.horaComun = hour;

        while (!isCancelled()) {
            publishProgress();
            seconds++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        validateCommonHour();

        if (seconds >= 60) {
            seconds = 0;
            minutes += 1;
        }

        if (minutes >= 60) {
            minutes = 0;
            hour += 1;
            horaComun += 1;
        }

        if (hour > 24) {
            hour = 1;
            horaComun = 1;
        }

        txtHoraNormal.setText(String.format("%02d", hTemp)
                + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds) + " " + scheduleTag);


        txtHora.setText(String.format("%02d", hour)
                + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));


    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    void setActivityParent(Activity activity, int h, int m, int s) {
        this.activity = activity;
        this.hour = h;
        this.minutes = m;
        this.seconds = s;
    }

    private void validateCommonHour() {
        if (horaComun < 13){
            hTemp = horaComun;
            scheduleTag = "AM";
        } else{
            hTemp = horaComun - 12;
            scheduleTag = "PM";
        }
    }

}
