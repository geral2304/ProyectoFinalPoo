/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Cristhiam Aponte
 */
public class ControladorClientes {
    private ArrayList<Cliente> clientes;

    public ControladorClientes() {
        clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarPorDNI(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }

    public boolean crearCliente(Cliente cliente) {
        if (buscarPorDNI(cliente.getDni()) != null) {
            System.err.println("Error de lógica: Se intentó crear un cliente que ya existe con DNI " + cliente.getDni());
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public boolean modificarCliente(int dni, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String telefono, String correoElectronico) {
        Cliente cliente = buscarPorDNI(dni);

        if (cliente == null) {
            System.err.println("Error: No se encontró el cliente a modificar con DNI " + dni);
            return false;
        }

        cliente.setNombres(nombres);
        cliente.setApellidoPaterno(apellidoPaterno);
        cliente.setApellidoMaterno(apellidoMaterno);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);

        return true;
    }

    public boolean eliminarCliente(int dni) {
        Cliente cliente = buscarPorDNI(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
