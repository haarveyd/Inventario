package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;



public class ProductOutput extends AppCompatActivity {
    private CheckBox checkBoxBarcode;
    private CheckBox checkBoxNombreProducto;
    private TextView textViewCodigoBarras;
    private EditText editTextCodigoBarras;
    private TextView textViewNombreProducto;
    private EditText editTextNombreProducto;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_output);

        checkBoxBarcode = findViewById(R.id.checkBoxBarcode);
        checkBoxNombreProducto = findViewById(R.id.checkBoxNombreProducto);
        textViewCodigoBarras = findViewById(R.id.textViewCodigoBarras);
        editTextCodigoBarras = findViewById(R.id.editTextCodigoBarras);
        textViewNombreProducto = findViewById(R.id.textViewNombreProducto);
        editTextNombreProducto = findViewById(R.id.editTextNombreProducto);
        btnGuardar = findViewById(R.id.btnGuardar);

        checkBoxBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxBarcode.isChecked()) {
                    textViewCodigoBarras.setVisibility(View.VISIBLE);
                    editTextCodigoBarras.setVisibility(View.VISIBLE);
                } else {
                    textViewCodigoBarras.setVisibility(View.GONE);
                    editTextCodigoBarras.setVisibility(View.GONE);
                }
            }
        });

        checkBoxNombreProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxNombreProducto.isChecked()) {
                    textViewNombreProducto.setVisibility(View.VISIBLE);
                    editTextNombreProducto.setVisibility(View.VISIBLE);
                } else {
                    textViewNombreProducto.setVisibility(View.GONE);
                    editTextNombreProducto.setVisibility(View.GONE);
                }
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agrega aquí la lógica para guardar la información ingresada.
            }
        });


    }
}