/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Christiam Aponte
 */
public class Cotizacion {
    private Cliente cliente;
    private Empleado vendedor;
    private Vehiculo vehiculo;
    private double montoTotal;
    private String fecha;

    public Cotizacion(Cliente cliente, Empleado vendedor, Vehiculo vehiculo, double montoTotal, String fecha) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.vehiculo = vehiculo;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "cliente=" + cliente.getNombres() +
                ", vendedor=" + vendedor.getNombres() +
                ", vehiculo=" + vehiculo.getMarca() + " " + vehiculo.getModelo() +
                ", montoTotal=" + montoTotal +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}