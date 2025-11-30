/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Empleado;
import clases.EstadoVehiculo;
import clases.Vehiculo;
import clases.Venta;
import java.util.ArrayList;

/**
 *
 * @author Cristopher Pulido
 */
public class Reportes {

    public static String reporteDeVehiculos(ControladorVehiculos controladorVehiculos) {
        StringBuilder sb = new StringBuilder(); 
        
        sb.append("================ REPORTE DE VEHÍCULOS ================\n");
        ArrayList<Vehiculo> vendidos = new ArrayList<>();
        ArrayList<Vehiculo> disponibles = new ArrayList<>();
        ArrayList<Vehiculo> reservados = new ArrayList<>();

        for (Vehiculo v : controladorVehiculos.getVehiculos()) {
            if (v.getEstado() == EstadoVehiculo.VENDIDO) {
                vendidos.add(v);
            } else if (v.getEstado() == EstadoVehiculo.DISPONIBLE) {
                disponibles.add(v);
            } else if (v.getEstado() == EstadoVehiculo.RESERVADO) {
                reservados.add(v);
            }
        }

        sb.append("\n--- Vehículos Vendidos (").append(vendidos.size()).append(") ---\n");
        if (vendidos.isEmpty()) {
            sb.append("Ninguno.\n");
        } else {
            sb.append(String.format("%-15s %-15s %-15s %-10s %-10s\n", "Código", "Marca", "Modelo", "Año", "Precio Base"));
            for (Vehiculo v : vendidos) {
                sb.append(String.format("%-15s %-15s %-15s %-10d S/ %-9.2f\n", v.getCodigoUnico(), v.getMarca(), v.getModelo(), v.getAnioFabricacion(), v.getPrecioBase()));
            }
        }

        sb.append("\n--- Vehículos Disponibles (").append(disponibles.size()).append(") ---\n");
        if (disponibles.isEmpty()) {
            sb.append("Ninguno.\n");
        } else {
            sb.append(String.format("%-15s %-15s %-15s %-10s %-10s\n", "Código", "Marca", "Modelo", "Año", "Precio Base"));
            for (Vehiculo v : disponibles) {
                sb.append(String.format("%-15s %-15s %-15s %-10d S/ %-9.2f\n", v.getCodigoUnico(), v.getMarca(), v.getModelo(), v.getAnioFabricacion(), v.getPrecioBase()));
            }
        }

        sb.append("\n--- Vehículos Reservados (").append(reservados.size()).append(") ---\n");
        if (reservados.isEmpty()) {
            sb.append("Ninguno.\n");
        } else {
            sb.append(String.format("%-15s %-15s %-15s %-10s %-10s\n", "Código", "Marca", "Modelo", "Año", "Precio Base"));
            for (Vehiculo v : reservados) {
                sb.append(String.format("%-15s %-15s %-15s %-10d S/ %-9.2f\n", v.getCodigoUnico(), v.getMarca(), v.getModelo(), v.getAnioFabricacion(), v.getPrecioBase()));
            }
        }
        sb.append("======================================================\n");

        return sb.toString(); // Devolvemos todo el texto acumulado
    }

    public static String reporteVentasPorVendedor(ControladorVentas controladorVentas, ControladorEmpleados controladorEmpleados, String fechaInicio, String fechaFin) {
        StringBuilder sb = new StringBuilder();

        sb.append("=========== REPORTE DE VENTAS POR VENDEDOR ===========\n");
        sb.append("Período: ").append(fechaInicio).append(" - ").append(fechaFin).append("\n");

        for (Empleado vendedor : controladorEmpleados.getEmpleados()) {
            if (vendedor.obtenerTipoEmpleado().equals("Vendedor")) {

                sb.append("\n--- Vendedor: ").append(vendedor.getNombres()).append(" ").append(vendedor.getApellidos()).append(" ---\n");

                int count = 0;
                double totalVendido = 0;
                sb.append(String.format("%-12s %-20s %-15s %-15s %-10s\n", "Fecha Venta", "Cliente (DNI)", "Vehículo", "Modelo", "Monto"));

                for (Venta venta : controladorVentas.getVentas()) {
                    if (venta.getCotizacion().getVendedor().equals(vendedor)) {
                        // Comparación de fechas como String (Cuidado: dd/mm/yyyy no se ordena bien lexicográficamente, pero mantengo tu lógica original)
                        if (venta.getFechaVenta().compareTo(fechaInicio) >= 0 && venta.getFechaVenta().compareTo(fechaFin) <= 0) {
                            sb.append(String.format("%-12s %-20s %-15s %-15s S/ %-9.2f\n",
                                    venta.getFechaVenta(),
                                    venta.getCotizacion().getCliente().getNombres() + " (" + venta.getCotizacion().getCliente().getDni() + ")",
                                    venta.getCotizacion().getVehiculo().getMarca(),
                                    venta.getCotizacion().getVehiculo().getModelo(),
                                    venta.getCotizacion().getMontoTotal()));
                            count++;
                            totalVendido += venta.getCotizacion().getMontoTotal();
                        }
                    }
                }

                if (count == 0) {
                    sb.append("Sin ventas en el período.\n");
                } else {
                    sb.append("-----------------------------------------------------------------\n");
                    sb.append(String.format("Total de Ventas: %d | Monto Total Vendido: S/ %.2f\n", count, totalVendido));
                }
            }
        }
        sb.append("======================================================\n");

        return sb.toString();
    }

    public static String reporteIngresosTotales(ControladorVentas controladorVentas) {
        StringBuilder sb = new StringBuilder();

        sb.append("========== REPORTE DE INGRESOS TOTALES ==========\n");
        double ingresosTotales = 0;
        double descuentosAplicados = 0;
        int totalVentas = controladorVentas.getVentas().size();

        sb.append(String.format("%-12s %-20s %-15s %-12s %-12s %-12s\n", "Fecha Venta", "Cliente", "Vehículo", "Precio Base", "Descuento", "Precio Final"));

        for (Venta venta : controladorVentas.getVentas()) {
            double precioBase = venta.getCotizacion().getVehiculo().getPrecioBase();
            double precioFinal = venta.getCotizacion().getMontoTotal();
            double descuento = precioBase - precioFinal;
            ingresosTotales += precioFinal;
            descuentosAplicados += descuento;

            sb.append(String.format("%-12s %-20s %-15s S/ %-11.2f S/ %-11.2f S/ %-11.2f\n",
                    venta.getFechaVenta(),
                    venta.getCotizacion().getCliente().getNombres(),
                    venta.getCotizacion().getVehiculo().getMarca(),
                    precioBase,
                    descuento,
                    precioFinal
            ));
        }
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append(String.format("Resumen: %d Ventas | Ingresos Totales: S/ %.2f | Descuentos Totales: S/ %.2f\n", totalVentas, ingresosTotales, descuentosAplicados));
        sb.append("===================================================\n");

        return sb.toString();
    }
}
