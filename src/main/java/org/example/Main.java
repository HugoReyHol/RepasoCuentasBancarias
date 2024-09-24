package org.example;

import org.example.objetos.*;
import org.example.objetos.abstractos.CuentaBancaria;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            Banco banco = new Banco();

            int opcion;
            double saldo;
            String isbn;

            do {
                // menu
                System.out.println("MENU DE OPCIONES:" +
                        "\n1.- Abrir una nueva cuenta." +
                        "\n2.- Ver un listado de las cuentas disponibles." +
                        "\n3.- Obtener los datos de una cuenta." +
                        "\n4.- Realizar un ingreso en una cuenta." +
                        "\n5.- Retirar efectivo de una cuenta." +
                        "\n6.- Consultar el saldo actual de una cuenta." +

                        "\n0.- Salir");

                System.out.print("Introduzca la opcion elegida: ");
                opcion = sc.nextInt();

                sc.nextLine(); //Arregla el scanner antes de leer los Strings

                switch (opcion) {
                    case 1 -> { //Abrir cuenta
                        System.out.print("Introduzca el nombre del titular: ");
                        String nombre = sc.nextLine();

                        System.out.print("Introduzca los apellidos del titular: ");
                        String apellidos = sc.nextLine();

                        System.out.print("Introduzca el dni del titular: ");
                        String dni = sc.nextLine();

                        System.out.print("Introduzca el tipo de cuenta: " +
                                "\n1.- Ahorro." +
                                "\n2.- Corriente personal." +
                                "\n3.- Corriente de empresa.");

                        Persona titular = new Persona(nombre, apellidos, dni);

                        int tipo = sc.nextInt();

                        CuentaBancaria cuenta;

                        switch (tipo) {
                            case 1 -> { //Ahorro
                                cuenta = new CuentaAhorro();

                                System.out.print("Introduzca el interes de la cuenta de ahorro: ");
                                ((CuentaAhorro) cuenta).setTipoInteres(sc.nextFloat());

                            }

                            case 2 -> { //Corriente personal
                                cuenta = new CuentaCorrientePersonal();

                                System.out.print("Introduzca el coste de mantenimiento de la cuenta corriente personal: ");
                                ((CuentaCorrientePersonal) cuenta).setMantenimiento(sc.nextDouble());

                            }

                            case 3 -> { //Corriente de empresa
                                cuenta = new CuentaCorrienteEmpresa();

                                System.out.print("Introduzca el interes descubierto de la cuenta corriente de empresa: ");
                                ((CuentaCorrienteEmpresa) cuenta).setInteresDes(sc.nextFloat());

                                System.out.print("Introduzca el interes descubierto maximo de la cuenta cuenta corriente de empresa: ");
                                ((CuentaCorrienteEmpresa) cuenta).setMaximoDes(sc.nextFloat());

                            }

                            default -> throw new Exception("Debe seleccionar una de las cuentas.");
                        }

                        cuenta.setTitular(titular);

                        System.out.print("Introduzca el saldo de la cuenta: ");
                        cuenta.setSaldo(sc.nextDouble());

                        sc.nextLine(); //Arregla el scanner antes de leer los Strings

                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        cuenta.setIban(sc.nextLine());

                    }

                    case 2 -> { //Listar cuentas
                        System.out.println(Arrays.toString(banco.listadoCuentas()));

                    }

                    case 3 -> { //Informacion cuentas
                        System.out.print("Introduzca el ISBN de la cuenta: ");
                        isbn = sc.nextLine();

                        System.out.println(banco.informacionCuenta(isbn));

                    }

                    case 4 -> { //Ingreso
                        System.out.print("Introduzca el ISBN de la cuenta: ");
                        isbn = sc.nextLine();

                        System.out.print("Introduzca la cantidad a ingresar: ");
                        saldo = sc.nextDouble();

                        if (banco.ingresoCuenta(isbn, saldo)) {
                            System.out.println("Ingreso realizado correctamente.");

                        } else {
                            System.out.println("Ingreso fallido, intentelo de nuevo mas tarde.");
                        }
                    }

                    case 5 -> { //Retirada
                        System.out.print("Introduzca el ISBN de la cuenta: ");
                        isbn = sc.nextLine();

                        System.out.print("Introduzca la cantidad a retirar: ");
                        saldo = sc.nextDouble();

                        if (banco.retiradaCuenta(isbn, saldo)) {
                            System.out.println("Retirada realizada correctamente.");

                        } else {
                            System.out.println("Retirada fallida, intentelo de nuevo mas tarde.");
                        }
                    }

                    case 6 -> { //Consultar saldo
                        System.out.print("Introduzca el ISBN de la cuenta: ");
                        isbn = sc.nextLine();

                        System.out.println(banco.obtenerSaldo(isbn));

                    }

                    case 0 -> System.out.println("Saliendo del programa");

                    default -> System.out.println("Opcion no reconocida");
                }

            } while (opcion != 0);

        } catch (Exception e){
            System.out.println("Error, cerrando el programa");
            System.out.println(e);

        }
    }
}