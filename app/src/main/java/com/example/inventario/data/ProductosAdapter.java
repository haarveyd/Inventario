package com.example.inventario.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventario.R;
import com.example.inventario.data.Productos;

import java.util.List;

public class ProductosAdapter extends ArrayAdapter<Productos> {
    public ProductosAdapter(Context context, List<Productos> objects){
        super(context,0,objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        //Existe el view actual?
        if (null == convertView){
            convertView = inflater.inflate(
                    R.layout.fragment_table,
                    parent,
                    false
            );
        }

        TextView nameList = (TextView) convertView.findViewById( R.id.nombre_lista );
        TextView stockList = (TextView) convertView.findViewById( R.id.stock_lista );
        TextView valueList = (TextView) convertView.findViewById( R.id.valor_lista );

        Productos productoActual = getItem( position );

        nameList.setText(productoActual.getnomProducto());
        stockList.setText(Integer.toString(productoActual.getStock()));
        valueList.setText(Float.toString(productoActual.getValorUnitario()) );


        return convertView;
    }

}
