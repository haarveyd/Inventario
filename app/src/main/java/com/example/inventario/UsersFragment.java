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
import android.widget.Button;
import android.widget.ImageButton;

import com.example.inventario.data.InventarioDBHelper;
import com.example.inventario.data.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsersFragment extends Fragment implements UsuarioAdapter.OnItemClickListener{
    private RecyclerView listaPersonas;
    private InventarioDBHelper baseDatos;
    private LinearLayoutManager linearLayoutManager;
    private UsuarioAdapter usuariosAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UsersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsersFragment newInstance(String param1, String param2) {
        UsersFragment fragment = new UsersFragment();
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
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
    private ImageButton homee;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        homee = (ImageButton) getView().findViewById(R.id.btn_home);
        homee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.inventoryFragment, new Bundle());

            }
        });

        listaPersonas =(RecyclerView)getView().findViewById(R.id.listaUsuarios);
        baseDatos = new InventarioDBHelper( getContext() );

        listaPersonas.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( getContext() );
        listaPersonas.setLayoutManager( linearLayoutManager );
        usuariosAdapter = new UsuarioAdapter(this);
        listaPersonas.setAdapter( usuariosAdapter );
        loadUsuario();


    }
    @Override
    public void onClick(UsuarioAdapter.ViewHolder view, Usuario usuarioactualizado) {
        baseDatos.updateUsuario(usuarioactualizado,String.valueOf(usuarioactualizado.getCodigo()));
        loadUsuario();
    }

    private void loadUsuario() {new UsuarioLoaderTask().execute( );}
    private class UsuarioLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return baseDatos.getAllUsuarios();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                usuariosAdapter.swapCursor( cursor );
            }
        }
    }
}