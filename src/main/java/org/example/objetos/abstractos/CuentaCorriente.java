package org.example.objetos.abstractos;

import java.util.ArrayList;

public abstract class CuentaCorriente extends CuentaBancaria{

    private ArrayList<String> entidades;

    public CuentaCorriente() {
    }

    public CuentaCorriente(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades) {
        super(nombre, apellidos, dni, saldo, iban);
        this.entidades = entidades;
    }

    public ArrayList<String> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<String> entidades) {
        this.entidades = entidades;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Entidades: " + this.entidades.toString();
    }
}
