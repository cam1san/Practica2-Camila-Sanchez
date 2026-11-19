/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.superchino;

import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        /**
     * Solicita un texto que no puede quedar vacio.
     *
     * @param mensaje mensaje que se le muestra al usuario
     * @return el texto digitado
     */
    public static String leerTexto(String mensaje) {
        String texto;
        do {
            texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null || texto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe digitar un valor.");
            }
        } while (texto == null || texto.trim().isEmpty());
        return texto.trim();
    }

    /**
     * Solicita un numero entero mayor que cero.
     *
     * @param mensaje mensaje que se le muestra al usuario
     * @return el numero digitado
     */
    public static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        do {
            String texto = JOptionPane.showInputDialog(mensaje);
            if (texto != null) {
                try {
                    numero = Integer.parseInt(texto.trim());
                    valido = numero > 0;
                } catch (NumberFormatException e) {
                    valido = false;
                }
            }
            if (!valido) {
                JOptionPane.showMessageDialog(null, "Debe digitar un numero entero mayor que cero.");
            }
        } while (!valido);
        return numero;
    }

    /**
     * Solicita un numero decimal mayor que cero. Acepta punto o coma como
     * separador decimal.
     *
     * @param mensaje mensaje que se le muestra al usuario
     * @return el numero digitado
     */
    public static double leerDecimal(String mensaje) {
        double numero = 0;
        boolean valido = false;
        do {
            String texto = JOptionPane.showInputDialog(mensaje);
            if (texto != null) {
                try {
                    numero = Double.parseDouble(texto.trim().replace(',', '.'));
                    valido = numero > 0;
                } catch (NumberFormatException e) {
                    valido = false;
                }
            }
            if (!valido) {
                JOptionPane.showMessageDialog(null, "Debe digitar un numero mayor que cero.");
            }
        } while (!valido);
        return numero;
    }

    /**
     * Le muestra al usuario un boton por cada tipo de producto para que
     * seleccione uno.
     *
     * @return el tipo de producto seleccionado
     */
    public static TipoProducto leerTipoProducto() {
        String tipos[] = {"Alimentos", "Bebidas", "Higiene", "Limpieza"};
        TipoProducto tipo = null;

        do {
            int valorBTN = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el tipo de producto:",
                    "Tipo de producto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tipos,
                    tipos[0]);

            switch (valorBTN) {
                case 0 -> tipo = TipoProducto.Alimentos;
                case 1 -> tipo = TipoProducto.Bebidas;
                case 2 -> tipo = TipoProducto.Higiene;
                case 3 -> tipo = TipoProducto.Limpieza;
                default -> JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de producto.");
            }
        } while (tipo == null);

        return tipo;
    }
    
}
