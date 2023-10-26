package com.example.inventario;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inventario.data.InventarioDBHelper;
import com.example.inventario.data.Productos;
import com.example.inventario.data.Usuario;
import com.example.inventario.data.Movimientos;


public class EditFragment extends Fragment {

    Button buttonDecrease, buttonIncrease;
    EditText editTextCounter;
    int currentStock = 0;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public EditFragment() {
        // Required empty public constructor
    }

    public static EditFragment newInstance(String param1, String param2) {
        EditFragment fragment = new EditFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        EditText editTextProductID = view.findViewById(R.id.editTextProductID);
        Button buttonSave = view.findViewById(R.id.buttonSave);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        editTextCounter.setText(String.valueOf(currentStock));

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentStock = Integer.parseInt(editTextCounter.getText().toString());
                if (currentStock > 0) {
                    currentStock--;
                    editTextCounter.setText(String.valueOf(currentStock));
                }
            }
        });

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentStock = Integer.parseInt(editTextCounter.getText().toString());
                currentStock++;
                editTextCounter.setText(String.valueOf(currentStock));
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productID = editTextProductID.getText().toString();

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productID = editTextProductID.getText().toString();
            }
        });

        return view;
    }
}
