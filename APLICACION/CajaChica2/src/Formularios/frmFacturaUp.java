/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import Clases.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sofia
 */
public class frmFacturaUp extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmFacturaUp
     */
    public frmFacturaUp() {
        initComponents();
    }

    /* Definimos los titulos que llevara la tabla*/
    public String titulos[] = {"Nº", "Fecha", "Fecha Carga", "Proveedor", "Rif-Ced", "Empleado",
        "Servicio", "Descripcion", "Status", "Monto"};

    public String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    Datos datos = new Datos();

    DefaultTableModel tablaModelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int col) {

            if (col == 8) {
                return true;
            } else {
                return false;
            }
        }

    };

    /* Funcion para llenar la tabla cuando abre el formulario */
    public void llenarTabla() {

        try {

            /* Llamos a la funcion getFacturasReporte la cual nos devuelve todos 
             las facturas registrados en la base de datos. 
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
             */
            ResultSet rs = datos.getFacturaStatus();

            /* Instaciamos un obejto vector tipo string, el cual nos servira
             para guardar las filas de la tabla. */
            String registro[] = new String[11];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("n_factura");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("carga");
                registro[3] = rs.getString("nom_prove");
                registro[4] = rs.getString("rif_cedula");
                registro[5] = rs.getString("empleado");
                registro[6] = rs.getString("servicio");
                registro[7] = rs.getString("descripcion");
                registro[8] = rs.getString("status");
                registro[9] = rs.getString("monto");

                tablaModelo.addRow(registro);

            }

            tablaFacturas.setModel(tablaModelo);

        } catch (SQLException ex) {
            Logger.getLogger(frmProyectoUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* Funcion para llenar la tabla cuando se busque un usuario en especifico
     por el nombre */
    public void llenarTabla(String nombre) {

        try {
            /* Limpiamos la tabla */
            tablaModelo.setRowCount(0);

            /* Llamos a la funcion getFacturasReporteId la cual nos devuelve todos 
             las facturas relacionadas con el numero a buscar en la base de datos. 
            
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
            
             */
            ResultSet rs = datos.getFacturasStatusNombre(nombre);

            String registro[] = new String[10];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("n_factura");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("carga");
                registro[3] = rs.getString("nom_prove");
                registro[4] = rs.getString("rif_cedula");
                registro[5] = rs.getString("empleado");
                registro[6] = rs.getString("servicio");
                registro[7] = rs.getString("descripcion");
                registro[8] = rs.getString("status");
                registro[9] = rs.getString("monto");

                tablaModelo.addRow(registro);

            }

            tablaFacturas.setModel(tablaModelo);

        } catch (SQLException ex) {
            Logger.getLogger(frmFacturaUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        btnModificar = new org.edisoncor.gui.button.ButtonAction();
        btnCancelar = new org.edisoncor.gui.button.ButtonAction();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-sistema.png"))); // NOI18N

        labelMetric3.setText("Gestion de Facturas");
        labelMetric3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        labelMetric8.setText("Buscar:");
        labelMetric8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnModificar});

        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        panel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnModificar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        /* Cuando el usuario digite en el campo txt Buscar y tabulee
         llenamos la tabla con la busqueda */
        if (!txtBuscar.getText().equals("")) {

            llenarTabla(txtBuscar.getText());

        } else {
            /* Limpiamos la tabla */
            tablaModelo.setRowCount(0);
            llenarTabla();
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        /* Evento cuando el formulario se abra */
        llenarTabla();

    }//GEN-LAST:event_formInternalFrameOpened

    private void tablaFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturasMouseClicked


    }//GEN-LAST:event_tablaFacturasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        /* Variable que contendra el ID de la fila seleccionada */
        int s = 0, idsta = 0;

        /* Guardamos el ID de dla fila selecciona en la variable s*/
        s = tablaFacturas.getSelectedRow();

        /* Validamos que hallan seleccionado */
        if (s < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una factura ");
            return;
        }

        String status = (Utilidades.objectToString(tablaFacturas.getValueAt(s, 8)));

        
        int id = (Utilidades.objectToInt(tablaFacturas.getValueAt(s, 0)));

        int monto = (Utilidades.objectToInt(tablaFacturas.getValueAt(s, 9)));
                
        if (datos.getStatus(status)) {

            if (status.equals("Aprobado")) {
                idsta = 1;
            }

            if (status.equals("Rechazado")) {
                idsta = 2;
            }

            if (status.equals("En proceso")) {
                idsta = 3;
            }

            if (status.equals("Pagado")) {
                idsta = 4;
            }

            if (datos.modificarFactura(id, idsta)) {

                try {
                    JOptionPane.showMessageDialog(this, "El stauts ha sido modificado"
                            + " correctamente");
                    /* Limpiamos la tabla */
                    tablaModelo.setRowCount(0);
                    llenarTabla();

                    double reserva = 0, aprobadas = 0, supera = 0, pagadas=0;

                    ResultSet rs = datos.getMonto();

                    while (rs.next()) {
                        reserva = rs.getDouble("monto");
                    }

                    ResultSet rsApro = datos.getSumaMontoAprobadas();
                    while (rsApro.next()) {
                        aprobadas = rsApro.getDouble("total");
                    }
                    
                    ResultSet rsPaga = datos.getSumaMontoPagadas();
                    while (rsPaga.next()) {
                        pagadas = rsPaga.getDouble("total");
                    }
                    
                    if (aprobadas > reserva) {

                        supera = aprobadas - reserva;
                        JOptionPane.showMessageDialog(this, "La reserva es de " + reserva
                                + " ha sido superada  por la cantidad de: " + supera);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(frmFacturaUp.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(this, "No se ha podifo modificar el"
                        + "stauts, pro favor intentelo mas tarde");
                return;

            }

        } else {

            JOptionPane.showMessageDialog(this, "El stauts ingresado es incorrecto");
            return;
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnCancelar;
    private org.edisoncor.gui.button.ButtonAction btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaFacturas;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
