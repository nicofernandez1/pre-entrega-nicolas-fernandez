package com.techlab.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerInt(String mensaje) {
        while(true) {
            try {
                System.out.println(mensaje);
                int entrada = scanner.nextInt();
                scanner.nextLine();
                if (entrada <= 0) {
                    System.out.println("ERROR: Debes ingresar un numero entero positivo");
                    continue;
                }
                return entrada;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes ingresar un número entero");
                scanner.nextLine();
            }
        }
    }

    public static String leerString(String mensaje) {
        String entrada;

        do {
            System.out.println(mensaje);
            entrada = scanner.nextLine();
            if (entrada.isEmpty()) {
                System.out.println("ERROR: Ingreso no puede estar vacio");
            }
        } while (entrada.trim().isEmpty());

        return entrada.trim();
    }

    public static double leerDouble(String mensaje) {
        while(true) {
            try {
                System.out.println(mensaje);
                double entrada = scanner.nextDouble();
                scanner.nextLine();
                if (entrada <= 0) {
                    System.out.println("ERROR: Debes ingresar un valor positivo");
                    continue;
                }
                return entrada;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes ingresar un número válido");
                scanner.nextLine();
            }
        }
    }
}
