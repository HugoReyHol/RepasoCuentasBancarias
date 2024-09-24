package org.example.objetos.abstractos;

import org.example.interfaces.Imprimible;
import org.example.objetos.Persona;

public abstract class CuentaBancaria implements Imprimible {

    private Persona titular;
    private double saldo;
    private String iban;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String nombre, String apellidos, String dni, double saldo, String iban) {
        this.titular = new Persona(nombre, apellidos, dni);
        this.saldo = saldo;
        this.iban = iban;
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + this.titular.devolverInfoString() +
               "; Saldo: " + this.saldo +
               "; IBAN: " + this.iban;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
