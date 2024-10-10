package org.example.objetos;

import org.example.objetos.abstractos.CuentaBancaria;

import java.util.ArrayList;

// Clase banco la cual va a contener todas las cuentas que cree el usuario
public class Banco {
    private ArrayList<CuentaBancaria> cuentas;

    // Constructor de la clase
    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    /*
    * Añade una cuenta a la lista de cuentas bancarias
    *
    * Recibe una cuenta bancaria
    *
    * Devuelve true si se ha añadido correctamente o false si ya existia una cuenta con el mismo IBAN
    *
    * */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        // Comprueba si existe una cuenta con el mismo IBAN que la nueva
        for (CuentaBancaria c : this.cuentas) {
            if (c.getIban().equals(cuenta.getIban())) {
                return false; // Si existe no añade la cuenta nueva

            }
        }

        // Si no existe añade la cuenta nueva
        this.cuentas.add(cuenta);

        return true;

    }

    /*
     * Lista todas las cuentas bancarias que tiene el banco
     *
     * Devuelve una Array de Strings
     *
     * */
    public String[] listadoCuentas() {
        // Array para guardar la informacion de las cuentas
        String[] listado = new String[this.cuentas.size()];

        // Recorre todas las cuentas del cuentas y agrega su informacion al listado
        for (int i=0; i < this.cuentas.size(); i++) {
            listado[i] = this.cuentas.get(i).devolverInfoString();

        }

        return listado;
    }

    /*
     * Recoge la informacion de una cuenta bancaria
     *
     * Recibe el IBAN de una cuenta bancaria
     *
     * Devuelve un String con la informacion o con un mensaje de error si no se ha podido encontrar la cuenta
     *
     * */
    public String informacionCuenta(String iban) {
        // Recorre toda la lista de cuentas buscando la pedida
        for (CuentaBancaria cuenta : this.cuentas) {
            // Si la encuentra devuelve la informacion
            if (cuenta.getIban().equals(iban)) return cuenta.devolverInfoString();

        }

        return "No existe cuenta con ese IBAN";
    }

    /*
     * Realiza un ingreso a una cuenta bancaria
     *
     * Recibe el IBAN de una cuenta bancaria y un double con el dinero a ingresar
     *
     * Devuelve true si se ha añadido correctamente o false si ha habido algun error
     *
     * */
    public boolean ingresoCuenta(String iban, double dinero) {
        // Recorre toda la lista de cuentas buscando la pedida
        for (CuentaBancaria cuenta : this.cuentas) {
            // Si la encuentra le añade el dinero al saldo actual
            if (cuenta.getIban().equals(iban)) {
                cuenta.setSaldo(cuenta.getSaldo() + dinero);
                return true;

            }
        }

        return false;
    }

    /*
     * Realiza una retirada a una cuenta bancaria
     *
     * Recibe el IBAN de una cuenta bancaria y un double con el dinero a retirar
     *
     * Devuelve true si se ha añadido correctamente o false si ha habido algun error
     *
     * */
    public boolean retiradaCuenta(String iban, double dinero) {
        // Recorre toda la lista de cuentas buscando la pedida
        for (CuentaBancaria cuenta : this.cuentas) {
            // Si la encuentra le resta el dinero al saldo actual
            if (cuenta.getIban().equals(iban) && dinero <= cuenta.getSaldo()) {
                cuenta.setSaldo(cuenta.getSaldo() - dinero);
                return true;

            }
        }

        return false;
    }

    /*
     * Consulta el sueldo de una cuenta bancaria
     *
     * Recibe el IBAN de una cuenta bancaria
     *
     * Devuelve el dinero de la cuenta o -1 si no se ha encontrado la cuenta
     *
     * */
    public double obtenerSaldo(String iban) {
        // Recorre toda la lista de cuentas buscando la pedida
        for (CuentaBancaria cuenta : this.cuentas) {
            // Si la encuentra devuelve el saldo actual
            if (cuenta.getIban().equals(iban)) {
                return cuenta.getSaldo();

            }
        }

        // Si no la encuentra devuelve -1
        return -1;
    }


}
