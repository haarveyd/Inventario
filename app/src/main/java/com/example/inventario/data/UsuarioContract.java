package com.example.inventario.data;

import android.provider.BaseColumns;

public class UsuarioContract {
    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME ="usuarios";
        public static final String ID  ="codigoUsuario";
        public static final String NAME  ="nomUsuario";
        public static final String LASTNAME = "apUsuario";
        public static final String USER  ="usuario";
        public static final String PASSWORD ="password";



    }
}
