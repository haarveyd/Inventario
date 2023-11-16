package full.papeleria.inventario.data;

import android.provider.BaseColumns;

public class ProductosContract {
    public static abstract class ProductosEntry implements BaseColumns {
        public static final String TABLE_NAME ="producto";
        public static final String CODIGO  ="codigoProducto";

        public static final String NAMEPROD  ="nomProducto";
        public static final String STOCK ="stock";
        public static final String SALIDAS ="salidas";
        public static final String VALOR ="valorUnitario";


    }
}
