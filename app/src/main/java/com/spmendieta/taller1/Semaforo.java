package com.spmendieta.taller1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Semaforo extends AppCompatActivity {

    Button btn;
    ImageView imgRojo, imgAmarillo, imgVerde;
    HiloSemaforo semaforoThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaforo);
        imgRojo = findViewById(R.id.imgRojo);
        imgAmarillo = findViewById(R.id.imgAmarillo);
        imgVerde = findViewById(R.id.imgVerde);

        imgRojo.setImageResource(R.drawable.color_blanco);
        imgAmarillo.setImageResource(R.drawable.color_blanco);
        imgVerde.setImageResource(R.drawable.color_blanco);

        btn = findViewById(R.id.btnIniciarSemaforo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                semaforoThread = new HiloSemaforo();
                semaforoThread.setActivityParent(Semaforo.this);
                semaforoThread.execute();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            semaforoThread.cancel(true);
        } catch (Exception e) {
            Log.i("Error: ", String.valueOf(e));
        }
    }
}
