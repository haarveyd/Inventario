package com.example.inventario;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);


        Button editarButton = view.findViewById(R.id.button_editar);


        editarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en "Editar", abre el fragmento de edición
                EditFragment editFragment = new EditFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, editFragment);
                transaction.addToBackStack(null); // Agrega a la pila de retroceso
                transaction.commit();
            }
        });

        return view;
    }
}
