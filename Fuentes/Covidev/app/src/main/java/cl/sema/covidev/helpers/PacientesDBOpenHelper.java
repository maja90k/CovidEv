package cl.sema.covidev.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import cl.sema.covidev.dto.Paciente;

public class PacientesDBOpenHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE pacientes(" +
            "rut INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "validadorRut INT," +
            "nombre TEXT," +
            "apellido TEXT," +
            "area TEXT," +
            "sintomas TEXT," +
            "temperatura INTEGER," +
            "tos TEXT," +
            "presion INTEGER," +
            "fechaexamen INTEGER)";

    public PacientesDBOpenHelper(@Nullable Context context
            , @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);
        sqLiteDatabase.execSQL( "INSERT INTO pacientes(rut,validadorRut,nombre,apellid,fechaexamen,area,sintomas,temperatura,tos,presion)" +
                " VALUES(1000" +
                ",''" +
                ",''" +
                ",'')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pacientes");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
