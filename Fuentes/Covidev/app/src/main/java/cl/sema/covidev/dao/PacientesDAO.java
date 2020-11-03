package cl.sema.covidev.dao;

import java.util.List;

import cl.sema.covidev.dto.Paciente;

public interface PacientesDAO {

    List<Paciente> getAll();
    Paciente save(Paciente p);
}
