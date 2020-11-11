package cl.sema.covidev.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsersSQLiteHelper extends SQLiteOpenHelper {

    //el helper ayuda a crear la base de datos interna
    public final String sqlCreate = "CREATE TABLE usuarios("+
            " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            " nombre STRING,"+
            " validadorNom STRING,"+
            " password STRING)" ;

    public UsersSQLiteHelper(@Nullable Context contexto
            , @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory
            , int version) {
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO usuarios(id,nombre,validadorNom,password) " +
                "VALUES('','','','')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
