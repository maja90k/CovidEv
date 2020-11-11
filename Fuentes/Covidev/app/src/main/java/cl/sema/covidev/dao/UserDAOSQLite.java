package cl.sema.covidev.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.User;
import cl.sema.covidev.helpers.UsersSQLiteHelper;

public class UserDAOSQLite implements UserDAO {

    private UsersSQLiteHelper db;

    public UserDAOSQLite (Context contexto){
        this.db = new UsersSQLiteHelper(contexto, "DBUsuarios", null, 1);
    }

    @Override
    public List<User> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<User> usuarios = new ArrayList<>();
        try{
            if (reader != null){
                Cursor c = reader.rawQuery("SELECT id,nombre,validadorNom,password" +
                        " FROM usuarios",null);
                if (c.moveToFirst()){
                    do {
                        User u = new User();

                        u.setNombre(c.getString(1));
                        u.setValidadorNom(c.getString(2));
                        u.setPassword(c.getString(3));
                    } while (c.moveToNext());
                }

            }
        }catch (Exception ex){
            usuarios = null;
        }
        return null;
    }

    @Override
    public User save(User u) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        String sql = String.format("INSERT INTO usuarios(" + "nombre, validadorNom, password)" +
                        " VALUES('%s','%s','%s')"
                , u.getNombre(), u.getValidadorNom() ,u.getPassword());
        writer.execSQL(sql);
        writer.close();
        return null;
    }
}
