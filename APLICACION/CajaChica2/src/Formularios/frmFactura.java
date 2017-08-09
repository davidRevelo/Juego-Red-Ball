/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import Clases.Factura;
import Clases.Opcion;
import Clases.Utilidades;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sofia
 */
public class frmFactura extends javax.swing.JInternalFrame {

    public frmFactura() {
        initComponents();
    }

    public String usuario;
    public Integer perfil;
    public String cargo;
    public Integer id;

    public void setUsuario(String usuario, int id, int perfil, String cargo) {
        this.usuario = usuario;
        this.id = id;
        this.perfil = perfil;
        this.cargo = cargo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric12 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric21 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric15 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric13 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric14 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric16 = new org.edisoncor.gui.label.LabelMetric();
        dchCarga = new com.toedter.calendar.JDateChooser();
        dchFactura = new com.toedter.calendar.JDateChooser();
        txtIDFactura = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        cmbServicios = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbStatus = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtMonto = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescrip = new javax.swing.JTextArea();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbProveedor = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbEmpleado = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric17 = new org.edisoncor.gui.label.LabelMetric();
        txtNFactura = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        cmbGerente = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric11 = new org.edisoncor.gui.label.LabelMetric();

        setClosable(true);
        setIconifiable(true);
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

        labelMetric12.setText("Status:");

        labelMetric9.setText("Empleado:");

        labelMetric8.setText("Proveedor:");

        labelMetric21.setText("Fecha de Carga:");

        labelMetric15.setText("Fecha de Factura:");

        labelMetric10.setText("ID Factura:");

        labelMetric1.setText("Registro de Facturas");
        labelMetric1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        labelMetric13.setText("Servicio:");

        labelMetric14.setText("Descripción:");

        labelMetric16.setText("Monto:");

        dchCarga.setEnabled(false);

        dchFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dchFacturaKeyTyped(evt);
            }
        });

        txtIDFactura.setEnabled(false);

        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        areaDescrip.setColumns(20);
        areaDescrip.setRows(5);
        jScrollPane1.setViewportView(areaDescrip);

        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro-factura-48.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross-48.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        labelMetric17.setText("Nº Factura");

        txtNFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNFacturaFocusLost(evt);
            }
        });
        txtNFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNFacturaKeyTyped(evt);
            }
        });

        labelMetric11.setText("Gerente:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 34, Short.MAX_VALUE)
                                .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMetric17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIDFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMetric15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dchFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dchCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(418, 418, 418)
                                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(413, 413, 413)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dchCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar))
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        /* Funcion para validar que solo ingresen numeros */
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }

        if (txtMonto.getText().length() >= 6) {
            evt.consume();
        }

    }//GEN-LAST:event_txtMontoKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        /* Evento de click sobre el boton de REGISTRAR EMPLEADO */

 /* Instanciamos un objeto de la Clase Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtIDFactura.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el ID de la factura");
            txtIDFactura.requestFocusInWindow();
            return;
        }

        if (dchFactura.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la fecha de la factura");
            dchFactura.requestFocusInWindow();
            return;
        }

        if (dchFactura.getDate().after(dchCarga.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "La fecha no puede ser mayor a la de hoy");
            dchFactura.requestFocusInWindow();
            return;
        }

        if (dchCarga.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una fecha de carga");
            dchCarga.requestFocusInWindow();
            return;
        }

        if (txtNFactura.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el Numero de la factura");
            txtNFactura.requestFocusInWindow();
            return;
        }

        if (!txtNFactura.getText().equals("")) {

            if (datos.getNumeroFac(Integer.parseInt(txtNFactura.getText()))) {
                JOptionPane.showMessageDialog(this, "El numero de la factura ya se "
                        + "encuentra registrado. ");
                txtNFactura.setText("");
                txtNFactura.requestFocusInWindow();
                return;
            }

        }

        if (((Opcion) cmbGerente.getSelectedItem()).getDescripcion().equals("Seleccione un Gerente")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un Gerente");
            cmbGerente.requestFocusInWindow();
            return;
        }

        if (cmbServicios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un servicio");
            cmbServicios.requestFocusInWindow();
            return;
        }

        if (cmbProveedor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un proveedor");
            cmbProveedor.requestFocusInWindow();
            return;
        }

        if (((Opcion) cmbEmpleado.getSelectedItem()).getDescripcion().equals("Seleccione un Empleado")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un Empleado");
            cmbEmpleado.requestFocusInWindow();
            return;
        }

        if (areaDescrip.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una descripcion ");
            areaDescrip.requestFocusInWindow();
            return;
        }

        if (txtMonto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un monto");
            txtMonto.requestFocusInWindow();
            return;
        }

        int ready = JOptionPane.showConfirmDialog(this, "Verifique que sus datos sean correctos, "
                + "Si lo son presione el boton de si");

        if (ready == 1 || ready == 2) {
            return;
        }

        /* Instanciamos un objeto de la Clase Factura, el cual se lo pasaremos
         a la funcion agregarFactura, la cual pide como parametro un objeto Factura */
        Factura factura = new Factura(
                Integer.parseInt(txtIDFactura.getText()),
                Integer.parseInt(txtNFactura.getText()),
                dchFactura.getDate(),
                dchCarga.getDate(),
                Integer.parseInt(((Opcion) cmbProveedor.getSelectedItem()).getValor()),
                Integer.parseInt(((Opcion) cmbEmpleado.getSelectedItem()).getValor()),
                Integer.parseInt(((Opcion) cmbGerente.getSelectedItem()).getValor()),
                Integer.parseInt(((Opcion) cmbServicios.getSelectedItem()).getValor()),
                areaDescrip.getText(),
                Integer.parseInt(((Opcion) cmbStatus.getSelectedItem()).getValor()),
                Double.parseDouble(txtMonto.getText()));

        if (datos.agregarFactura(factura)) {
            try {
                JOptionPane.showMessageDialog(this, "Factura agregada Correctamente");

                /* Si la factura se registra exitosamente pasamos armar el pdf*/
 /* Instanciamos un objeto de tipo Map para pasarle los parametros
                 al reporte */
                Map parametros = new HashMap();

                /* con el metodo put se le pasa el parametros al reporte, en este
                 caso el parametro se llama factura */
                parametros.put("numero", txtNFactura.getText());

                /* Obtenemos la direccion del reporte*/
                String template = frmFactura.class.getProtectionDomain().getCodeSource().getLocation().getPath();

                File aux = new File(template);

                /* Aqui comprobamos si el reporte se mando a ejecutar desde un IDE
                 o desde un JAR, si es desde un IDE guardamos la direccion del
                 reporte con System.getProperty("user.dir") + "/src/Reportes/rptFactura.jrxml";
                 y si no es le pasamos la direccion donde se encuentra el jar 
                if (aux.isDirectory()) {
                    template = System.getProperty("user.dir") + "/src/Reportes/rptFinal.jrxml";
                } else {
                    template = aux.getParent() + "/rptFinal.jrxml";
                }

                 */
                template = "/Reportes/report_Todo.jrxml";
                InputStream in = this.getClass().getResourceAsStream(template);

                /* Le pasamos la direccion del reporte que en este caso es un
                 archivo jrxml, para que lo compile */
                JasperReport jasperReport = JasperCompileManager.compileReport(in);

                /* Una ves compilado se lo pasamos al objeto Jasperprint para que
                 arme las consultas y los datos que contendran el reporte */
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, datos.getCon());

                /* Lo hacemos visible en pantalla 
                JFrame frame = new JFrame("Report");
                frame.setSize(250, 250);
                frame.getContentPane().add(new JRViewer(print));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);*/
                
                /* Lo hacemos visible en pantalla */
               JasperViewer visor = new JasperViewer(print, false);
               
               visor.setVisible(true); 

                

            } catch (JRException ex) {
                Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "En estos momentos no es posible"
                    + " agregar una factura, intentelo mas tarde");
        }

        txtIDFactura.setText("");
        dchCarga.setDate(null);
        txtNFactura.setText("");
        cmbProveedor.setSelectedIndex(0);
        cmbEmpleado.setSelectedIndex(0);
        cmbServicios.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        txtMonto.setText("");
        areaDescrip.setText("");

        /* Cargamos los ID en los formularios */
        int idFac = datos.getNumFac();
        txtIDFactura.setText("" + idFac);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            /* Evento cuando el formulario se abra */

 /* Instanciamos un objeto de la Clase Datos, para poder acceder a los
             metodos */
            Datos datos = new Datos();

            /* Cargamos los ID en los formularios */
            int idFac = datos.getNumFac();
            txtIDFactura.setText("" + idFac);

            /* Cargamos la fecha actual al campo tipo date */
            dchCarga.setDate(new Date());

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de los proveedores  */
            Opcion op = new Opcion("0", "Seleccione un proveedor");

            /* Añadimos el primer elemento al combo box */
            cmbProveedor.addItem(op);

            /* Llamos a la funcion getProveedor la cual nos devuelve todos los
             proveedores que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todos los Proveedores */
            ResultSet rs = datos.getProveedor();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rs.next()) {
                op = new Opcion(
                        rs.getString("id_proveedor"),
                        rs.getString("rif_cedula")
                        + "-" + rs.getString("nom_prove"));
                cmbProveedor.addItem(op);
            }

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de los servicios  */
            Opcion op2 = new Opcion("0", "Seleccione un servicio");

            /* Añadimos el primer elemento al combo box */
            cmbServicios.addItem(op2);

            /* Llamos a la funcion getServicios la cual nos devuelve todos los
             Servicios que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todos los Servicios */
            ResultSet rsSer = datos.getServicios();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rsSer.next()) {
                op2 = new Opcion(
                        rsSer.getString("id_servicio"),
                        rsSer.getString("nom_servi"));
                cmbServicios.addItem(op2);
            }

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de los Status  */
            Opcion op3 = new Opcion("3", "En proceso");

            /* Añadimos el primer elemento al combo box */
            cmbStatus.addItem(op3);

            /* Llamos a la funcion getStatus la cual nos devuelve todos los
             Status que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todos los Status
             ResultSet rsSta = datos.getStatus();

             Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box 
             while (rsSta.next()) {
             op3 = new Opcion(
             rsSta.getString("id_status"),
             rsSta.getString("nom_sta"));
             cmbStatus.addItem(op3);
             } */
            if (cargo.equals("Gerente")) {

                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op4 = new Opcion("" + id, usuario);

                /* Añadimos el primer elemento al combo box */
                cmbEmpleado.addItem(op4);

                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op5 = new Opcion("" + id, usuario);

                /* Añadimos el primer elemento al combo box */
                cmbGerente.addItem(op5);

            } else {

                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op4 = new Opcion("" + id, usuario);

                /* Añadimos el primer elemento al combo box */
                cmbEmpleado.addItem(op4);

                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op5 = new Opcion("0", "Seleccione un Gerente");

                /* Añadimos el primer elemento al combo box */
                cmbGerente.addItem(op5);

                /* Llamos a la funcion getPersonal la cual nos devuelve todo el
                 Personal que hay, esos datos los guardamos en un ResultSet para luego
                 llenar el combo box con todos los Empleados */
                ResultSet rsGere = datos.getGerentes();

                /* Hacemos un while que mientras hallan registros en rs, sobreescrira
                 al objeto de la clase opcion con los datos del objeto rs, y los añada
                 al combo box */
                while (rsGere.next()) {
                    op5 = new Opcion(
                            rsGere.getString("id_personal"),
                            rsGere.getString("nom_per")
                            + " " + rsGere.getString("ape_per"));
                    cmbGerente.addItem(op5);
                }

            }
            dchFactura.addKeyListener(new java.awt.event.KeyListener() {

                @Override
                public void keyTyped(KeyEvent ke) {
                    ke.consume();
                }

                @Override
                public void keyPressed(KeyEvent ke) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyReleased(KeyEvent ke) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

            });

        } catch (SQLException ex) {
            Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNFacturaKeyTyped
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

    }//GEN-LAST:event_txtNFacturaKeyTyped

    private void txtNFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNFacturaFocusLost

        Datos da = new Datos();

        if (!txtNFactura.getText().equals("")) {

            if (da.getNumeroFac(Integer.parseInt(txtNFactura.getText()))) {
                JOptionPane.showMessageDialog(this, "El numero de la factura ya se "
                        + "encuentra registrado. ");
                txtNFactura.setText("");
                txtNFactura.requestFocusInWindow();
                return;
            }

        }


    }//GEN-LAST:event_txtNFacturaFocusLost

    private void dchFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dchFacturaKeyTyped

        evt.consume();
    }//GEN-LAST:event_dchFacturaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescrip;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbEmpleado;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbGerente;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbProveedor;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbServicios;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbStatus;
    private com.toedter.calendar.JDateChooser dchCarga;
    private com.toedter.calendar.JDateChooser dchFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric11;
    private org.edisoncor.gui.label.LabelMetric labelMetric12;
    private org.edisoncor.gui.label.LabelMetric labelMetric13;
    private org.edisoncor.gui.label.LabelMetric labelMetric14;
    private org.edisoncor.gui.label.LabelMetric labelMetric15;
    private org.edisoncor.gui.label.LabelMetric labelMetric16;
    private org.edisoncor.gui.label.LabelMetric labelMetric17;
    private org.edisoncor.gui.label.LabelMetric labelMetric21;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtIDFactura;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtMonto;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtNFactura;
    // End of variables declaration//GEN-END:variables
}
