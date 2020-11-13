package cl.inacap.covidEv.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.covidEv.dto.Paciente;

public class PacientesDAOLista implements PacientesDAO{

    private List<Paciente> pacientes = new ArrayList<>();

    private static PacientesDAOLista instancia;

    private PacientesDAOLista() {
        Paciente p = new Paciente();
        p.setRut(201813425);
        p.setNombre("");
        p.setApellido("");
        p.setFechaexamen(1);
        p.setArea("");
        p.setSintomas(true);
        p.setTemperatura(1);
        p.setTos(true);
        p.setPresion(190);
        pacientes.add(p);

        p = new Paciente();
        p.setRut(20183125);
        p.setNombre("");
        p.setApellido("");
        p.setFechaexamen(90);
        p.setArea("");
        p.setSintomas(true);
        p.setTemperatura(1);
        p.setTos(true);
        p.setPresion(190);
        pacientes.add(p);
    }


    public static PacientesDAOLista getInstance() {
        if (instancia == null) {
            instancia = new PacientesDAOLista();
        }
        return instancia;
    }

    @Override
    public  List<Paciente> getAll() {

        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        pacientes.add(p);
        return p;
    }
}
