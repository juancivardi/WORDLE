package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private int filaActual = 1;
    private int casillaActual = 1;
    private int ultimaCasilla = 5;
    private boolean juegoTerminado = false;
    private TextView filaCasillas [] = new TextView [6];
    private String palabraEscondida = "FUEGO";
    private String palabraIngresada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        cargarProximaFila();
    }

    private void cargarProximaFila(){
        switch (filaActual){

            case 1:
                filaCasillas[1] = findViewById(R.id.casilla1);
                filaCasillas[2] = findViewById(R.id.casilla2);
                filaCasillas[3] = findViewById(R.id.casilla3);
                filaCasillas[4] = findViewById(R.id.casilla4);
                filaCasillas[5] = findViewById(R.id.casilla5);
                break;
            case 2:
                filaCasillas[1] = findViewById(R.id.casilla6);
                filaCasillas[2] = findViewById(R.id.casilla7);
                filaCasillas[3] = findViewById(R.id.casilla8);
                filaCasillas[4] = findViewById(R.id.casilla9);
                filaCasillas[5] = findViewById(R.id.casilla10);
                break;
            case 3:
                filaCasillas[1] = findViewById(R.id.casilla11);
                filaCasillas[2] = findViewById(R.id.casilla12);
                filaCasillas[3] = findViewById(R.id.casilla13);
                filaCasillas[4] = findViewById(R.id.casilla14);
                filaCasillas[5] = findViewById(R.id.casilla15);
                break;
            case 4:
                filaCasillas[1] = findViewById(R.id.casilla16);
                filaCasillas[2] = findViewById(R.id.casilla17);
                filaCasillas[3] = findViewById(R.id.casilla18);
                filaCasillas[4] = findViewById(R.id.casilla19);
                filaCasillas[5] = findViewById(R.id.casilla20);
                break;
            case 5:
                filaCasillas[1] = findViewById(R.id.casilla21);
                filaCasillas[2] = findViewById(R.id.casilla22);
                filaCasillas[3] = findViewById(R.id.casilla23);
                filaCasillas[4] = findViewById(R.id.casilla24);
                filaCasillas[5] = findViewById(R.id.casilla25);
                break;
            case 6:
                filaCasillas[1] = findViewById(R.id.casilla26);
                filaCasillas[2] = findViewById(R.id.casilla27);
                filaCasillas[3] = findViewById(R.id.casilla28);
                filaCasillas[4] = findViewById(R.id.casilla29);
                filaCasillas[5] = findViewById(R.id.casilla30);
                break;
        }
    }

    public void enviarLetra(View v){
        Button boton = (Button)v;
        String letraApretada = boton.getText().toString();
        if(!juegoTerminado && filaCasillas[casillaActual].getText() == ""){
            palabraIngresada = palabraIngresada + letraApretada;
            filaCasillas[casillaActual].setText(letraApretada);
            if(casillaActual < ultimaCasilla) casillaActual++;
        } else if (juegoTerminado){
            Toast.makeText(this, "Juego terminado.", Toast.LENGTH_SHORT).show();
        }
    }

    public void borrarLetra(View v){
        if (!juegoTerminado && !palabraIngresada.equals("")) {
            if (filaCasillas[casillaActual].getText().equals("")) casillaActual--;
            palabraIngresada = palabraIngresada.substring(0, palabraIngresada.length() - 1);
            filaCasillas[casillaActual].setText("");
        }
    }

    public void comprobarPalabra(View v){
        if (!juegoTerminado) {
            if (!filaCasillas[casillaActual].getText().equals("")) {
                procesarPalabraIngresada();
                if (palabraIngresada.equals(palabraEscondida)) {
                    Toast.makeText(this, "Palabra encontrada!", Toast.LENGTH_SHORT).show();
                    juegoTerminado = true;
                } else {
                    palabraIngresada = "";
                    filaActual++;
                    casillaActual = 1;
                    cargarProximaFila();
                }
            } else {
                Toast.makeText(this, "Complete la palabra para enviarla", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Juego terminado.", Toast.LENGTH_SHORT).show();
        }
    }

    private void procesarPalabraIngresada(){
        for (int i = 0; i <= 4; i++) {
            String letra = "" + palabraIngresada.charAt(i);
            if (palabraEscondida.contains(letra)) {
                validarPosicionDeLetra(i);
            } else {
                pintarLetra(i, R.color.grey);
            }

        }
    }

    private void validarPosicionDeLetra(int pos){
        if (palabraEscondida.charAt(pos) == palabraIngresada.charAt(pos))
            pintarLetra(pos, R.color.green);
        else
            pintarLetra(pos, R.color.yellow);
    }


    private void pintarLetra (int i, int color){
        filaCasillas[i+1].setBackgroundResource(color);
        char letra = palabraIngresada.charAt(i);
        switch (letra) {
            case 'A': findViewById(R.id.letraA).setBackgroundColor(color);
                break;
            case 'B': findViewById(R.id.letraB).setBackgroundColor(color);
                break;
            case 'C': findViewById(R.id.letraC).setBackgroundColor(color);
                break;
            case 'D': findViewById(R.id.letraD).setBackgroundColor(color);
                break;
            case 'E': findViewById(R.id.letraE).setBackgroundColor(color);
                break;
            case 'F': findViewById(R.id.letraF).setBackgroundColor(color);
                break;
            case 'G': findViewById(R.id.letraG).setBackgroundColor(color);
                break;
            case 'H': findViewById(R.id.letraH).setBackgroundColor(color);
                break;
            case 'I': findViewById(R.id.letraI).setBackgroundColor(color);
                break;
            case 'J': findViewById(R.id.letraJ).setBackgroundColor(color);
                break;
            case 'K': findViewById(R.id.letraK).setBackgroundColor(color);
                break;
            case 'L': findViewById(R.id.letraL).setBackgroundColor(color);
                break;
            case 'M': findViewById(R.id.letraM).setBackgroundColor(color);
                break;
            case 'N': findViewById(R.id.letraN).setBackgroundColor(color);
                break;
            case 'Ñ': findViewById(R.id.letraÑ).setBackgroundColor(color);
                break;
            case 'O': findViewById(R.id.letraO).setBackgroundColor(color);
                break;
            case 'P': findViewById(R.id.letraP).setBackgroundColor(color);
                break;
            case 'Q': findViewById(R.id.letraQ).setBackgroundColor(color);
                break;
            case 'R': findViewById(R.id.letraR).setBackgroundColor(color);
                break;
            case 'S': findViewById(R.id.letraS).setBackgroundColor(color);
                break;
            case 'T': findViewById(R.id.letraT).setBackgroundColor(color);
                break;
            case 'U': findViewById(R.id.letraU).setBackgroundColor(color);
                break;
            case 'V': findViewById(R.id.letraV).setBackgroundColor(color);
                break;
            case 'W': findViewById(R.id.letraW).setBackgroundColor(color);
                break;
            case 'X': findViewById(R.id.letraX).setBackgroundColor(color);
                break;
            case 'Y': findViewById(R.id.letraY).setBackgroundColor(color);
                break;
            case 'Z': findViewById(R.id.letraZ).setBackgroundColor(color);
                break;
        }
    }
}