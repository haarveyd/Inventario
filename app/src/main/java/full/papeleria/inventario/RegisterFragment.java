package full.papeleria.inventario;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import full.papeleria.inventario.R;
import full.papeleria.inventario.data.InventarioDBHelper;
import full.papeleria.inventario.data.Usuario;


public class RegisterFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {

    }

    private EditText nombre, apellido, NomUsuario, nuevaContrase;
    private Button Registro;
    private InventarioDBHelper basedatos;


    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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

        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nombre = (EditText) getView().findViewById(R.id.primerNombre);
        apellido = (EditText) getView().findViewById(R.id.Apellido);
        NomUsuario = (EditText) getView().findViewById(R.id.NombreUsuario);
        nuevaContrase = (EditText) getView().findViewById(R.id.Password);
        Registro = (Button) getView().findViewById(R.id.RegistroUsuario);

        basedatos = new InventarioDBHelper(getContext());
        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = nombre.getText().toString();
                String Apellido = apellido.getText().toString();
                String UsuarioUnico = NomUsuario.getText().toString();
                int Password = Integer.parseInt(nuevaContrase.getText().toString());
                int idRandom = (int) (Math.random() * 1000) + 1;
                Cursor usuarioConsultadoID = basedatos.getUsuarioById(Integer.toString(idRandom));
                Cursor usuarioConsultadoUSER = basedatos.getUsuarioByUser(UsuarioUnico);

                while (usuarioConsultadoID.moveToFirst()) {
                    idRandom = (int) (Math.random() * 1000) + 1;
                    usuarioConsultadoID = basedatos.getUsuarioById(Integer.toString(idRandom));
                }

                if (usuarioConsultadoUSER.moveToFirst()) {
                    Toast.makeText(getActivity(), "Ya existe ese nombre de usuario", Toast.LENGTH_LONG).show();
                } else {
                    Usuario nuevoUsuario = new Usuario(idRandom, Nombre, Apellido, UsuarioUnico, Password);
                    basedatos.saveUsuario(nuevoUsuario);
                    Navigation.findNavController(view).navigate(R.id.loginFragment);
                }
            }
        });
    }
}