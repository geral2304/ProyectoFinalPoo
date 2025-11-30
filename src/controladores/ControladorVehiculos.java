/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.EstadoVehiculo;
import clases.TipoVehiculo;
import clases.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Geraldine Acosta
 */
public class ControladorVehiculos {
    private ArrayList<Vehiculo> vehiculos;

    public ControladorVehiculos() {
        vehiculos = new ArrayList<>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Vehiculo buscarPorCodigo(String codigoUnico) {
        for (Vehiculo vehiculo : vehiculos) {
            if (codigoUnico.equals(vehiculo.getCodigoUnico())) {
                return vehiculo;
            }
        }
        return null;
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        if (buscarPorCodigo(vehiculo.getCodigoUnico()) != null) {
            System.err.println("Error de lógica: Se intentó crear un vehículo que ya existe con código " + vehiculo.getCodigoUnico());
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }

    public boolean modificarVehiculo(String codigoUnico, String marca, String modelo, String color, int anioFabricacion, TipoVehiculo tipo, double precioBase, EstadoVehiculo estado) {
        Vehiculo vehiculo = buscarPorCodigo(codigoUnico);

        if (vehiculo == null) {
            System.err.println("Error: No se encontró el vehículo a modificar con código " + codigoUnico);
            return false;
        }

        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setColor(color);
        vehiculo.setAnioFabricacion(anioFabricacion);
        vehiculo.setTipo(tipo);
        vehiculo.setPrecioBase(precioBase);
        vehiculo.setEstado(estado);

        return true;
    }

    public boolean eliminarVehiculo(String codigoUnico) {
        Vehiculo vehiculo = buscarPorCodigo(codigoUnico);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            return true;
        }
        return false;
    }

    public void listarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }
}