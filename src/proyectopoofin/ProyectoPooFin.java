/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopoofin;

import clases.Administrador;
import clases.Cliente;
import clases.EstadoVehiculo;
import clases.Promocion;
import clases.TipoDescuento;
import clases.TipoVehiculo;
import clases.Vehiculo;
import clases.Vendedor;
import controladores.ControladorClientes;
import controladores.ControladorCotizaciones;
import controladores.ControladorEmpleados;
import controladores.ControladorLogin;
import controladores.ControladorPagos;
import controladores.ControladorPromociones;
import controladores.ControladorVehiculos;
import controladores.ControladorVentas;
import gui.Login;

/**
 *
 * @author Geraldine Acosta
 */
public class ProyectoPooFin {

   /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        ControladorEmpleados ctrlEmpleados = new ControladorEmpleados();
        ControladorVehiculos ctrlVehiculos = new ControladorVehiculos();
        ControladorClientes ctrlClientes = new ControladorClientes();
        ControladorPromociones ctrlPromociones = new ControladorPromociones();
        ControladorCotizaciones ctrlCotizaciones = new ControladorCotizaciones();
        ControladorVentas ctrlVentas = new ControladorVentas();
        ControladorPagos ctrlPagos = new ControladorPagos();
        ControladorLogin login = new ControladorLogin(ctrlEmpleados);
        
        Administrador adminDefault = new Administrador(12345678, "Administrador", "Sistema", "admin", "admin");
        Vendedor vendedorDefault = new Vendedor(87654321, "Vendedor", "Sistema", "vendedor", "vendedor");
        Vehiculo vehiculo1 = new Vehiculo("TOY-001", "Toyota", "Corolla", "Blanco", 2024, TipoVehiculo.SUV, 26000.00, EstadoVehiculo.DISPONIBLE);
        Cliente cliente1 = new Cliente(12345677, "Carlos", "Perez", "Gomez", "Av. Javier Prado 123", "999111222", "carlos@gmail.com");
        Promocion promo1 = new Promocion("VERANO2025", TipoDescuento.PORCENTAJE, 10.0, "01/01/2025", "31/12/2025");
        ctrlVehiculos.crearVehiculo(vehiculo1);
        ctrlClientes.crearCliente(cliente1);
        ctrlPromociones.crearPromocion(promo1);
        ctrlEmpleados.crearEmpleado(adminDefault);
        ctrlEmpleados.crearEmpleado(vendedorDefault);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login(
                        login,
                        ctrlEmpleados,
                        ctrlVehiculos,
                        ctrlClientes,
                        ctrlPromociones,
                        ctrlCotizaciones,
                        ctrlVentas,
                        ctrlPagos
                ).setVisible(true);
            }
        });
    }
}
