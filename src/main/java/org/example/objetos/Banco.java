package org.example.objetos;

import org.example.objetos.abstractos.CuentaBancaria;

import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public boolean abrirCuenta(CuentaBancaria cuenta) {
        try {
            cuentas.add(cuenta);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String[] listadoCuentas() {
        String[] listado = new String[this.cuentas.size()];

        for (int i=0; i < this.cuentas.size(); i++) {
            listado[i] = this.cuentas.get(i).devolverInfoString();

        }

        return listado;
    }

    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : this.cuentas) {
            if (cuenta.getIban().equals(iban)) return cuenta.devolverInfoString();

        }

        return "No existe cuenta con ese IBAN";
    }

    public boolean ingresoCuenta(String iban, double dinero) {
        for (CuentaBancaria cuenta : this.cuentas) {
            if (cuenta.getIban().equals(iban)) {
                cuenta.setSaldo(cuenta.getSaldo() + dinero);
                return true;

            }
        }

        return false;
    }

    public boolean retiradaCuenta(String iban, double dinero) {
        for (CuentaBancaria cuenta : this.cuentas) {
            if (cuenta.getIban().equals(iban) && dinero <= cuenta.getSaldo()) {
                cuenta.setSaldo(cuenta.getSaldo() - dinero);
                return true;

            }
        }

        return false;
    }

    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : this.cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.getSaldo();

            }
        }

        return -1;
    }


}
