/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.superchino;

import javax.swing.JOptionPane;

/**
 * Controla el flujo completo del sistema de inventario del Super Chino: pide
 * los datos del super y del empleado, carga los productos y muestra el
 * resultado final.
 */
public class SistemaInventario1 {

    private Supermercado supermercado;
    private Empleado empleado;
    private UtilVectorProducto inventario;

    /**
     * Ejecuta todo el sistema de principio a fin.
     */
    public void iniciar() {
        JOptionPane.showMessageDialog(null, "=== SISTEMA DE INVENTARIO SUPER CHINO ===");

        solicitarDatosSupermercado();
        solicitarDatosEmpleado();

        int tamano = Entrada.leerEntero("Cuantos productos diferentes desea ingresar?");
        inventario = new UtilVectorProducto(supermercado, empleado, tamano);

        inventario.llenarVector();
        inventario.mostrarReporte();

        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
    }

    /**
     * Solicita el nombre y el codigo del super donde se realiza la carga.
     */
    public void solicitarDatosSupermercado() {
        String nombre = Entrada.leerTexto("Digite el nombre del super:");
        int codigo = Entrada.leerEntero("Digite el codigo del super:");
        supermercado = new Supermercado(nombre, codigo);
    }

    /**
     * Solicita el nombre y la cedula del empleado que realiza la carga.
     */
    public void solicitarDatosEmpleado() {
        String nombre = Entrada.leerTexto("Digite el nombre del empleado:");
        int cedula = Entrada.leerEntero("Digite la cedula del empleado:");
        empleado = new Empleado(nombre, cedula);
    }
}  
