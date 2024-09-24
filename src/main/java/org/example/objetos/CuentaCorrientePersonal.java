package org.example.objetos;

import org.example.objetos.abstractos.CuentaCorriente;

import java.util.ArrayList;

public class CuentaCorrientePersonal extends CuentaCorriente {

    private double mantenimiento;

    public CuentaCorrientePersonal() {
    }

    public CuentaCorrientePersonal(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades, double mantenimiento) {
        super(nombre, apellidos, dni, saldo, iban, entidades);
        this.mantenimiento = mantenimiento;
    }

    public double getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(double mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Comisión mantenimiento: " + this.mantenimiento;
    }
}
