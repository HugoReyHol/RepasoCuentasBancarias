package org.example.objetos.abstractos;

import org.example.interfaces.Imprimible;
import org.example.objetos.Persona;

// Una clase abstracta para que no se pueda invocar, implementa la interfaz Imprimibe
public abstract class CuentaBancaria implements Imprimible {

    private Persona titular;
    private double saldo;
    private String iban;

    // Constructores de la clase
    public CuentaBancaria() {
    }

    public CuentaBancaria(String nombre, String apellidos, String dni, double saldo, String iban) {
        this.titular = new Persona(nombre, apellidos, dni);
        this.saldo = saldo;
        this.iban = iban;
    }

    // Implementacion del metodo de la interfaz, devuelve un string con los valores de los atributos de la clase
    @Override
    public String devolverInfoString() {
        return "Titular: " + this.titular.devolverInfoString() +
               "; Saldo: " + this.saldo +
               "; IBAN: " + this.iban;
    }

    // Getters y setters de los distintos atributos privados de la clase
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
