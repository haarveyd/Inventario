package com.example.inventario;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductEntryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductEntryFragment extends Fragment {
    TextView textoregistrar;
    Spinner categoria;

    private RadioGroup radioGroup;
    private TextView resultadoTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductEntryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductEntryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductEntryFragment newInstance(String param1, String param2) {
        ProductEntryFragment fragment = new ProductEntryFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productentry, container, false);

        textoregistrar = view.findViewById(R.id.texto_registrar);
        radioGroup = view.findViewById(R.id.radioGroup);
        resultadoTextView = view.findViewById(R.id.resultadoTextView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = view.findViewById(checkedId);
                if (radioButton != null) {
                    String opcionSeleccionada = radioButton.getText().toString();
                    resultadoTextView.setText("Category/Categoria: " + opcionSeleccionada);
                }
            }
        });

        return view;
    }
    public void cambiarColorTexto1() {
        textoregistrar.setTextColor(Color.GREEN);
        textoregistrar.setText("REGISTRATION SUCCESSFUL/ REGISTRO EXITOSO");
    }
}