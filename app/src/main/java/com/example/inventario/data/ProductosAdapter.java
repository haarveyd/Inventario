package com.example.inventario.data;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventario.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {


    private Cursor cursorListaProductos;
    private OnItemClickListener listenerClickpro;

    public  ProductosAdapter(OnItemClickListener listenerClick) {
        this.listenerClickpro = listenerClick;
    }
    public interface OnItemClickListener{
        public void onClick(ViewHolder view, Productos productoActualizado);


    }

    @NonNull
    @Override
    public ProductosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_product_item,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosAdapter.ViewHolder holder, int position) {
        cursorListaProductos.moveToPosition(position);
        Productos productoSeleccionado = new Productos( cursorListaProductos );
        holder.productList.setText(productoSeleccionado.getnomProducto().toString());
        holder.stockList.setText(Integer.toString(productoSeleccionado.getStock()));
        holder.valueList.setText(Integer.toString(productoSeleccionado.getValorUnitario()));
        //holder.exitList.setText(Integer.toString(productoSeleccionado.getSalidas()));
    }

    @Override
    public int getItemCount() {
        if (cursorListaProductos!=null)
            return cursorListaProductos.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaProductos = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productList;
        TextView stockList;

        TextView valueList;

        TextView exitList;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            productList = (TextView) itemView.findViewById( R.id.nombre_lista );
            stockList = (TextView) itemView.findViewById( R.id.campoStock );
            valueList = (TextView) itemView.findViewById( R.id.campoValor );
            //exitList= (TextView) itemView.findViewById( R.id.campoSalida );
        }

        @Override
        public void onClick(View v) {
            Productos productoActualizado = obtenerProducto( getAdapterPosition() );
            productoActualizado.setnomProducto( "placeHolder" );
            listenerClickpro.onClick( this,productoActualizado );

        }
    }

    private Productos obtenerProducto(int posicion){
        if (cursorListaProductos!=null){
            cursorListaProductos.moveToPosition( posicion );
            Productos nuevoProducto = new Productos( cursorListaProductos );
            return nuevoProducto;
        }
        return null;
    }
}
