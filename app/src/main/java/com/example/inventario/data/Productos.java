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

    public Productos(Cursor cur) {
        codigo= cur.getInt(cur.getColumnIndex(ProductosEntry.CODIGO));
        nomProducto= cur.getString(cur.getColumnIndex(ProductosEntry.NAME));
        stock= cur.getInt(cur.getColumnIndex(ProductosEntry.STOCK));
        salidas= cur.getInt(cur.getColumnIndex(ProductosEntry.SALIDAS));
        valorUnitario= cur.getInt(cur.getColumnIndex(ProductosEntry.VALOR));
    }
    public ContentValues toContentValues(){
        ContentValues conten = new ContentValues();
        conten.put(ProductosEntry.CODIGO, codigo);
        conten.put(ProductosEntry.NAME, nomProducto);
        conten.put(ProductosEntry.STOCK, stock);
        conten.put(ProductosEntry.SALIDAS, salidas);
        conten.put(ProductosEntry.VALOR, valorUnitario);

        return conten;
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
