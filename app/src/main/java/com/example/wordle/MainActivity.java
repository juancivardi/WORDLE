package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int casillaActual = 0;
    private int ultimaCasilla = 29; // En el arreglo se indexa de 0 a 29
    private boolean juegoTerminado = false;
    private ArrayList<TextView> textViews = new ArrayList<TextView>();
    private String palabraEscondida = "FUEGO";
    private String palabraIngresada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews.add(findViewById(R.id.casilla1));
        textViews.add(findViewById(R.id.casilla2));
        textViews.add(findViewById(R.id.casilla3));
        textViews.add(findViewById(R.id.casilla4));
        textViews.add(findViewById(R.id.casilla5));
        textViews.add(findViewById(R.id.casilla6));
        textViews.add(findViewById(R.id.casilla7));
        textViews.add(findViewById(R.id.casilla8));
        textViews.add(findViewById(R.id.casilla9));
        textViews.add(findViewById(R.id.casilla10));
        textViews.add(findViewById(R.id.casilla11));
        textViews.add(findViewById(R.id.casilla12));
        textViews.add(findViewById(R.id.casilla13));
        textViews.add(findViewById(R.id.casilla14));
        textViews.add(findViewById(R.id.casilla15));
        textViews.add(findViewById(R.id.casilla16));
        textViews.add(findViewById(R.id.casilla17));
        textViews.add(findViewById(R.id.casilla18));
        textViews.add(findViewById(R.id.casilla19));
        textViews.add(findViewById(R.id.casilla20));
        textViews.add(findViewById(R.id.casilla21));
        textViews.add(findViewById(R.id.casilla22));
        textViews.add(findViewById(R.id.casilla23));
        textViews.add(findViewById(R.id.casilla24));
        textViews.add(findViewById(R.id.casilla25));
        textViews.add(findViewById(R.id.casilla26));
        textViews.add(findViewById(R.id.casilla27));
        textViews.add(findViewById(R.id.casilla28));
        textViews.add(findViewById(R.id.casilla29));
        textViews.add(findViewById(R.id.casilla30));
    }

    public void enviarLetra(View v){
        Button boton = (Button)v;
        String texto = boton.getText().toString();
        System.out.println(casillaActual);
        if(!juegoTerminado && textViews.get(casillaActual).getText() == ""){
            // Si la casilla actual está vacia (esto es porque si no cuando estaba en la ultima se cambiaba por la ultima apretada)
            palabraIngresada = palabraIngresada + texto; // Se agrega la ultima letra ingresada a la palagra ingresada.
            textViews.get(casillaActual).setText(texto); // Se muestra la letra en la casilla que corresponda.
            if ((casillaActual+1) % 5 != 0)
                // Si la casilla no es la última de la fila entonces se avanza sobre la fila, caso contrario se avanza de fila si se presiona enviar.
                casillaActual++;
        } else if (juegoTerminado){
            Toast.makeText(this, "Juego terminado.", Toast.LENGTH_SHORT).show();
        }
    }

    public void borrarLetra(View v){
        if (!juegoTerminado && palabraIngresada != "") {
            if (textViews.get(casillaActual).getText() == "") {
                // Esta condicion solo no se cumple en el caso en el que el puntero este en la ultima casilla de la fila y no este vacia.
                // Esto para que en ese caso, solo se borre la letra de esa casilla y no se retroceda el puntero
                if (casillaActual % 5 != 0) {
                    // Si el puntero no esta en la ultima casilla (podria estar ahi sin ninguna letra)
                    // y esta sobre una casilla vacia entonces se vuelve una casilla atrás para borrar esa letra
                    casillaActual--;
                }
                if (palabraIngresada.length() > 0)
                    palabraIngresada = palabraIngresada.substring(0, palabraIngresada.length() - 1);
                // Si la palabra ingresada tiene al menos una letra entonces se borra la última.
                textViews.get(casillaActual).setText("");
                // se borra la letra de la casilla.s
            } else {
                // Si el puntero estaba en la ultima casilla de la fila y estaba vacia entonces solo se borra esa letra y el puntero se mantiene ahí
                palabraIngresada = palabraIngresada.substring(0, palabraIngresada.length() - 1);
                textViews.get(casillaActual).setText("");
            }
        }
    }

    public void comprobarPalabra(View v){
        if (!juegoTerminado) {
            if (textViews.get(casillaActual).getText() != "") { // Si no hay ni una casilla vacia entonces la palabra esta completa
                if (palabraIngresada.equals(palabraEscondida.toUpperCase(Locale.ROOT))) {
                    Toast.makeText(this, "Palabra encontrada!", Toast.LENGTH_SHORT).show();
                    juegoTerminado = true;
                }
                palabraIngresada = ""; // Si no era igual la palabra entonces se reinicia la palabra ingresada
                if (casillaActual < ultimaCasilla) casillaActual++; // y se pasa a procesar la proxima filas
            } else {
                Toast.makeText(this, "Complete la palabra para enviarla", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Juego terminado.", Toast.LENGTH_SHORT).show();
        }
    }
}