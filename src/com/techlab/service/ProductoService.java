package com.techlab.service;

import com.techlab.model.Producto;
import java.util.ArrayList;

public class ProductoService {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado");
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles");
        } else {
            productos.forEach(System.out::println);
        }
    }

    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void actualizarProducto(int id, String nombre, double precio, int stock) {
        Producto p = buscarProducto(id);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setStock(stock);
        System.out.println("Producto actualizado correctamente");
    }

    public void eliminarProducto(int id) {
        Producto p = buscarProducto(id);

        if (p != null) {
            productos.remove(p);
            System.out.println("Producto eliminado correctamente");
        } else {
            System.out.println("Producto no encontrado");
        }

    }
}
