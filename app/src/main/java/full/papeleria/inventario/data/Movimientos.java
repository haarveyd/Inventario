package full.papeleria.inventario.data;

import android.content.ContentValues;
import android.database.Cursor;

public class Movimientos {
        private int id_mov;
        private String NOMusuario;
        private String NOMproducto;
        private String accion;
        private int cantidad;

        public Movimientos(int id_mov, String nomUsuario, String nomProducto, String accion, int cantidad) {
            this.id_mov = id_mov;
            this.NOMusuario = nomUsuario;
            this.NOMproducto = nomProducto;
            this.accion = accion;
            this.cantidad = cantidad;
        }

        public Movimientos(Cursor cursor) {
            id_mov= cursor.getInt(cursor.getColumnIndex(MovimientosContract.MovimientosEntry.IDMOV));
            NOMusuario= cursor.getString(cursor.getColumnIndex(MovimientosContract.MovimientosEntry.NOMUSER));
            NOMproducto= cursor.getString(cursor.getColumnIndex(MovimientosContract.MovimientosEntry.NOMPROD));
            accion= cursor.getString(cursor.getColumnIndex(MovimientosContract.MovimientosEntry.ACTION));
            cantidad= cursor.getInt(cursor.getColumnIndex(MovimientosContract.MovimientosEntry.QUANTITY));
        }
        public ContentValues toContentValues(){
            ContentValues Values = new ContentValues();
            Values.put(MovimientosContract.MovimientosEntry.IDMOV, id_mov);
            Values.put(MovimientosContract.MovimientosEntry.NOMUSER, NOMusuario);
            Values.put(MovimientosContract.MovimientosEntry.NOMPROD, NOMproducto);
            Values.put(MovimientosContract.MovimientosEntry.ACTION, accion);
            Values.put(MovimientosContract.MovimientosEntry.QUANTITY, cantidad);

            return Values;
        }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public String getNOM_usuario() {
        return NOMusuario;
    }

    public void setNOMusuario(String nomusuario) {
        this.NOMusuario = nomusuario;
    }

    public String getNOMproducto() {
        return NOMproducto;
    }

    public void setNOMproducto(String nomproducto) {
        this.NOMproducto = nomproducto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
