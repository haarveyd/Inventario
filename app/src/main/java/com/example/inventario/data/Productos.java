package com.example.inventario.data;

import android.content.ContentValues;
import android.database.Cursor;
import com.example.inventario.data.ProductosContract.ProductosEntry;

public class Productos {
    private int codigo;
    private String nomProducto;
    private int stock;
    private int salidas;
    private int valorUnitario;

    public Productos(int codigo, String nomProducto, int stock, int salidas, int valorUnitario) {
        this.codigo = codigo;
        this.nomProducto = nomProducto;
        this.stock = stock;
        this.salidas = salidas;
        this.valorUnitario = valorUnitario;
    }

    public Productos(Cursor cursor) {
        codigo= cursor.getInt(cursor.getColumnIndex(ProductosEntry.CODIGO));
        nomProducto= cursor.getString(cursor.getColumnIndex(ProductosEntry.NAMEPROD));
        stock= cursor.getInt(cursor.getColumnIndex(ProductosEntry.STOCK));
        salidas= cursor.getInt(cursor.getColumnIndex(ProductosEntry.SALIDAS));
        valorUnitario= cursor.getInt(cursor.getColumnIndex(ProductosEntry.VALOR));
    }
    public ContentValues toContentValues(){
        ContentValues Values = new ContentValues();
        Values.put(ProductosEntry.CODIGO, codigo);
        Values.put(ProductosEntry.NAMEPROD, nomProducto);
        Values.put(ProductosEntry.STOCK, stock);
        Values.put(ProductosEntry.SALIDAS, salidas);
        Values.put(ProductosEntry.VALOR, valorUnitario);

        return Values;
    }

    public int getCodigo() {

        return codigo;
    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;
    }

    public String getnomProducto() {

        return nomProducto;
    }

    public void setnomProducto(String nomProducto) {

        nomProducto = nomProducto;
    }

    public int getStock() {

        return stock;
    }

    public void setStock(int stock) {

        this.stock = stock;
    }

    public int getSalidas() {

        return salidas;
    }

    public void setSalidas(int salidas) {

        this.salidas = salidas;
    }

    public int getValorUnitario() {

        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {

        this.valorUnitario = valorUnitario;
    }
}
