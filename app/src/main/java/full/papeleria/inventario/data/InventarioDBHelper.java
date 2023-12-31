package full.papeleria.inventario.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import full.papeleria.inventario.data.ProductosContract.ProductosEntry;
import full.papeleria.inventario.data.UsuarioContract.UsuarioEntry;

public class InventarioDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventario.bd";

    public InventarioDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + ProductosEntry.TABLE_NAME + " ("+
                ProductosEntry.CODIGO + " INTEGER PRIMARY KEY," +
                ProductosEntry.NAMEPROD+ " TEXT NOT NULL," +
                ProductosEntry.STOCK+ " INTEGER NOT NULL," +
                ProductosEntry.SALIDAS+ " INTEGER NOT NULL,"+
                ProductosEntry.VALOR + " INTEGER NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + UsuarioEntry.TABLE_NAME + " ("+
                UsuarioEntry.ID + " INTEGER PRIMARY KEY," +
                UsuarioEntry.NAME + " TEXT NOT NULL," +
                UsuarioEntry.LASTNAME + " TEXT NOT NULL," +
                UsuarioEntry.USER + " TEXT NOT NULL," +
                UsuarioEntry.PASSWORD + " TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + MovimientosContract.MovimientosEntry.TABLE_NAME + " ("+
                MovimientosContract.MovimientosEntry.IDMOV + " INTEGER PRIMARY KEY," +
                MovimientosContract.MovimientosEntry.NOMUSER+ " TEXT NOT NULL," +
                MovimientosContract.MovimientosEntry.NOMPROD+ " TEXT NOT NULL," +
                MovimientosContract.MovimientosEntry.ACTION+ " TEXT NOT NULL,"+
                MovimientosContract.MovimientosEntry.QUANTITY + " INTEGER NOT NULL)");
    }
//uwu
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    // funciones para tabla PRODUCTOS------------------------------------------------------------
    public long saveProducto(Productos producto) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                ProductosEntry.TABLE_NAME,
                null,
                producto.toContentValues());
    }

    public Cursor getAllProductos() {
        return getReadableDatabase()
                .query(
                        ProductosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getProductoById(String productoId) {
        Cursor c = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.CODIGO + " LIKE ?",
                new String[]{productoId},
                null,
                null,
                null);
        return c;
    }

    public Cursor getProductoByNAMEId(String productoId, String nombreprod) {
        Cursor c = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.CODIGO + " LIKE ? AND " + ProductosEntry.NAMEPROD + " LIKE ?",
                new String[]{productoId, nombreprod},
                null,
                null,
                null);
        return c;
    }


    public Cursor getProductoByName(String productoName) {
        Cursor c = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.NAMEPROD + " LIKE ?",
                new String[]{productoName},
                null,
                null,
                null);
        return c;
    }


    public int deleteProducto(String productoId) {
        return getWritableDatabase().delete(
                ProductosEntry.TABLE_NAME,
                ProductosEntry.CODIGO+ " LIKE ?",
                new String[]{productoId});
    }

    public int updateProducto(Productos productoModificar, String productoId) {
        return getWritableDatabase().update(
                ProductosEntry.TABLE_NAME,
                productoModificar.toContentValues(),
                ProductosEntry.CODIGO + " LIKE ?",
                new String[]{productoId}
        );
    }



    // funciones para tabla USUARIOS---------------------------------------------------------
    public long saveUsuario(Usuario usuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }

    public Cursor getAllUsuarios() {
        return getReadableDatabase()
                .query(
                        UsuarioEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getUsuarioById(String usuarioId) {
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId},
                null,
                null,
                null);
        return c;
    }

    public Cursor getUsuarioByUserPassword(String userUnique, String passwordUser) {
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.USER + " LIKE ? AND " + UsuarioEntry.PASSWORD + " LIKE ?",
                new String[]{userUnique, passwordUser},
                null,
                null,
                null);
        return c;
    }

    public Cursor getUsuarioByUser(String usuarioName) {
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.USER + " LIKE ?",
                new String[]{usuarioName},
                null,
                null,
                null);
        return c;
    }


    public int deleteUsuario(String usuarioId) {
        return getWritableDatabase().delete(
                UsuarioEntry.TABLE_NAME,
                UsuarioEntry.ID+ " LIKE ?",
                new String[]{usuarioId});
    }

    public int updateUsuario(Usuario usuarioModificar, String usuarioId) {
        return getWritableDatabase().update(
                UsuarioEntry.TABLE_NAME,
                usuarioModificar.toContentValues(),
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId}
        );
    }

    // funciones para tabla MOVIMIENTOS---------------------------------------------------------
    public long saveMovimiento(Movimientos movimientos) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                MovimientosContract.MovimientosEntry.TABLE_NAME,
                null,
                movimientos.toContentValues());
    }

    public Cursor getAllMovimiento() {
        return getReadableDatabase()
                .query(
                        MovimientosContract.MovimientosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getMovimientoById(String movimientoId) {
        Cursor c = getReadableDatabase().query(
                MovimientosContract.MovimientosEntry.TABLE_NAME,
                null,
                MovimientosContract.MovimientosEntry.IDMOV + " LIKE ?",
                new String[]{movimientoId},
                null,
                null,
                null);
        return c;
    }


    public int deleteMovimiento(String movimientoId) {
        return getWritableDatabase().delete(
                MovimientosContract.MovimientosEntry.TABLE_NAME,
                MovimientosContract.MovimientosEntry.IDMOV+ " LIKE ?",
                new String[]{movimientoId});
    }

    public int updateMovimiento(Movimientos movimientoModificar, String movimientoId) {
        return getWritableDatabase().update(
                MovimientosContract.MovimientosEntry.TABLE_NAME,
                movimientoModificar.toContentValues(),
                MovimientosContract.MovimientosEntry.IDMOV + " LIKE ?",
                new String[]{movimientoId}
        );
    }


    public Productos getProductById(int productoId) {
        SQLiteDatabase db = getReadableDatabase();
        Productos product = null;

        Cursor cursor = db.query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.CODIGO + " = ?",
                new String[]{String.valueOf(productoId)},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            product = new Productos(cursor);
            cursor.close();
        }

        return product;
    }


}
