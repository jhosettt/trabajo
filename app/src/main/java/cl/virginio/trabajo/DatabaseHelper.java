package cl.virginio.trabajo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "productos.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE productos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "descripcion TEXT," +
                "precio REAL)";
        db.execSQL(createTable);

        // Insertar algunos productos de ejemplo
        db.execSQL("INSERT INTO productos (nombre, descripcion, precio) VALUES ('Almendras', 'Frutos secos saludables', 3500)");
        db.execSQL("INSERT INTO productos (nombre, descripcion, precio) VALUES ('Nueces', 'Ricas en omega-3', 4500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");
        onCreate(db);
    }

    public List<Producto> obtenerProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM productos", null);

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                double precio = cursor.getDouble(cursor.getColumnIndexOrThrow("precio"));

                Producto producto = new Producto(nombre, descripcion, precio);
                listaProductos.add(producto);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaProductos;
    }
}

