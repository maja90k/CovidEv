package cl.sema.covidev.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDBOpenHelper extends SQLiteOpenHelper {

    public final String sqlCreate = "CREATE TABLE usuarios("+
            " nombre STRING,"+
            " validadorNom STRING,"+
            " password STRING)" ;

    public UserDBOpenHelper(@Nullable Context contexto
            , @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory
            , int version) {
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO usuarios(nombre,validadorNom,password)" +
                " VALUES(1000" +
                ",''" +
                ",''" +
                ",'')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
