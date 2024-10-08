package org.example.objetos;

import org.example.objetos.abstractos.CuentaBancaria;

// Extiende CuentaBancaria para heredar sus atributos y funciones
public class CuentaAhorro extends CuentaBancaria {

    private float tipoInteres;

    // Constructores de la clase
    public CuentaAhorro() {
    }

    // Llama al constructor de la clase padre y le añade el atributo nuevo
    public CuentaAhorro(String nombre, String apellidos, String dni, double saldo, String iban, float tipoInteres) {
        super(nombre, apellidos, dni, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    // Getters y setters del nuevo atributo
    public float getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    // Sobreescribe el metodo devolverInfoString de la clase padre para añadir el nuevo atributo
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Tipo de interes: " + this.tipoInteres;
    }
}
