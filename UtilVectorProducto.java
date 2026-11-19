/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superchino;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Maneja el arreglo de productos del inventario: permite llenarlo, mostrarlo y
 * calcular la ganancia total esperada.
 */
public class UtilVectorProducto {

    private final Producto[] productos;
    private int cantidad; // Variable de control: productos agregados hasta el momento.
    private final Supermercado supermercado;
    private final Empleado empleado;

    /**
     * Crea el arreglo de productos con el tamano indicado.
     *
     * @param supermercado super donde se realiza la carga
     * @param empleado empleado que realiza la carga
     * @param tamano cantidad de productos que tendra el arreglo
     */
    public UtilVectorProducto(Supermercado supermercado, Empleado empleado, int tamano) {
        this.supermercado = supermercado;
        this.empleado = empleado;
        this.productos = new Producto[tamano];
        this.cantidad = 0;
    }

    /**
     * Recorre el arreglo y le solicita al usuario los datos de cada producto.
     */
    public void llenarVector() {
        for (int i = 0; i < productos.length; i++) {
            JOptionPane.showMessageDialog(null, "Se solicitaran los datos del producto "
                    + (i + 1) + " de " + productos.length);
            agregarProducto();
        }
    }

    /**
     * Solicita los datos de un producto, lo crea (calculando su precio bruto y
     * su ganancia) y lo guarda en la siguiente posicion libre del arreglo.
     */
    public void agregarProducto() {
        if (cantidad == productos.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar mas productos.\n"
                    + "Capacidad [" + cantidad + "] maxima alcanzada.");
            return;
        }

        int codigo;
        do {
            codigo = Entrada.leerEntero("Digite el codigo del producto:");
            if (existeCodigo(codigo)) {
                JOptionPane.showMessageDialog(null, "El codigo " + codigo + " ya fue ingresado.");
            }
        } while (existeCodigo(codigo));

        String nombre = Entrada.leerTexto("Digite el nombre del producto:");
        int cantidadProductos = Entrada.leerEntero("Digite la cantidad de productos a ingresar:");
        double precioBase = Entrada.leerDecimal("Digite el precio base del producto:");
        TipoProducto tipo = (TipoProducto) Entrada.leerTipoProducto();

        productos[cantidad] = new Producto(supermercado, empleado, codigo, nombre,
                cantidadProductos, precioBase, tipo);
        cantidad++;
    }

    /**
     * Verifica si un codigo de producto ya existe en el arreglo.
     *
     * @param codigo codigo que se desea buscar
     * @return true si el codigo ya existe, false si no
     */
    public boolean existeCodigo(int codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Suma la ganancia esperada de todos los productos agregados.
     *
     * @return ganancia total esperada
     */
    public double calcularGananciaTotal() {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += productos[i].getGananciaEsperada();
        }
        return total;
    }

    /**
     * Arma el reporte con todos los productos agregados y la ganancia total.
     *
     * @return texto del reporte
     */
    public String generarReporte() {
        if (cantidad == 0) {
            return "No hay productos en el sistema.";
        }

        String reporte = "===== INVENTARIO SUPER CHINO =====\n\n";
        for (int i = 0; i < cantidad; i++) {
            reporte += "--- Producto " + (i + 1) + " ---\n"
                    + productos[i].obtenerDatos(true) + "\n\n";
        }
        reporte += """
                   ==================================
                   GANANCIA TOTAL ESPERADA: """ + String.format("%.2f", calcularGananciaTotal());
        return reporte;
    }

    /**
     * Muestra el reporte en pantalla. Se usa una barra de desplazamiento por si
     * son muchos productos.
     */
    public void mostrarReporte() {
        JTextArea area = new JTextArea(generarReporte(), 22, 40);
        area.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(area),
                "Productos agregados", JOptionPane.INFORMATION_MESSAGE);
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidad() {
        return cantidad;
    }
}
