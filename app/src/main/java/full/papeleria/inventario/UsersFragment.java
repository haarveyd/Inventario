package full.papeleria.inventario;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import full.papeleria.inventario.R;
import full.papeleria.inventario.data.InventarioDBHelper;
import full.papeleria.inventario.data.Usuario;

public class UsersFragment extends Fragment implements UsuarioAdapter.OnItemClickListener {
    private RecyclerView listaPersonas;
    private InventarioDBHelper baseDatos;
    private LinearLayoutManager linearLayoutManager;
    private UsuarioAdapter usuariosAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public UsersFragment() {

    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    Bundle bundle = new Bundle();
    private ImageButton homee;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        listaPersonas = (RecyclerView) getView().findViewById(R.id.listaUsuarios);
        baseDatos = new InventarioDBHelper(getContext());
        listaPersonas.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext());
        listaPersonas.setLayoutManager(linearLayoutManager);
        usuariosAdapter = new UsuarioAdapter(this);
        listaPersonas.setAdapter(usuariosAdapter);
        loadUsuario();
    }

    @Override
    public void onClick(UsuarioAdapter.ViewHolder view, Usuario usuarioactualizado) {
        baseDatos.updateUsuario(usuarioactualizado, String.valueOf(usuarioactualizado.getCodigo()));
        loadUsuario();
    }

    private void loadUsuario() {
        new UsuarioLoaderTask().execute();
    }

    private class UsuarioLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return baseDatos.getAllUsuarios();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                usuariosAdapter.swapCursor(cursor);
            }
        }
    }
}