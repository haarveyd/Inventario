package com.example.inventario.data;

import android.provider.BaseColumns;

public class MovimientosContract {

    public static abstract class MovimientosEntry implements BaseColumns {
        public static final String TABLE_NAME ="Movimientos";
        public static final String IDMOV  ="codigoMovimiento";
        public static final String IDUSER  ="nomUsuario";
        public static final String IDPROD  ="usuario";
        public static final String ACTION ="password";
        public static final String QUANTITY ="password";



    }
}
