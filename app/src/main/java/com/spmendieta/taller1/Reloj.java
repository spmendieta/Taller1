package com.spmendieta.taller1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reloj extends AppCompatActivity {

    private Button btn;
    private EditText horasIntroducidas;
    private HiloRelojMilitar horaMilitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj);
        horasIntroducidas = findViewById(R.id.txtHorasIntroducidas);
        btn = findViewById(R.id.btnTiempo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = horasIntroducidas.getText().toString();

                if (cadena.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "No puede dejar el campo vacío", Toast.LENGTH_SHORT).show();
                } else {
                    try {


                        String[] arregloHoras = cadena.split(":");
                        horaMilitar = new HiloRelojMilitar();
                        horaMilitar.setActivityParent(Reloj.this,
                                Integer.parseInt(arregloHoras[0]), Integer.parseInt(arregloHoras[1]),
                                Integer.parseInt(arregloHoras[2]));

                        horaMilitar.execute();
                        horasIntroducidas.setEnabled(false);
                    } catch (Exception e) {
                        Log.i("Error: ", String.valueOf(e));
                    }
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            horaMilitar.cancel(true);
            btn.setClickable(true);
            horasIntroducidas.setEnabled(true);
        } catch (Exception e) {
            Log.i("Error: ", String.valueOf(e));
        }
    }
}
