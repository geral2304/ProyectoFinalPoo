/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Cotizacion;
import clases.Venta;
import java.util.ArrayList;

/**
 *
 * @author Cristhiam Aponte
 */
public class ControladorVentas {
    private ArrayList<Venta> ventas;

    public ControladorVentas() {
        ventas = new ArrayList<>();
    }

    public Venta registrarVenta(Cotizacion cotizacion, String fechaVenta) {
        if (cotizacion.getVehiculo().getEstado() == clases.EstadoVehiculo.VENDIDO) {
            System.err.println("Error: El vehículo de esta cotización ya ha sido vendido.");
            return null;
        }
        Venta nuevaVenta = new Venta(cotizacion, fechaVenta);
        ventas.add(nuevaVenta);
        return nuevaVenta;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void listarVentas() {
        for (Venta venta : ventas) {
            System.out.println(venta);
        }
    }
}
