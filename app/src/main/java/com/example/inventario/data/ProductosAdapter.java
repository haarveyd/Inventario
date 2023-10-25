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
    private OnItemClickListener listenerClick;

    public ProductosAdapter(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, Productos productoctualizado);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.fragment_product,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cursorListaProductos.moveToPosition(position);
        Productos productoSeleccionado = new Productos( cursorListaProductos );
        holder.productList.setText(productoSeleccionado.getnomProducto().toString());
        holder.stockList.setText(Integer.toString(productoSeleccionado.getStock()));
        holder.valueList.setText(Float.toString(productoSeleccionado.getValorUnitario()));
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

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            productList = (TextView) itemView.findViewById( R.id.nombre_lista );
            stockList = (TextView) itemView.findViewById( R.id.stock_lista );
            valueList = (TextView) itemView.findViewById( R.id.valor_lista );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            Productos productoActualizado = obtenerProducto( getAdapterPosition() );
            productoActualizado.setnomProducto( "placeHolder" );
            listenerClick.onClick( this,productoActualizado );

        }
    }

    private Productos obtenerProducto(int posicion){
        if (cursorListaProductos!=null){
            cursorListaProductos.moveToPosition( posicion );
            Productos nuevoUsuario = new Productos( cursorListaProductos );
            return nuevoUsuario;
        }
        return null;
    }
}
