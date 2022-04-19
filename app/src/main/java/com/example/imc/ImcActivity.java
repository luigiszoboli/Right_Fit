package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String nome;
    Double peso, altura, imc;
    TextView tvNome, tvPeso, tvAltura, tvImc;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
        ImageView bosojaro = findViewById(R.id.imageView);
        imc = calculaIMC(peso, altura);
        if(imc < 18.5) {
            bosojaro.setImageResource(R.drawable.abaixopeso);
        }else if(imc < 24.9) {
            bosojaro.setImageResource(R.drawable.normal);
        }else if(imc < 29){
            bosojaro.setImageResource(R.drawable.sobrepeso);
        }else if(imc < 34.9){
            bosojaro.setImageResource(R.drawable.obesidade1);
        }else if (imc < 39.9){
            bosojaro.setImageResource(R.drawable.obesidade2);
        }else {
            bosojaro.setImageResource(R.drawable.obesidade3);

        }


    }

    @Override
    protected  void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvImc.setText(decimalFormat.format(imc));

    }

    public Double calculaIMC (Double peso, Double altura) {
        Double imc = peso / (altura * altura);
        return imc;

    }


}
