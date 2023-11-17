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

import com.example.inventario.R;

import full.papeleria.inventario.data.InventarioDBHelper;
import full.papeleria.inventario.data.Productos;
import full.papeleria.inventario.data.ProductosAdapter;
import full.papeleria.inventario.data.ProductosContract;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFragment extends Fragment {
    private RecyclerView listaUsuarios;
    private InventarioDBHelper bdInventario;
    private LinearLayoutManager linearLayoutManager;
    private ProductosAdapter adaptadorProducto;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
                
    }

    EditText salidas, idproducto;
    Button eliminar;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        idproducto= getView().findViewById(R.id.editTextProductID);
        listaUsuarios = (RecyclerView) getView().findViewById(R.id.recyclerListaProductos);
        bdInventario = new InventarioDBHelper(getContext());
        salidas= getView().findViewById(R.id.editTextCounter);

        eliminar = getView().findViewById(R.id.buttonDelete);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor idconsultado = bdInventario.getProductoById(idproducto.getText().toString());
                if (idconsultado.moveToFirst()){
                    int stockint = Integer.parseInt(salidas.getText().toString());
                    int stockIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.STOCK);
                    int nameIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.NAMEPROD);
                    int valorIndex = idconsultado.getColumnIndex(ProductosContract.ProductosEntry.VALOR);

                    // Verifica que los índices sean válidos antes de acceder a los datos
                    if (stockIndex != -1 && nameIndex != -1 && valorIndex != -1) {
                        int stock = idconsultado.getInt(stockIndex);
                        String nombre = idconsultado.getString(nameIndex);
                        int valor = idconsultado.getInt(valorIndex);

                        int newstock = stock - stockint;

                        // Crear un objeto Productos con los datos actualizados
                        Productos productostockact = new Productos(Integer.parseInt(idproducto.getText().toString()), nombre, newstock, stockint, valor);

                        // Actualizar el producto en la base de datos
                        bdInventario.updateProducto(productostockact, idproducto.getText().toString());
                    }


                }

            }
        });
    }
}