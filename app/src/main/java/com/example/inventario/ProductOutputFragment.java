package com.example.inventario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductOutputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductOutputFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductOutputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductOutputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductOutputFragment newInstance(String param1, String param2) {
        ProductOutputFragment fragment = new ProductOutputFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private CheckBox checkBoxBarcode;
    private CheckBox checkBoxNombreProducto;
    private TextView textViewCodigoBarras;
    private EditText editTextCodigoBarras;
    private TextView textViewNombreProducto;
    private EditText editTextNombreProducto;
    private Button btnGuardar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_productoutput, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkBoxBarcode = view.findViewById(R.id.checkBoxBarcode);
        checkBoxNombreProducto = view.findViewById(R.id.checkBoxNombreProducto);
        textViewCodigoBarras = view.findViewById(R.id.textViewCodigoBarras);
        editTextCodigoBarras = view.findViewById(R.id.editTextCodigoBarras);
        textViewNombreProducto = view.findViewById(R.id.textViewNombreProducto);
        editTextNombreProducto = view.findViewById(R.id.editTextNombreProducto);
        btnGuardar = view.findViewById(R.id.btnGuardar);

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