package com.example.inventario;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class SalesFragment extends Fragment {

    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private SharedPreferences sharedPreferences;

    public SalesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getContentView(R.layout.fragment_sales);

        editText = getView.findViewById(R.id.editText);
        listView = findViewById(R.id.listView);

        sharedPreferences = getSharedPreferences("HistorialPrefs", Context.MODE_PRIVATE);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }



    public void guardarEnHistorial(View view) {
        String nuevoTexto = editText.getText().toString().trim();

        if (!nuevoTexto.isEmpty()) {

            String historialActual = sharedPreferences.getString("historial", "");


            String nuevoHistorial = historialActual + "\n" + nuevoTexto;


            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("historial", nuevoHistorial);
            editor.apply();


            adapter.add(nuevoTexto);
            editText.setText("");
        }
    }
    private void cargarYMostrarHistorial() {
        String historial = sharedPreferences.getString("historial", "");
        String[] historialArray = historial.split("\n");
        adapter.clear();
        adapter.addAll(historialArray);
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarYMostrarHistorial();
    }
}
