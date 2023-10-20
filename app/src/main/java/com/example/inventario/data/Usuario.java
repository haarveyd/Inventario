package com.example.inventario.data;

import android.content.ContentValues;
import android.database.Cursor;
import com.example.inventario.data.UsuarioContract.UsuarioEntry;


public class Usuario {

    private int codigo;
    private String nomUsuario;
    private String user;
    private int password;

    public Usuario(int codigo, String nomUsuario,String user, int password) {
        this.codigo = codigo;
        this.nomUsuario = nomUsuario;
        this.user = user;
        this.password = password;

    }

    public Usuario(Cursor cursor) {
        codigo= cursor.getInt(cursor.getColumnIndex(UsuarioEntry.ID));
        nomUsuario= cursor.getString(cursor.getColumnIndex(UsuarioEntry.NAME));
        user= cursor.getString(cursor.getColumnIndex(UsuarioEntry.USER));
        password= cursor.getInt(cursor.getColumnIndex(UsuarioEntry.PASSWORD));

    }
    public ContentValues toContentValues(){
        ContentValues Values = new ContentValues();
        Values.put(UsuarioEntry.ID, codigo);
        Values.put(UsuarioEntry.NAME, nomUsuario);
        Values.put(UsuarioEntry.USER, user);
        Values.put(UsuarioEntry.PASSWORD, password);
        return Values;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public String getUsuario() {
        return user;
    }

    public int getPassword() {
        return password;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public void setPassword(int password) {

        this.password = password;
    }

}
