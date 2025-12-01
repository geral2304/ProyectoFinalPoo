/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import clases.Cliente;
import clases.Empleado;
import clases.EstadoVehiculo;
import clases.Promocion;
import clases.Vehiculo;
import controladores.ControladorClientes;
import controladores.ControladorCotizaciones;
import controladores.ControladorPromociones;
import controladores.ControladorVehiculos;
import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhiam Aponte
 */
public class CrearCotizacionPanel extends javax.swing.JFrame {

    ControladorClientes ctrlClientes;
    ControladorVehiculos ctrlVehiculos;
    ControladorCotizaciones ctrlCotizaciones;
    ControladorPromociones ctrlPromociones;
    Empleado vendedorLogueado;

    /**
     * Creates new form CrearCotizacionPanel
     */
    public CrearCotizacionPanel(Empleado vendedor, ControladorClientes ctrlClientes, ControladorVehiculos ctrlVehiculos, ControladorCotizaciones ctrlCotizaciones, ControladorPromociones ctrlPromociones) {
        this.vendedorLogueado = vendedor;
        this.ctrlClientes = ctrlClientes;
        this.ctrlVehiculos = ctrlVehiculos;
        this.ctrlCotizaciones = ctrlCotizaciones;
        this.ctrlPromociones = ctrlPromociones;

        initComponents();

        getContentPane().setBackground(new Color(230, 240, 255));
        setLocationRelativeTo(null);

        fechaField.setText("dd/mm/yyyy");

        cargarDatos();
    }

    private void cargarDatos() {
        clienteComboBox.setModel(new DefaultComboBoxModel<>(new Vector<>(ctrlClientes.getClientes())));

        clienteComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente c = (Cliente) value;
                    setText(c.getNombres() + " " + c.getApellidoPaterno() + " (DNI: " + c.getDni() + ")");
                }
                return this;
            }
        });

        Vector<Vehiculo> vehiculosDisponibles = new Vector<>();
        for (Vehiculo v : ctrlVehiculos.getVehiculos()) {
            if (v.getEstado() == EstadoVehiculo.DISPONIBLE) {
                vehiculosDisponibles.add(v);
            }
        }
        vehiculoComboBox.setModel(new DefaultComboBoxModel<>(vehiculosDisponibles));

        vehiculoComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Vehiculo) {
                    Vehiculo v = (Vehiculo) value;
                    setText(v.getMarca() + " " + v.getModelo() + " - " + v.getColor());
                }
                return this;
            }
        });

        Vector<Promocion> promociones = new Vector<>();
        promociones.add(null);
        promociones.addAll(ctrlPromociones.getPromociones());
        promocionComboBox.setModel(new DefaultComboBoxModel<>(promociones));

        promocionComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Promocion) {
                    setText(((Promocion) value).getNombre());
                } else if (value == null) {
                    setText("--- Sin Promoción ---");
                }
                return this;
            }
        });
    }

    private String formatoComparable(String fechaDdMmYyyy) {
        if (fechaDdMmYyyy == null || !fechaDdMmYyyy.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return "";
        }
        String[] partes = fechaDdMmYyyy.split("/");
        return partes[2] + partes[1] + partes[0];
    }

    private boolean isFechaEnRango(String fecha, String fechaInicio, String fechaFin) {
        String fActual = formatoComparable(fecha);
        String fInicio = formatoComparable(fechaInicio);
        String fFin = formatoComparable(fechaFin);

        if (fActual.isEmpty() || fInicio.isEmpty() || fFin.isEmpty()) {
            return false;
        }

        return fActual.compareTo(fInicio) >= 0 && fActual.compareTo(fFin) <= 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        cotizacionButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        precioButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaField = new javax.swing.JTextField();
        precioLabel = new javax.swing.JLabel();
        clienteComboBox = new javax.swing.JComboBox<>();
        vehiculoComboBox = new javax.swing.JComboBox<>();
        promocionComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel7.setText("Crear Nueva Cotización");

        cotizacionButton.setBackground(new java.awt.Color(100, 150, 255));
        cotizacionButton.setForeground(new java.awt.Color(255, 255, 255));
        cotizacionButton.setText("Crear Cotización");
        cotizacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cotizacionButtonActionPerformed(evt);
            }
        });

        regresarButton.setBackground(new java.awt.Color(100, 150, 255));
        regresarButton.setForeground(new java.awt.Color(255, 255, 255));
        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        precioButton.setBackground(new java.awt.Color(100, 150, 255));
        precioButton.setForeground(new java.awt.Color(255, 255, 255));
        precioButton.setText("Calcular Precio");
        precioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel2.setText("Vehiculo Disponible:");

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel3.setText("Promoción (Opcional):");

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel4.setText("Fecha (dd/mm/yyyy):");

        precioLabel.setText("Precio Final:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(regresarButton))
                        .addContainerGap(619, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(precioLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(precioButton)
                                .addGap(66, 66, 66)
                                .addComponent(cotizacionButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fechaField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(promocionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vehiculoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(241, 241, 241))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promocionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addComponent(precioLabel)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioButton)
                    .addComponent(cotizacionButton))
                .addGap(32, 32, 32)
                .addComponent(regresarButton)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(jLabel1)
                    .addContainerGap(297, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cotizacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cotizacionButtonActionPerformed
        Cliente cliente = (Cliente) clienteComboBox.getSelectedItem();
        Vehiculo vehiculo = (Vehiculo) vehiculoComboBox.getSelectedItem();
        Promocion promocion = (Promocion) promocionComboBox.getSelectedItem();
        String fecha = fechaField.getText();

        if (cliente == null || vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "La fecha es obligatoria (dd/mm/yyyy).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (promocion != null && !isFechaEnRango(fecha, promocion.getFechaInicio(), promocion.getFechaFin())) {
            JOptionPane.showMessageDialog(this, "No se puede crear. La fecha no coincide con la promoción.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean exito = ctrlCotizaciones.crearCotizacion(cliente, vendedorLogueado, vehiculo, promocion, fecha);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Cotización creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatos();
            fechaField.setText("");
            precioLabel.setText("Precio Final:");
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear la cotización.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cotizacionButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void precioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioButtonActionPerformed
        Vehiculo vehiculo = (Vehiculo) vehiculoComboBox.getSelectedItem();
        Promocion promocion = (Promocion) promocionComboBox.getSelectedItem();
        String fecha = fechaField.getText(); // Usamos aMaternoField como Fecha

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vehículo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precioFinal = vehiculo.getPrecioBase();

        if (promocion != null) {
            if (isFechaEnRango(fecha, promocion.getFechaInicio(), promocion.getFechaFin())) {
                precioFinal = promocion.aplicarDescuento(precioFinal);
                JOptionPane.showMessageDialog(this, "¡Promoción aplicada correctamente!");
            } else {
                JOptionPane.showMessageDialog(this, "La fecha está fuera del rango de la promoción.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        precioLabel.setText("Precio Final: S/ " + String.format("%.2f", precioFinal));
    }//GEN-LAST:event_precioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Cliente> clienteComboBox;
    private javax.swing.JButton cotizacionButton;
    private javax.swing.JTextField fechaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton precioButton;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JComboBox<Promocion> promocionComboBox;
    private javax.swing.JButton regresarButton;
    private javax.swing.JComboBox<Vehiculo> vehiculoComboBox;
    // End of variables declaration//GEN-END:variables
}
