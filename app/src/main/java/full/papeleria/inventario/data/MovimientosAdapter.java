package full.papeleria.inventario.data;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import full.papeleria.inventario.R;

public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    private Cursor cursorListaMovimientos;
    private MovimientosAdapter.OnItemClickListener listenerClickpro;

    public  MovimientosAdapter(MovimientosAdapter.OnItemClickListener listenerClick) {
        this.listenerClickpro = listenerClick;
    }
    public interface OnItemClickListener{
        public void onClick(MovimientosAdapter.ViewHolder view, Movimientos MovimientosActualizado);


    }

    @NonNull
    @Override
    public MovimientosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_historial_item,parent,false );
        return new MovimientosAdapter.ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientosAdapter.ViewHolder holder, int position) {
        cursorListaMovimientos.moveToPosition(position);
        Movimientos MovimientosSeleccionado = new Movimientos( cursorListaMovimientos );
        holder.Nombreuser.setText(MovimientosSeleccionado.getNOM_usuario().toString());
        holder.nombreprod.setText((MovimientosSeleccionado.getNOMproducto().toString()));
        holder.accionuser.setText(MovimientosSeleccionado.getAccion());
        holder.canprod.setText(Integer.toString(MovimientosSeleccionado.getCantidad()));
    }

    @Override
    public int getItemCount() {
        if (cursorListaMovimientos!=null)
            return cursorListaMovimientos.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaMovimientos = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Nombreuser;
        TextView accionuser;

        TextView nombreprod;

        TextView canprod;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            Nombreuser = (TextView) itemView.findViewById( R.id.nombre_per );
            accionuser = (TextView) itemView.findViewById( R.id.accion_per );
            nombreprod = (TextView) itemView.findViewById( R.id.nombre_prod );
            canprod= (TextView) itemView.findViewById( R.id.cantidad_prod );
        }

        @Override
        public void onClick(View v) {
            Movimientos MovimientosActualizado = obtenerMovimientos( getAdapterPosition() );
            listenerClickpro.onClick( this,MovimientosActualizado );

        }
    }

    private Movimientos obtenerMovimientos(int posicion){
        if (cursorListaMovimientos!=null){
            cursorListaMovimientos.moveToPosition( posicion );
            Movimientos nuevoMovimientos = new Movimientos( cursorListaMovimientos );
            return nuevoMovimientos;
        }
        return null;
    }
}
