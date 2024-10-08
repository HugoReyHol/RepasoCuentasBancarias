package org.example.objetos;

import org.example.objetos.abstractos.CuentaCorriente;

import java.util.ArrayList;

// Extiende CuentaCorriente para heredar sus atributos y funciones
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private float interesDes, maximoDes;

    // Constructores de la clase
    public CuentaCorrienteEmpresa() {
    }

    // Llama al constructor de la clase padre y le añade el atributo nuevo
    public CuentaCorrienteEmpresa(String nombre, String apellidos, String dni, double saldo, String iban, ArrayList<String> entidades, float interesDes, float maximoDes) {
        super(nombre, apellidos, dni, saldo, iban, entidades);
        this.interesDes = interesDes;
        this.maximoDes = maximoDes;
    }

    // Getters y setters de los nuevos atributos
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

    // Sobreescribe el metodo devolverInfoString de la clase padre para añadir los nuevos atributos
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Interes descubierto: " + this.interesDes +
               "; Maximo interes descubierto: " + this.maximoDes;
    }
}
