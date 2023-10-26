package com.example.inventario;

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

import com.example.inventario.data.InventarioDBHelper;
import com.example.inventario.data.Productos;
import com.example.inventario.data.ProductosAdapter;

public class TableFragment extends Fragment implements ProductosAdapter.OnItemClickListener {

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

    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaUsuarios = (RecyclerView) getView().findViewById( R.id.recyclerListaProductos );
        bdInventario = new InventarioDBHelper( getContext() );

        listaUsuarios.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( getContext() );
        listaUsuarios.setLayoutManager( linearLayoutManager );
        adaptadorProducto = new ProductosAdapter( this );
        listaUsuarios.setAdapter( adaptadorProducto );
        loadProductos();
    }


    @Override
    public void onClick(ProductosAdapter.ViewHolder view, Productos productoActualizado) {
        bdInventario.updateProducto(productoActualizado,String.valueOf(productoActualizado.getCodigo()));
        loadProductos();
    }

    private void loadProductos() {
        new ProductosLoaderTask().execute( );
    }

    private class ProductosLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return bdInventario.getAllProductos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptadorProducto.swapCursor( cursor );
            }
        }
    }
}