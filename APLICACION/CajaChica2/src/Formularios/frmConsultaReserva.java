/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofia
 */
public class frmConsultaReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsultaReserva
     */
    public frmConsultaReserva() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtAprobadas = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        txtReserva = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        btnCancelar = new org.edisoncor.gui.button.ButtonAction();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        txtReservaNegativa = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        txtReservaPositiva = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        txtPagadas = new org.edisoncor.gui.textField.TextFieldRoundIcon();

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

        labelMetric5.setText("Consulta de Reserva");
        labelMetric5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        txtAprobadas.setEnabled(false);
        txtAprobadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAprobadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAprobadasKeyTyped(evt);
            }
        });

        labelMetric6.setText("Monto Facturas Aprobadas:");
        labelMetric6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        labelMetric3.setText("Reserva:");
        labelMetric3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtReserva.setEnabled(false);
        txtReserva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtReserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReservaKeyTyped(evt);
            }
        });

        btnCancelar.setText("Finalizar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        labelMetric7.setText("Reserva Negativa:");
        labelMetric7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtReservaNegativa.setEnabled(false);
        txtReservaNegativa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtReservaNegativa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReservaNegativaKeyTyped(evt);
            }
        });

        labelMetric8.setText("Reserva Positiva:");
        labelMetric8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtReservaPositiva.setEnabled(false);
        txtReservaPositiva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtReservaPositiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReservaPositivaKeyTyped(evt);
            }
        });

        labelMetric9.setText("Monto Facturas Pagadas:");
        labelMetric9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtPagadas.setEnabled(false);
        txtPagadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPagadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagadasActionPerformed(evt);
            }
        });
        txtPagadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagadasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(122, 122, 122))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtReservaNegativa, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtReservaPositiva, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPagadas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAprobadas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAprobadas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPagadas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReservaNegativa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReservaPositiva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

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

    private void txtAprobadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAprobadasKeyTyped
        /* Funcion para validar que solo ingresen numeros */
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();
        }

        if (Character.isWhitespace(evt.getKeyChar())) {
            evt.consume();
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAprobadasKeyTyped

    private void txtReservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReservaKeyTyped
        /* Funcion para validar que solo ingresen numeros */
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();
        }

        if (Character.isWhitespace(evt.getKeyChar())) {
            evt.consume();
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtReservaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtReservaNegativaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReservaNegativaKeyTyped
        /* Funcion para validar que solo ingresen numeros */
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();
        }

        if (Character.isWhitespace(evt.getKeyChar())) {
            evt.consume();
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtReservaNegativaKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       try {
            /* Instanciamos el objetos Datos */
            Datos datos = new Datos();
            
            double reserva = 0, aprobadas = 0, negativa=0, positiva=0, pagadas =0;

            ResultSet rs = datos.getMonto();

            while (rs.next()) {
                txtReserva.setText("");
                txtReserva.setText(rs.getString("monto"));
                reserva = rs.getDouble("monto");
            }
            
            ResultSet rsApro = datos.getSumaMontoAprobadas();

            while (rsApro.next()) {
                txtAprobadas.setText("");
                txtAprobadas.setText(rsApro.getString("total"));
                aprobadas = rsApro.getDouble("total");
            }
            
            ResultSet rsPago = datos.getSumaMontoPagadas();

            while (rsPago.next()) {
                txtPagadas.setText("");
                txtPagadas.setText(rsPago.getString("total"));
                pagadas = rsPago.getDouble("total");
            }
            
            negativa = reserva - (aprobadas - pagadas);
            
            if(negativa < 0){
                txtReservaNegativa.setText("" + negativa);
            } else {
                txtReservaNegativa.setText("0");
            }
            
            positiva = reserva - (aprobadas - pagadas);
            
            if(positiva > 0){
                txtReservaPositiva.setText("" + positiva);
            } else {
                txtReservaPositiva.setText("0");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtReservaPositivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReservaPositivaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReservaPositivaKeyTyped

    private void txtPagadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagadasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagadasKeyTyped

    private void txtPagadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnCancelar;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtAprobadas;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtPagadas;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtReserva;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtReservaNegativa;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtReservaPositiva;
    // End of variables declaration//GEN-END:variables
}
