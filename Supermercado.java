/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superchino;

/**
 * Representa el super donde se realiza la carga de productos.
 */
public class Supermercado {

    private String nombre;
    private int codigo;

    /**
     * Constructor con todos los datos del super.
     *
     * @param nombre nombre del super
     * @param codigo codigo del super
     */
    public Supermercado(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Supermercado{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
}
