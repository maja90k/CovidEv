package cl.sema.covidev.dao;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.Paciente;

public class PacientesDAOLista implements PacientesDAO {
    private List<Paciente> pacientes = new ArrayList<>();


    private static PacientesDAOLista instancia;


    public static PacientesDAOLista getInstance() {
        if (instancia == null) {
            instancia = new PacientesDAOLista();
        }
        return instancia;
    }

    private PacientesDAOLista() {
        Paciente p = new Paciente();
        //atributos.
    }

    @Override
    public List<Paciente> getAll() {
        return null;
    }

    @Override
    public Paciente save(Paciente p) {
        pacientes.add(p);
        return p;
    }
}
