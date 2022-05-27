package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAJugar(View v){
        Intent i = new Intent(this,GameActivity.class);
        startActivity(i);
    }

    public void mostrarExplicacion(View v){
        Intent i = new Intent(this,ExplanationActivity.class);
        startActivity(i);
    }
}