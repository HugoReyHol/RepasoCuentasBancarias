package org.example.objetos;

import org.example.objetos.abstractos.CuentaCorriente;

import java.util.ArrayList;

public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private float interesDes, maximoDes;

    public CuentaCorrienteEmpresa() {
    }

    public CuentaCorrienteEmpresa(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades, float interesDes, float maximoDes) {
        super(nombre, apellidos, dni, saldo, iban, entidades);
        this.interesDes = interesDes;
        this.maximoDes = maximoDes;
    }

    public float getInteresDes() {
        return interesDes;
    }

    public void setInteresDes(float interesDes) {
        this.interesDes = interesDes;
    }

    public float getMaximoDes() {
        return maximoDes;
    }

    public void setMaximoDes(float maximoDes) {
        this.maximoDes = maximoDes;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Interes descubierto: " + this.interesDes +
               "; Maximo interes descubierto: " + this.maximoDes;
    }
}
