/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superchino;

/**
 * Representa un producto del inventario. Al crearse (o al modificar el precio
 * base, la cantidad o el tipo) calcula automaticamente su precio bruto y la
 * ganancia esperada.
 */
public class Producto {

    private Supermercado supermercado;
    private Empleado empleado;
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precioBase;
    private TipoProducto tipo;
    private double precioBruto;
    private double gananciaEsperada;

    /**
     * Constructor con todos los datos que digita el usuario. El precio bruto y
     * la ganancia esperada se calculan dentro del constructor.
     *
     * @param supermercado super donde se carga el producto
     * @param empleado empleado que agrega el producto
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param cantidad cantidad de productos a ingresar
     * @param precioBase precio base de cada producto
     * @param tipo tipo de producto (Alimentos, Bebidas, Higiene, Limpieza)
     */
    public Producto(Supermercado supermercado, Empleado empleado, int codigo,
            String nombre, int cantidad, double precioBase, TipoProducto tipo) {
        this.supermercado = supermercado;
        this.empleado = empleado;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.tipo = tipo;
        calcularPrecioBruto();
        calcularGananciaEsperada();
    }

    /**
     * Calcula el precio bruto (precio final) segun el tipo de producto:
     * <ul>
     * <li>Alimentos: precioBase * 20% + precioBase</li>
     * <li>Bebidas: precioBase * 30% + precioBase</li>
     * <li>Higiene: precioBase * 25% + precioBase + 500</li>
     * <li>Limpieza: precioBase * 19% + precioBase * 4% + 1000 + precioBase</li>
     * </ul>
     */
    private void calcularPrecioBruto() {
        switch (tipo) {
            case Alimentos -> precioBruto = precioBase * 0.20 + precioBase;
            case Bebidas -> precioBruto = precioBase * 0.30 + precioBase;
            case Higiene -> precioBruto = precioBase * 0.25 + precioBase + 500;
            case Limpieza -> precioBruto = precioBase * 0.19 + precioBase * 0.04 + 1000 + precioBase;
        }
    }

    /**
     * Calcula la ganancia esperada: (precioBruto - precioBase) * cantidad.
     * Se debe llamar despues de calcular el precio bruto.
     */
    private void calcularGananciaEsperada() {
        gananciaEsperada = (precioBruto - precioBase) * cantidad;
    }

    /**
     * Devuelve los datos del producto en un texto.
     *
     * @param conSalto true para separar los datos con saltos de linea, false
     * para separarlos con comas
     * @return texto con toda la informacion del producto
     */
    public String obtenerDatos(boolean conSalto) {
        String separador = ", ";

        if (conSalto) {
            separador = "\n";
        }

        return "GANANCIA ESPERADA: "
                + "EMPLEADO: "
                + "SUPER: " + supermercado.getNombre() + " (Codigo: " + supermercado.getCodigo() + ")" + separador + empleado.getNombre() + " (Cedula: " + empleado.getCedula() + ")" + separador
                + "CODIGO PRODUCTO: " + codigo + separador
                + "NOMBRE: " + nombre + separador
                + "TIPO: " + tipo + separador
                + "CANTIDAD: " + cantidad + separador
                + "PRECIO BASE: " + String.format("%.2f", precioBase) + separador
                + "PRECIO BRUTO: " + String.format("%.2f", precioBruto) + separador + String.format("%.2f", gananciaEsperada);
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularGananciaEsperada();
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
        calcularPrecioBruto();
        calcularGananciaEsperada();
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
        calcularPrecioBruto();
        calcularGananciaEsperada();
    }

    public double getPrecioBruto() {
        return precioBruto;
    }

    public double getGananciaEsperada() {
        return gananciaEsperada;
    }

    @Override
    public String toString() {
        return "Producto{" + obtenerDatos(false) + '}';
    }
}
