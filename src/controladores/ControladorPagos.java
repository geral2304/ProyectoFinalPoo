/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.MetodoPago;
import clases.Pago;
import clases.Venta;
import java.util.ArrayList;

/**
 *
 * @author Cristopher Pulido
 */
public class ControladorPagos {
    private ArrayList<Pago> pagos;

    public ControladorPagos() {
        pagos = new ArrayList<>();
    }

    public boolean registrarPago(Venta venta, MetodoPago metodoPago, double montoAbonado) {
        if (montoAbonado > venta.getCotizacion().getMontoTotal()) {
            System.err.println("Error: El monto abonado no puede ser mayor al total de la venta.");
            return false;
        }

        Pago nuevoPago = new Pago(venta, metodoPago, montoAbonado);
        pagos.add(nuevoPago);
        return true;
    }

    public Pago buscarPagoPorVenta(Venta venta) {
        for (Pago pago : pagos) {
            if (pago.getVenta().equals(venta)) {
                return pago;
            }
        }
        return null;
    }

    public boolean registrarPagoParcial(Venta venta, double monto) {
        Pago pagoExistente = buscarPagoPorVenta(venta);
        if (pagoExistente != null) {
            if (monto > pagoExistente.getSaldoPendiente()) {
                System.err.println("Error: El monto del pago parcial no puede ser mayor al saldo pendiente.");
                return false;
            }
            pagoExistente.registrarPagoParcial(monto);
            return true;
        } else {
            System.err.println("Error: No se encontró un pago inicial para la venta especificada. Registre un pago inicial primero.");
            return false;
        }
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void listarPagos() {
        for (Pago pago : pagos) {
            System.out.println(pago);
        }
    }
}