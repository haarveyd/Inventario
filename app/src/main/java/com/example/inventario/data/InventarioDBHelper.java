package com.example.inventario.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.inventario.data.ProductosContract.ProductosEntry;
import com.example.inventario.data.UsuarioContract.UsuarioEntry;
import com.example.inventario.data.MovimientosContract.MovimientosEntry;
public class InventarioDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventario.db";

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
                UsuarioEntry.NAME+ " TEXT NOT NULL," +
                UsuarioEntry.USER+ " TEXT NOT NULL," +
                UsuarioEntry.PASSWORD+ " TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + MovimientosEntry.TABLE_NAME + " ("+
                MovimientosEntry.IDMOV + " INTEGER PRIMARY KEY," +
                MovimientosEntry.IDUSER+ " INTEGER NOT NULL," +
                MovimientosEntry.IDPROD+ " INTEGER NOT NULL," +
                MovimientosEntry.ACTION+ " INTEGER NOT NULL,"+
                MovimientosEntry.QUANTITY + " INTEGER NOT NULL)");
    }

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

    public int updateUsuario(Productos usuarioModificar, String usuarioId) {
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
                MovimientosEntry.TABLE_NAME,
                null,
                movimientos.toContentValues());
    }

    public Cursor getAllMovimiento() {
        return getReadableDatabase()
                .query(
                        MovimientosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getMovimientoById(String movimientoId) {
        Cursor c = getReadableDatabase().query(
                MovimientosEntry.TABLE_NAME,
                null,
                MovimientosEntry.IDMOV + " LIKE ?",
                new String[]{movimientoId},
                null,
                null,
                null);
        return c;
    }


    public int deleteMovimiento(String movimientoId) {
        return getWritableDatabase().delete(
                MovimientosEntry.TABLE_NAME,
                MovimientosEntry.IDMOV+ " LIKE ?",
                new String[]{movimientoId});
    }

    public int updateMovimiento(Productos movimientoModificar, String movimientoId) {
        return getWritableDatabase().update(
                MovimientosEntry.TABLE_NAME,
                movimientoModificar.toContentValues(),
                MovimientosEntry.IDMOV + " LIKE ?",
                new String[]{movimientoId}
        );
    }

}
