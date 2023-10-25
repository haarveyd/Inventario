package com.example.inventario;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventario.data.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {

    private Cursor cursorListaUsuarios;
    private OnItemClickListener listenerClick;
    public  UsuarioAdapter(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, Usuario usuarioactualizado);
    }

    @NonNull
    @Override
    public UsuarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_user_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.ViewHolder holder, int position) {
        if (cursorListaUsuarios != null && cursorListaUsuarios.moveToPosition(position)) {
            Usuario UsuarioSeleccionado = new Usuario(cursorListaUsuarios);
            holder.IdU.setText(String.valueOf(UsuarioSeleccionado.getCodigo()));
            holder.nombre.setText(UsuarioSeleccionado.getNomUsuario());
            holder.apellido.setText(UsuarioSeleccionado.getApUsuario());
            holder.user.setText(UsuarioSeleccionado.getUser());
        }
    }

    @Override
    public int getItemCount() {
        if (cursorListaUsuarios != null)
            return cursorListaUsuarios.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaUsuarios = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView IdU;
        TextView nombre;
        TextView apellido;
        TextView user;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            IdU = (TextView) itemView.findViewById( R.id.txt_id );
            nombre = (TextView) itemView.findViewById( R.id.txt_nombre );
            apellido = (TextView) itemView.findViewById( R.id.txt_apellido );
            user = (TextView) itemView.findViewById( R.id.txt_user );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View view) {

        }
    }


    private Usuario obtenerUsuario(int posicion){
        if (cursorListaUsuarios!=null){
            cursorListaUsuarios.moveToPosition( posicion );
            Usuario nuevoUsuario = new Usuario( cursorListaUsuarios );
            return nuevoUsuario;
        }
        return null;
    }
}
