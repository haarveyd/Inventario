package full.papeleria.inventario;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventario.R;

import full.papeleria.inventario.R;


public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_product_item, container, false);

        /*Button editarButton = view.findViewById(R.id.button_editar);

        editarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int productId = 1;

                InventarioDBHelper dbHelper = new InventarioDBHelper(getActivity());
                Productos product = dbHelper.getProductById(productId);

                EditFragment editProductFragment = new EditFragment();
                Bundle args = new Bundle();
                args.putInt("productID", product.getCodigo());
                editProductFragment.setArguments(args);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, editProductFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
*/
        return view;
    }

}
