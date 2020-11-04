package cl.sema.covidev.dto;

import cl.sema.covidev.PrincipalActivity;

public class Paciente extends PrincipalActivity {
    private int rut;
    private String nombre;
    private String apellido;
    private int fechaexamen;
    private String area;
    private boolean sintomas;
    private int temperatura;
    private boolean tos;
    private int presion;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getFechaexamen() {
        return fechaexamen;
    }

    public void setFechaexamen(int fechaexamen) {
        this.fechaexamen = fechaexamen;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isSintomas() {
        return sintomas;
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isTos() {
        return tos;
    }

    public void setTos(boolean tos) {
        this.tos = tos;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }
}
