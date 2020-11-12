package cl.sema.covidev.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.Paciente;
import cl.sema.covidev.helpers.PacientesSQLiteHelper;

public class PacientesDAOSQLite implements PacientesDAO {

    private PacientesSQLiteHelper db;

    public PacientesDAOSQLite(Context contexto) {
        this.db = new PacientesSQLiteHelper(contexto, "DBPacientes", null, 1);
    }


    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try {
            if (reader != null) {
                Cursor c = reader.rawQuery("SELECT rut,nombre,apellido, fechaexamen" +
                        ", area,sintomas, temperatura, tos, presion" + " FROM pacientes", null);
                if (c.moveToFirst()) {
                    do {
                        Paciente p = new Paciente();
                        p.setRut(c.getInt(0));
                        p.setValidadorRut(c.getInt(1));
                        p.setNombre(c.getString(2));
                        p.setApellido(c.getString(3));
                        p.setFechaexamen(c.getInt(4));
                        p.setArea(c.getString(5));
                        p.setSintomas(c.equals(true));
                        p.setTemperatura(c.getInt(6));
                        p.setTos(c.equals(true));
                        p.setPresion(c.getInt(7));

                    } while (c.moveToNext());
                }
                reader.close();
            }
        } catch (Exception ex) {
            Log.e("PACIENTESDAO", ex.toString());
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        String sql = String.format("INSERT INTO pacientes(" + "rut,validadorRut,nombre,apellido,fechaexamen, area,sintomas ,temperatura, tos, presion)" +
                        " VALUES(%d,%d,'%s','%s','%s', %d ,'%s','%s',%d,'%s')"
                , p.getRut(), p.getValidadorRut(), p.getNombre(), p.getApellido(), p.getFechaexamen(), p.getArea(), p.getTemperatura(), p.getPresion());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}
