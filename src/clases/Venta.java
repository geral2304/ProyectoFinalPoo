/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Cristhiam Aponte
 */
public class Venta {
    private Cotizacion cotizacion;
    private String fechaVenta; // dd/mm/yyyy

    public Venta(Cotizacion cotizacion, String fechaVenta) {
        this.cotizacion = cotizacion;
        this.fechaVenta = fechaVenta;
        this.cotizacion.getVehiculo().setEstado(EstadoVehiculo.VENDIDO);
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "cotizacion=" + cotizacion +
                ", fechaVenta='" + fechaVenta + '\'' +
                '}';
    }
}