package org.example.objetos.abstractos;

import java.util.ArrayList;

// Clase abstracta para que no pueda ser instanciada y extiende la clase CuentaBancaria
public abstract class CuentaCorriente extends CuentaBancaria{

    private ArrayList<String> entidades;

    // Constructores de la clase
    public CuentaCorriente() {
        this.entidades = new ArrayList<>();
    }

    public CuentaCorriente(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades) {
        super(nombre, apellidos, dni, saldo, iban);
        this.entidades = entidades;
    }

    // Getters y setters de la clase
    public ArrayList<String> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<String> entidades) {
        this.entidades = entidades;
    }

    public void addEntidad(String entidad) {
        this.entidades.add(entidad);

    }

    // Sobreescribe el metodo devolverInfoString de la clase padre para añadir el nuevo atributo
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Entidades: " + this.entidades.toString();
    }
}
