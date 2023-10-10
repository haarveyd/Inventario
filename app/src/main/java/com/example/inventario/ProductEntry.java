package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ProductEntry extends AppCompatActivity {
    TextView textoregistrar;
    Spinner categoria;

    private RadioGroup radioGroup;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productentry);

        textoregistrar=(TextView)findViewById(R.id.texto_registrar);

        textoregistrar = (TextView) findViewById(R.id.texto_registrar);


        radioGroup = findViewById(R.id.radioGroup);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if (radioButton != null) {
                    String opcionSeleccionada = radioButton.getText().toString();
                    resultadoTextView.setText("Category/Categoria: " + opcionSeleccionada);
                }
            }


        });




    }
    public void cambiarColorTexto1(View v){
        textoregistrar.setTextColor(Color.GREEN);
        textoregistrar.setText("REGISTRATION SUCCESFULL/ REGISTRO EXITOSO");


    }


    }











