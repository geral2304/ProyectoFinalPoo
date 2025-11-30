/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Geraldine Acosta
 */
public class Administrador extends Empleado {
    public Administrador(int DNI, String nombres, String apellidos, String usuario, String password) {
        super(DNI, nombres, apellidos, RolEmpleado.ADMINISTRADOR, usuario, password);
    }

    @Override
    public String obtenerTipoEmpleado() {
        return "Administrador";
    }
}

