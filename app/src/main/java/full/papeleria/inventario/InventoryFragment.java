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
import android.widget.TextView;

import com.example.inventario.R;

import full.papeleria.inventario.R;

import full.papeleria.inventario.data.InventarioDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InventoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InventoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InventoryFragment() {
        // Required empty public constructor
    }


    TextView nombre_intro;
    Button entrada, user, inventario, historial;

    Bundle bundle = new Bundle();
    InventarioDBHelper database;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InventoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InventoryFragment newInstance(String param1, String param2) {
        InventoryFragment fragment = new InventoryFragment();
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
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //declaracion de variables
        nombre_intro= getView().findViewById(R.id.User_nameIntro);
        entrada = getView().findViewById(R.id.Entrada_prod);
        user= getView().findViewById(R.id.usuarios_list);
        inventario= getView().findViewById(R.id.inventario_prod);
        historial= getView().findViewById(R.id.historial_mov);

        database = new InventarioDBHelper(getContext());
        Bundle args = getArguments();
        if (args != null) {
            String UserName = args.getString("usuario");
            if (UserName != null) {
                //recibo datos de login
                UserName = getArguments().getString("usuario");
                //cursor para obtener el usuario y posicion de columna
                Cursor obtenerUsuario = database.getUsuarioByUser(UserName);
                int columnIndexNOM = obtenerUsuario.getColumnIndex("nomUsuario");
                int columnIndexAP = obtenerUsuario.getColumnIndex("apUsuario");
                if (columnIndexNOM != -1 && columnIndexAP != -1 && obtenerUsuario.moveToFirst()) {
                    String Nombre = obtenerUsuario.getString(columnIndexNOM);
                    String apellido = obtenerUsuario.getString(columnIndexAP);
                    nombre_intro.setText(Nombre + " " + apellido);
                    entrada.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            bundle.putString("usuario2",Nombre+" "+apellido );
                            Navigation.findNavController(view).navigate(R.id.productEntryFragment,bundle);
                        }
                    });
                }
            }
        }


        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.usersFragment);
            }
        });

        inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.tableFragment);
            }
        });


        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.fragment_listaHistorial);
            }
        });


    }


}