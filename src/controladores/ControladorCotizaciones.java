/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Cliente;
import clases.Cotizacion;
import clases.Empleado;
import clases.Promocion;
import clases.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Cristhiam Aponte
 */
public class ControladorCotizaciones {
    private ArrayList<Cotizacion> cotizaciones;
    private int proximoId = 1;


    public ControladorCotizaciones() {
        this.cotizaciones = new ArrayList<>();
    }

    public boolean crearCotizacion(Cliente cliente, Empleado vendedor, Vehiculo vehiculo, Promocion promocion, String fecha) {
        if (vehiculo.getEstado() != clases.EstadoVehiculo.DISPONIBLE) {
            System.err.println("El vehículo no está disponible para cotización.");
            return false;
        }

        double precioFinal = vehiculo.getPrecioBase();
        if (promocion != null) {
            precioFinal = promocion.aplicarDescuento(precioFinal);
        }

        Cotizacion nuevaCotizacion = new Cotizacion(cliente, vendedor, vehiculo, precioFinal, fecha);
        this.cotizaciones.add(nuevaCotizacion);
        return true;
    }

    public ArrayList<Cotizacion> getCotizaciones() {
        return cotizaciones;
    }

    public void listarCotizaciones() {
        for (Cotizacion cotizacion : cotizaciones) {
            System.out.println(cotizacion);
        }
    }
}