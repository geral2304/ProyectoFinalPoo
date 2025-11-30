/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Cristopher Pulido
 */
public class Pago {
    private Venta venta;
    private MetodoPago metodoPago;
    private double montoAbonado;
    private double saldoPendiente;

    public Pago(Venta venta, MetodoPago metodoPago, double montoAbonado) {
        this.venta = venta;
        this.metodoPago = metodoPago;
        this.montoAbonado = montoAbonado;
        this.saldoPendiente = venta.getCotizacion().getMontoTotal() - montoAbonado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void registrarPagoParcial(double monto) {
        this.montoAbonado += monto;
        this.saldoPendiente -= monto;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "venta=" + venta +
                ", metodoPago=" + metodoPago +
                ", montoAbonado=" + montoAbonado +
                ", saldoPendiente=" + saldoPendiente +
                '}';
    }
}