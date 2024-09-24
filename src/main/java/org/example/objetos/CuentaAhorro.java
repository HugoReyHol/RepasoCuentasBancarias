package org.example.objetos;

import org.example.objetos.abstractos.CuentaBancaria;

public class CuentaAhorro extends CuentaBancaria {

    private float tipoInteres;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String nombre, String apellidos, String dni, double saldo, String iban, float tipoInteres) {
        super(nombre, apellidos, dni, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    public float getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "; Tipo de interes: " + this.tipoInteres;
    }
}
