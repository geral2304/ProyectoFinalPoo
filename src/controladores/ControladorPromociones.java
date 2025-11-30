/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Promocion;
import clases.TipoDescuento;
import java.util.ArrayList;

/**
 *
 * @author Cristopher Pulido
 */
public class ControladorPromociones {
    private ArrayList<Promocion> promociones;

    public ControladorPromociones() {
        promociones = new ArrayList<>();
    }

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

    public Promocion buscarPorNombre(String nombre) {
        for (Promocion promocion : promociones) {
            if (promocion.getNombre().equals(nombre)) {
                return promocion;
            }
        }
        return null;
    }

    public boolean crearPromocion(Promocion promocion) {
        if (buscarPorNombre(promocion.getNombre()) != null) {
            System.err.println("Error: Ya existe una promoción con el nombre " + promocion.getNombre());
            return false;
        }
        promociones.add(promocion);
        return true;
    }

    public boolean modificarPromocion(String nombre, TipoDescuento tipo, double valor, String fechaInicio, String fechaFin) {
        Promocion promocion = buscarPorNombre(nombre);
        if (promocion == null) {
            System.err.println("Error: No se encontró la promoción a modificar con nombre " + nombre);
            return false;
        }

        promocion.setTipo(tipo);
        promocion.setValor(valor);
        promocion.setFechaInicio(fechaInicio);
        promocion.setFechaFin(fechaFin);

        return true;
    }

    public boolean eliminarPromocion(String nombre) {
        Promocion promocion = buscarPorNombre(nombre);
        if (promocion != null) {
            promociones.remove(promocion);
            return true;
        }
        return false;
    }

    public void listarPromociones() {
        for (Promocion promocion : promociones) {
            System.out.println(promocion);
        }
    }
}

