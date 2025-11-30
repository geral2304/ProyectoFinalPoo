/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Cristhiam Aponte
 */
public class Comprobante {
    private Venta venta;

    public Comprobante(Venta venta) {
        this.venta = venta;
    }

    public String generarTextoComprobante() {
        Cliente cliente = venta.getCotizacion().getCliente();
        Vehiculo vehiculo = venta.getCotizacion().getVehiculo();
        Empleado vendedor = venta.getCotizacion().getVendedor();
        double totalPagado = venta.getCotizacion().getMontoTotal();
        double precioBase = vehiculo.getPrecioBase();
        double descuento = precioBase - totalPagado;
        String fecha = venta.getFechaVenta();

        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("         COMPROBANTE DE VENTA\n");
        sb.append("           Concesionaria 'AutoFuturo'\n");
        sb.append("=========================================\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("-----------------------------------------\n");
        sb.append("DATOS DEL CLIENTE:\n");
        sb.append("  DNI: ").append(cliente.getDni()).append("\n");
        sb.append("  Nombres: ").append(cliente.getNombres()).append("\n");
        sb.append("  Apellidos: ").append(cliente.getApellidoPaterno()).append(" ").append(cliente.getApellidoMaterno()).append("\n");
        sb.append("-----------------------------------------\n");
        sb.append("DATOS DEL VEHÍCULO:\n");
        sb.append("  Código: ").append(vehiculo.getCodigoUnico()).append("\n");
        sb.append("  Marca: ").append(vehiculo.getMarca()).append("\n");
        sb.append("  Modelo: ").append(vehiculo.getModelo()).append("\n");
        sb.append("-----------------------------------------\n");
        sb.append("DETALLE DEL PAGO:\n");
        sb.append(String.format("  Precio Base:      S/ %,.2f\n", precioBase));
        sb.append(String.format("  Descuentos:       S/ %,.2f\n", descuento));
        sb.append(String.format("  TOTAL A PAGAR:    S/ %,.2f\n", totalPagado));
        sb.append("-----------------------------------------\n");
        sb.append("Vendido por: ").append(vendedor.getNombres()).append(" ").append(vendedor.getApellidos()).append("\n");
        sb.append("=========================================\n");

        return sb.toString();
    }
}

