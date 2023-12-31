package full.papeleria.inventario;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import full.papeleria.inventario.R;
import full.papeleria.inventario.data.InventarioDBHelper;
import full.papeleria.inventario.data.Productos;
import full.papeleria.inventario.data.ProductosAdapter;

public class TableFragment extends Fragment implements ProductosAdapter.OnItemClickListener {

    private RecyclerView listaUsuarios;
    private InventarioDBHelper bdInventario;
    private LinearLayoutManager linearLayoutManager;
    private ProductosAdapter adaptadorProducto;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Button output;

    public TableFragment() {

    }

    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
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
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    Bundle bundle = new Bundle();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        output = getView().findViewById(R.id.buttonEditar);
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.editFragment);
            }
        });

        listaUsuarios = (RecyclerView) getView().findViewById(R.id.recyclerListaProductos);
        bdInventario = new InventarioDBHelper(getContext());

        listaUsuarios.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext());
        listaUsuarios.setLayoutManager(linearLayoutManager);
        adaptadorProducto = new ProductosAdapter(this);
        listaUsuarios.setAdapter(adaptadorProducto);
        loadProductos();
    }

    @Override
    public void onClick(ProductosAdapter.ViewHolder view, Productos productoActualizado) {

        bdInventario.updateProducto(productoActualizado, String.valueOf(productoActualizado.getCodigo()));
        loadProductos();

    }


    private void loadProductos() {
        new ProductosLoaderTask().execute();
    }

    private class ProductosLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return bdInventario.getAllProductos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptadorProducto.swapCursor(cursor);
            }
        }
    }
}