package com.example.inventario;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventario.data.InventarioDBHelper;
import com.example.inventario.data.Productos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductEntryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductEntryFragment extends Fragment {
    EditText NombreRegistro, CodigoRegistro, CantidadRegistro,ValorRegistro;

    InventarioDBHelper database;

    Button enviar;
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



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    NombreRegistro = getView().findViewById(R.id.input_usuario);
    CodigoRegistro = getView().findViewById(R.id.input_Code);
    CantidadRegistro = getView().findViewById(R.id.input_Quantity);
    ValorRegistro= getView().findViewById(R.id.input_value);
    database = new InventarioDBHelper(getContext());
    enviar= getView().findViewById(R.id.registrar);



    enviar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String nom=NombreRegistro.getText().toString();
            int cod=Integer.parseInt(CodigoRegistro.getText().toString());
            int cant=Integer.parseInt(CantidadRegistro.getText().toString());
            int valor=Integer.parseInt(ValorRegistro.getText().toString());
            Cursor productoConsultado = database.getProductoByNAMEId(CodigoRegistro.getText().toString(),NombreRegistro.getText().toString());
            Cursor productoConsultadoID = database.getProductoById(CodigoRegistro.getText().toString());
            Cursor productoConsultadoNAME = database.getProductoByName(CodigoRegistro.getText().toString());
            if(productoConsultado.moveToFirst()){
                Toast.makeText( getActivity(),"Ya existe ese ID y Nombre",Toast.LENGTH_LONG ).show();
            }
                else if(productoConsultadoID.moveToFirst()){
                        Toast.makeText( getActivity(),"Ya existe ese ID",Toast.LENGTH_LONG ).show();
                    } else if (productoConsultadoNAME.moveToFirst()){
                        Toast.makeText( getActivity(),"Ya existe ese NOMBRE",Toast.LENGTH_LONG ).show();
                    }
                else {
                Productos nuevoProducto = new Productos(cod,nom,cant,0,valor);
                database.saveProducto(nuevoProducto);
            }


        }
    });
    }

}