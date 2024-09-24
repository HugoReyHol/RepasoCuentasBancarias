package org.example.objetos;

import org.example.interfaces.Imprimible;

public class Persona implements Imprimible {

    private String nombre, apellidos, dni;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String devolverInfoString() {
        return "\nNombre: " + this.nombre +
               ";Apellidos: " + this.apellidos +
               ";DNI: " + this.dni;
    }
}
