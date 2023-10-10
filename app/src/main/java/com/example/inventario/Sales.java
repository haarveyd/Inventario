package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class Sales extends AppCompatActivity {

    private Switch switchSales;
    private TextView textAltas;
    private TextView textHighValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sales);

        switchSales = findViewById(R.id.switchSales);
        textAltas = findViewById(R.id.textAltas);
        textHighValue = findViewById(R.id.textHighValue);

        switchSales.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textAltas.setVisibility(View.VISIBLE);
                    textHighValue.setVisibility(View.VISIBLE);
                } else {
                    textAltas.setVisibility(View.GONE);
                    textHighValue.setVisibility(View.GONE);
                }
            }
        });
    }
}

