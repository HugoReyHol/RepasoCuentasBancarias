package org.example.objetos;

import org.example.interfaces.Imprimible;

// Una clase abstracta para que no se pueda invocar, implementa la interfaz Imprimibe
public class Persona implements Imprimible {

    private String nombre, apellidos, dni;

    // Constructor de la clase
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // Getters y setters de los distintos atributos privados de la clase
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

    // Implementacion del metodo de la interfaz, devuelve un string con los valores de los atributos de la clase
    @Override
    public String devolverInfoString() {
        return " [Nombre: " + this.nombre +
               "; Apellidos: " + this.apellidos +
               "; DNI: " + this.dni + "]";
    }
}
