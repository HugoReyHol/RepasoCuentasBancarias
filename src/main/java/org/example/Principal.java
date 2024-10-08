package org.example;

import org.example.objetos.*;
import org.example.objetos.abstractos.CuentaBancaria;
import org.example.objetos.abstractos.CuentaCorriente;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in); // El Scanner para leer la entrada

            Banco banco = new Banco(); // La instancia de Banco para guardar la coleccion de cuentas y gestionarla

            int opcion; // La opcion del menu que a elegido el usuario
            double saldo; // Guarda el saldo que se usa en varias opciones
            String iban; // Guarda el iban solicitado al usuario en varias opciones

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

                // Gestiona el codigo para cada opcion
                switch (opcion) {
                    case 1 -> { //Abrir cuenta
                        System.out.print("Introduzca el nombre del titular: ");
                        String nombre = sc.nextLine();

                        System.out.print("Introduzca los apellidos del titular: ");
                        String apellidos = sc.nextLine();

                        System.out.print("Introduzca el dni del titular: ");
                        String dni = sc.nextLine();

                        Persona titular = new Persona(nombre, apellidos, dni); // Almacena el titular nuevo

                        System.out.println("Introduzca el tipo de cuenta: " +
                                "\n1.- Ahorro." +
                                "\n2.- Corriente personal." +
                                "\n3.- Corriente de empresa.");

                        int tipo = sc.nextInt(); // Pide el tipo de cuenta que se va a crear

                        CuentaBancaria cuenta;

                        // Maneja el codigo necesario para cada tipo de cuenta que se va a crear
                        switch (tipo) {
                            case 1 -> { //Ahorro
                                // Crea la cuenta de ahorro y añade el tipo de interes
                                cuenta = new CuentaAhorro();

                                System.out.print("Introduzca el interes de la cuenta de ahorro: ");
                                ((CuentaAhorro) cuenta).setTipoInteres(sc.nextFloat());

                            }

                            case 2 -> { //Corriente personal
                                // Crea la cuenta personal y añade el coste de mantenimiento
                                cuenta = new CuentaCorrientePersonal();

                                System.out.print("Introduzca el coste de mantenimiento de la cuenta corriente personal: ");
                                ((CuentaCorrientePersonal) cuenta).setMantenimiento(sc.nextDouble());

                            }

                            case 3 -> { //Corriente de empresa
                                // Crea la cuenta de empresa y le añade el interes descubierto y el maximo descubierto
                                cuenta = new CuentaCorrienteEmpresa();

                                System.out.print("Introduzca el interes descubierto de la cuenta corriente de empresa: ");
                                ((CuentaCorrienteEmpresa) cuenta).setInteresDes(sc.nextFloat());

                                System.out.print("Introduzca el interes descubierto maximo de la cuenta cuenta corriente de empresa: ");
                                ((CuentaCorrienteEmpresa) cuenta).setMaximoDes(sc.nextFloat());

                            }

                            // Si no se ha elegido una opcion correcta lanza un error
                            default -> throw new Exception("Debe seleccionar una de las cuentas.");
                        }

                        cuenta.setTitular(titular);

                        System.out.print("Introduzca el saldo de la cuenta: ");
                        cuenta.setSaldo(sc.nextDouble());

                        sc.nextLine(); //Arregla el scanner antes de leer los Strings

                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        cuenta.setIban(sc.nextLine());

                        // Si no es cuenta de ahorro se pregunta si quiere añadir entidades autorizadas
                        if (tipo != 1 ) { // No es cuenta de ahorro

                            System.out.print("¿Quieres agregar entidades autorizas a retirar dinero? (1)Si/(0)No: ");
                            int seguir = sc.nextInt();

                            while (seguir != 0){
                                System.out.println("Introduce una entidad: ");
                                sc.nextLine();
                                String entidad = sc.nextLine();

                                ((CuentaCorriente) cuenta).addEntidad(entidad);

                                System.out.print("¿Quieres agregar otra entidades autorizas a retirar dinero? (1)Si/(0)No: ");
                                seguir = sc.nextInt();

                            }
                        }

                        banco.abrirCuenta(cuenta);

                    }

                    case 2 -> { //Listar cuentas
                        // Llama al metodo del banco para listar las cuentas
                        System.out.println(Arrays.toString(banco.listadoCuentas()));

                    }

                    case 3 -> { //Informacion cuentas
                        // Llama al metodo del banco para conseguir la informacion de la cuenta que ha introducido el usuario
                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        iban = sc.nextLine();

                        System.out.println(banco.informacionCuenta(iban));

                    }

                    case 4 -> { //Ingreso
                        // Llama al metodo del banco para realizar un ingreso
                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        iban = sc.nextLine();

                        System.out.print("Introduzca la cantidad a ingresar: ");
                        saldo = sc.nextDouble();

                        // Si duelve true el ingreso a sido correcto y si no ha sido incorrecto
                        if (banco.ingresoCuenta(iban, saldo)) {
                            System.out.println("Ingreso realizado correctamente.");

                        } else {
                            System.out.println("Ingreso fallido, intentelo de nuevo mas tarde.");
                        }
                    }

                    case 5 -> { //Retirada
                        // Llama al metodo del banco para realizar una retirada
                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        iban = sc.nextLine();

                        System.out.print("Introduzca la cantidad a retirar: ");
                        saldo = sc.nextDouble();

                        // Si duelve true la retirada a sido correcta y si no ha sido incorrecta
                        if (banco.retiradaCuenta(iban, saldo)) {
                            System.out.println("Retirada realizada correctamente.");

                        } else {
                            System.out.println("Retirada fallida, intentelo de nuevo mas tarde.");
                        }
                    }

                    case 6 -> { //Consultar saldo
                        // Llama al metodo del banco para consultar el saldo de una cuenta
                        System.out.print("Introduzca el IBAN de la cuenta: ");
                        iban = sc.nextLine();

                        saldo = banco.obtenerSaldo(iban);

                        // Si el saldo es distinto de -1 lo imprime y si es igual no se ha podido consultar la cuenta
                        if (saldo != -1) {
                            System.out.println(saldo + "€");

                        } else {
                            System.out.println("No existe una cuenta con ese IBAN");

                        }
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