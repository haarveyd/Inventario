package full.papeleria.inventario.data;

import android.provider.BaseColumns;

public class MovimientosContract {

    public static abstract class MovimientosEntry implements BaseColumns {
        public static final String TABLE_NAME ="Movimientos";
        public static final String IDMOV  ="codigoMovimiento";
        public static final String NOMUSER  ="nomUsuario";
        public static final String NOMPROD  ="nomprod";
        public static final String ACTION ="accion";
        public static final String QUANTITY ="cantidad";


    }
}
