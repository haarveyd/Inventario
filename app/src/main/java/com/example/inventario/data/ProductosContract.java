package com.example.inventario.data;

import android.provider.BaseColumns;

public class ProductosContract {
    public static abstract class ProductosEntry implements BaseColumns {
        public static final String TABLE_NAME ="producto";
        public static final String CODIGO  ="codigo";

        public static final String NAME  ="nomProducto";
        public static final String STOCK ="stock";
        public static final String SALIDAS ="salidas";
        public static final String VALOR ="valorUnitario";


    }
}
