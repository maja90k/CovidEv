package cl.sema.covidev.dao;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.Paciente;

public class PaceintesDAOLista implements PacientesDAO{

    private List<Paciente> pacientes = new ArrayList<>();
    private static PaceintesDAOLista instancia;


    public static PaceintesDAOLista getInstance(){
        if(instancia == null){
            instancia = new PaceintesDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Paciente> getAll() {
        return null;
    }

    @Override
    public Paciente save(Paciente p){
        pacientes.add(p);
        return p;
    }
}
