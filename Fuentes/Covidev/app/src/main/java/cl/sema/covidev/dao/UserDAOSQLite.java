package cl.sema.covidev.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.User;
import cl.sema.covidev.helpers.UserDBOpenHelper;

public class UserDAOSQLite implements UserDAO {

    private UserDBOpenHelper db;

    public UserDAOSQLite (Context contexto){
        this.db = new UserDBOpenHelper(contexto, "DBUsuarios", null, 1);
    }

    @Override
    public List<User> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<User> usuarios = new ArrayList<>();
        try{
            if (reader != null){
                Cursor c = reader.rawQuery("SELECT nombre, valiaddorNom, password" + "FROM usuarios", null);
                if (c.moveToFirst()){
                    do {
                        User u = new User();
                        u.setNombre(c.getString(0));
                        u.setValidadorNom(c.getString(1));
                        u.setPassword(c.getString(2));
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
        String sql = String.format("INSERT INTO usarios(" + "nombre, validadorNom, password)" +
                        " VALUES(%d,'%s','%s','%s')"
                , u.getNombre(), u.getValidadorNom() ,u.getPassword());
        writer.execSQL(sql);
        writer.close();
        return null;
    }
}
