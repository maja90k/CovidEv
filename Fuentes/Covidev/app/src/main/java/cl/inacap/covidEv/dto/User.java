package cl.inacap.covidEv.dto;

import java.io.Serializable;

public class User implements Serializable {


    private String nombre;
    private String validadorNom;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValidadorNom() {
        return validadorNom;
    }

    public void setValidadorNom(String validadorNom) {
        this.validadorNom = validadorNom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
