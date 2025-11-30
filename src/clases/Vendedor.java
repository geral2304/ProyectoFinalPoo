/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Geraldine Acosta
 */
public class Vendedor extends Empleado {
    public Vendedor(int DNI, String nombres, String apellidos, String usuario, String password) {
        super(DNI, nombres, apellidos, RolEmpleado.VENDEDOR, usuario, password);
    }

    @Override
    public String obtenerTipoEmpleado() {
        return "Vendedor";
    }
}
