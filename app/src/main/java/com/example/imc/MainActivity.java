package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textNome, textPeso, textAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = findViewById(R.id.textNome);
        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
    }

    public void calculaIMC(View v) {
        Intent i = new Intent(this, ImcActivity.class);
        String nome = textNome.getText().toString();
        Double peso = Double.parseDouble(textPeso.getText().toString());  //pega o texto transforma em string e depois em double
        Double altura = Double.parseDouble(textAltura.getText().toString());

        i.putExtra("nome", nome); //cria um pacote e nomeia
        i.putExtra("peso", peso);
        i.putExtra("altura", altura);

        startActivity(i);

    }
}