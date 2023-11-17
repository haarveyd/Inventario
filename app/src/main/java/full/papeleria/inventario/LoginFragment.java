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
import android.widget.TextView;
import android.widget.Toast;

import full.papeleria.inventario.R;
import full.papeleria.inventario.data.InventarioDBHelper;

public class LoginFragment extends Fragment {
    Bundle bundle = new Bundle();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public LoginFragment() {

    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

    private EditText user, password;
    private TextView nombre;

    private Button registro, login;

    private InventarioDBHelper baseDatos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = (EditText) getView().findViewById(R.id.input_user);
        password = (EditText) getView().findViewById(R.id.Password);
        registro = (Button) getView().findViewById(R.id.registro);
        login = (Button) getView().findViewById(R.id.RegistroUsuario);

        baseDatos = new InventarioDBHelper(getContext());
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.registerFragment);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor usuarioConsultado = baseDatos.getUsuarioByUserPassword(user.getText().toString(), password.getText().toString());
                if (usuarioConsultado.moveToFirst()) {
                    bundle.putString("usuario", user.getText().toString());
                    Navigation.findNavController(view).navigate(R.id.inventoryFragment, bundle);
                } else {
                    Toast.makeText(getActivity(), "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}