/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Geraldine Acosta
 */
public class Vehiculo {

    private String codigoUnico;
    private String marca;
    private String modelo;
    private String color;
    private int anioFabricacion;
    private TipoVehiculo tipo;
    private double precioBase;
    private EstadoVehiculo estado;

    public Vehiculo(String codigoUnico, String marca, String modelo, String color, int anioFabricacion, TipoVehiculo tipo, double precioBase, EstadoVehiculo estado) {
        this.codigoUnico = codigoUnico;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anioFabricacion = anioFabricacion;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{"
                + "codigoUnico='" + codigoUnico + '\''
                + ", marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", color='" + color + '\''
                + ", anioFabricacion=" + anioFabricacion
                + ", tipo=" + tipo
                + ", precioBase=" + precioBase
                + ", estado=" + estado
                + '}';
    }
}
