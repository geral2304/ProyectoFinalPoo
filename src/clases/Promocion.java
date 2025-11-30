/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Cristopher Pulido
 */
public class Promocion {
    private String nombre;
    private TipoDescuento tipo;
    private double valor;
    private String fechaInicio;
    private String fechaFin;    

    public Promocion(String nombre, TipoDescuento tipo, double valor, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDescuento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDescuento tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double aplicarDescuento(double precio) {
        if (tipo == TipoDescuento.PORCENTAJE) {
            return precio - (precio * valor / 100);
        } else if (tipo == TipoDescuento.MONTO_FIJO) {
            return precio - valor;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}

