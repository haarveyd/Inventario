package full.papeleria.inventario;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import full.papeleria.inventario.data.InventarioDBHelper;
import full.papeleria.inventario.data.Productos;
import full.papeleria.inventario.data.ProductosAdapter;
import full.papeleria.inventario.data.ProductosContract;

public class EditFragment extends Fragment {
    private RecyclerView listaUsuarios;
    private InventarioDBHelper bdInventario;
    private LinearLayoutManager linearLayoutManager;
    private ProductosAdapter adaptadorProducto;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public EditFragment() {

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
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    EditText salidas, idproducto;
    Button eliminar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        idproducto = getView().findViewById(R.id.editTextProductID);
        listaUsuarios = (RecyclerView) getView().findViewById(R.id.recyclerListaProductos);
        bdInventario = new InventarioDBHelper(getContext());
        salidas = getView().findViewById(R.id.editTextCounter);

        eliminar = getView().findViewById(R.id.buttonDelete);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor idconsultado = bdInventario.getProductoById(idproducto.getText().toString());
                if (idconsultado.moveToFirst()) {
                    int stockint = Integer.parseInt(salidas.getText().toString());
                    int stockIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.STOCK);
                    int nameIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.NAMEPROD);
                    int valorIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.VALOR);


                    if (stockIndex != -1 && nameIndex != -1 && valorIndex != -1) {
                        int stock = idconsultado.getInt(stockIndex);
                        String nombre = idconsultado.getString(nameIndex);
                        int valor = idconsultado.getInt(valorIndex);
                        int newstock = stock - stockint;
                        Productos productostockact = new Productos(Integer.parseInt(idproducto.getText().toString()), nombre, newstock, stockint, valor);
                        bdInventario.updateProducto(productostockact, idproducto.getText().toString());
                    }


                }

            }
        });
    }
}