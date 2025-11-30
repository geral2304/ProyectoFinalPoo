/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import clases.Empleado;

/**
 *
 * @author Geraldine Acosta
 */
public class ControladorLogin {

    private ControladorEmpleados controladorEmpleados;

    public ControladorLogin(ControladorEmpleados controladorEmpleados) {
        this.controladorEmpleados = controladorEmpleados;
    }

    public Empleado autenticar(String usuario, String password) {
        Empleado empleado = controladorEmpleados.buscarPorUsuario(usuario);
        if (empleado != null && empleado.checkPassword(password)) {
            return empleado;
        }
        return null;
    }
}
