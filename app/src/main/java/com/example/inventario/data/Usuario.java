package com.example.inventario.data;

import android.content.ContentValues;
import android.database.Cursor;
import com.example.inventario.data.UsuarioContract.UsuarioEntry;


public class Usuario {
    private String nomUsuario;
    private int password;

    public Usuario(String nomUsuario, int password) {
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public Usuario(Cursor cur) {
        nomUsuario= cur.getString(cur.getColumnIndex(UsuarioEntry.NAME));
        password= cur.getInt(cur.getColumnIndex(UsuarioEntry.PASSWORD));
    }
    public ContentValues toContentValues(){
        ContentValues conten = new ContentValues();
        conten.put(UsuarioEntry.NAME, nomUsuario);
        conten.put(UsuarioEntry.PASSWORD, password);

        return conten;
    }

    public String getNumUsuario() {
        return nomUsuario;
    }

    public void setNumUsuario(String numUsuario) {
        this.nomUsuario = numUsuario;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
