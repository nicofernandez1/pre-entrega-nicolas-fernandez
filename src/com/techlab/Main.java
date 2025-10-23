package com.techlab;

import com.techlab.model.Producto;
import com.techlab.service.ProductoService;
import com.techlab.util.Entrada;

public class Main {
    private static ProductoService service = new ProductoService();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Entrada.leerInt("Ingrese su opcion:");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarActualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción incorrecta");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("""
                
                SISTEMA DE GESTIÓN - TECHLAB
                1) Agregar producto
                2) Listar productos
                3) Buscar/Actualizar producto
                4) Eliminar producto
                5) Salir
                """);
    }

    public static void agregarProducto() {
        String nombre = Entrada.leerString("Ingrese nombre de producto: ");
        double precio = Entrada.leerDouble("Ingrese precio del producto: ");
        int stock = Entrada.leerInt("Ingrese cantidad de stock del producto: ");

        service.agregarProducto(new Producto(nombre, precio, stock));
    }

    public static void listarProductos() {
        service.listarProductos();
    }

    public static void buscarActualizarProducto() {
        int id = Entrada.leerInt("Ingrese Id del producto a buscar: ");
        Producto p = service.buscarProducto(id);

        if (p != null) {
            System.out.println(p);
            String opcion = Entrada.leerString("Desea actualizar producto (s/n): ");
            if (opcion.equalsIgnoreCase("s")) {
                String nombre = Entrada.leerString("Ingrese nombre de producto: ");
                double precio = Entrada.leerDouble("Ingrese precio del producto: ");
                int stock = Entrada.leerInt("Ingrese cantidad de stock del producto: ");
                service.actualizarProducto(id, nombre, precio, stock);
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public static void eliminarProducto() {
        int id = Entrada.leerInt("Ingrese Id del producto a eliminar: ");
        service.eliminarProducto(id);
    }
}