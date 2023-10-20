package com.example.inventario.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.inventario.data.MovimientosContract.MovimientosEntry;
public class Movimientos {
        private int id_mov;
        private int id_usuario;
        private int id_producto;
        private int accion;
        private int cantidad;

        public Movimientos(int id_mov, int id_usuario, int id_producto, int accion, int cantidad) {
            this.id_mov = id_mov;
            this.id_usuario = id_usuario;
            this.id_producto = id_producto;
            this.accion = accion;
            this.cantidad = cantidad;
        }

        public Movimientos(Cursor cursor) {
            id_mov= cursor.getInt(cursor.getColumnIndex(MovimientosEntry.IDMOV));
            id_usuario= cursor.getInt(cursor.getColumnIndex(MovimientosEntry.IDUSER));
            id_producto= cursor.getInt(cursor.getColumnIndex(MovimientosEntry.IDPROD));
            accion= cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ACTION));
            cantidad= cursor.getInt(cursor.getColumnIndex(MovimientosEntry.QUANTITY));
        }
        public ContentValues toContentValues(){
            ContentValues Values = new ContentValues();
            Values.put(MovimientosEntry.IDMOV, id_mov);
            Values.put(MovimientosEntry.IDUSER, id_usuario);
            Values.put(MovimientosEntry.IDPROD, id_producto);
            Values.put(MovimientosEntry.ACTION, accion);
            Values.put(MovimientosEntry.QUANTITY, cantidad);

            return Values;
        }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
