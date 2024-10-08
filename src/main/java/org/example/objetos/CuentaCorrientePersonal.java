package org.example.objetos;

import org.example.objetos.abstractos.CuentaCorriente;

import java.util.ArrayList;

// Extiende CuentaCorriente para heredar sus atributos y funciones
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double mantenimiento;


    // Constructores de la clase
    public CuentaCorrientePersonal() {
    }

    // Llama al constructor de la clase padre y le añade el atributo nuevo
    public CuentaCorrientePersonal(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades, double mantenimiento) {
        super(nombre, apellidos, dni, saldo, iban, entidades);
        this.mantenimiento = mantenimiento;
    }

    // Getters y setters del nuevo atributo
    public double getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(double mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    // Sobreescribe el metodo devolverInfoString de la clase padre para añadir el nuevo atributo
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Comisión mantenimiento: " + this.mantenimiento;
    }
}
