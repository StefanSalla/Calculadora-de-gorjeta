package com.salla.calcGorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txValor;
    private TextView txPorcentagem, vlGorjeta, vlTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txValor = findViewById(R.id.txValor);
        txPorcentagem = findViewById(R.id.txPorcentagem);
        vlGorjeta= findViewById(R.id.vlGorjeta);
        vlTotal= findViewById(R.id.vlTotal);
        seekBarGorjeta= findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                txPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String vlRecuperado = txValor.getText().toString();
        if( vlRecuperado == null || vlRecuperado.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        } else {

            double vlDigitado = Double.parseDouble( vlRecuperado );
            double gorjeta = vlDigitado * (porcentagem/100);
            vlGorjeta.setText("R$ " + gorjeta );
            double Total = vlDigitado + gorjeta ;
            vlTotal.setText("R$ " + Math.round(Total) );

        }

    }


}