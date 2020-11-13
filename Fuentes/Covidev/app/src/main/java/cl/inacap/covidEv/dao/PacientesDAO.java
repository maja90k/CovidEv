package cl.inacap.covidEv.dao;

import java.util.List;

import cl.inacap.covidEv.dto.Paciente;

public interface PacientesDAO {

    List<Paciente> getAll();
    Paciente save(Paciente p);
}
