/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import Clases.Opcion;
import Clases.Utilidades;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sofia
 */
public class frmConsultarFacturas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsultarFacturas
     */
    public frmConsultarFacturas() {
        initComponents();
    }

    private void habilitarCampos() {

        if (rbtTodo.isSelected()) {
            /* Bloqueamos los radio button */

            rbtFecha.setEnabled(false);
            rbtFactura.setEnabled(false);
            rbtEmpleado.setEnabled(false);
            rbtServicio.setEnabled(false);
            rbtStatus.setEnabled(false);

            /* Bloqueamos los campos */
            cmbNumero.setEnabled(false);
            dchFechaInicial.setEnabled(false);
            dchFechaFinal.setEnabled(false);
            cmbEmpleado.setEnabled(false);
            cmbServicio.setEnabled(false);
            cmbStatus.setEnabled(false);

        } else {
            rbtFecha.setEnabled(true);
            rbtFactura.setEnabled(true);
            rbtEmpleado.setEnabled(true);
            rbtServicio.setEnabled(true);
            rbtStatus.setEnabled(true);

            if (rbtFecha.isSelected()) {

                dchFechaInicial.setEnabled(true);
                dchFechaFinal.setEnabled(true);
                cmbNumero.setEnabled(false);
                cmbEmpleado.setEnabled(false);
                cmbServicio.setEnabled(false);
                cmbStatus.setEnabled(false);
            }

            if (rbtFactura.isSelected()) {

                cmbNumero.setEnabled(true);
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);
                cmbEmpleado.setEnabled(false);
                cmbServicio.setEnabled(false);
                cmbStatus.setEnabled(false);

            }

            if (rbtEmpleado.isSelected()) {

                cmbNumero.setEnabled(false);
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);
                cmbEmpleado.setEnabled(true);
                cmbServicio.setEnabled(false);
                cmbStatus.setEnabled(false);

            }

            if (rbtServicio.isSelected()) {

                cmbNumero.setEnabled(false);
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);
                cmbEmpleado.setEnabled(false);
                cmbServicio.setEnabled(true);
                cmbStatus.setEnabled(false);

            }

            if (rbtStatus.isSelected()) {

                cmbNumero.setEnabled(false);
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);
                cmbEmpleado.setEnabled(false);
                cmbServicio.setEnabled(false);
                cmbStatus.setEnabled(true);

            }

        }
    }

    /* Definimos los titulos que llevara la tabla*/
    public String titulos[] = {"Nº", "Fecha", "Fecha Carga", "Proveedor", "Empleado",
        "Status", "Monto"};

    public String usuario;
    public Integer perfil;
    public String cargo;
    public Integer id;
    public String nombre;

    public void setUsuario(String usuario, int id, int perfil, String cargo, String nombre) {
        this.usuario = usuario;
        this.id = id;
        this.perfil = perfil;
        this.cargo = cargo;
        this.nombre = nombre;
    }

    Datos datos = new Datos();

    /* Definimos una tabla modelo y sobreeescribimos el metodo isCellEditable
     para que las columnas y filas de la tabla no se puedan editar*/
    DefaultTableModel tablaModelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
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
            ResultSet rs = datos.getFacturasReporte();

            /* Instaciamos un obejto vector tipo string, el cual nos servira
             para guardar las filas de la tabla. */
            String registro[] = new String[8];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("n_factura");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("carga");
                registro[3] = rs.getString("proveedor");
                registro[4] = rs.getString("empleado");
                registro[5] = rs.getString("status");
                registro[6] = rs.getString("monto");

                tablaModelo.addRow(registro);

            }

            tablaFacturas.setModel(tablaModelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmProyectoUp.class.getName()).log(Level.SEVERE, null, ex);
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
            ResultSet rs = datos.getFacturasReporteEmpleado(nombre);

            String registro[] = new String[8];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("n_factura");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("carga");
                registro[3] = rs.getString("proveedor");
                registro[4] = rs.getString("empleado");
                registro[5] = rs.getString("status");
                registro[6] = rs.getString("monto");

                tablaModelo.addRow(registro);

            }

            tablaFacturas.setModel(tablaModelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmConsultarFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        grupo2 = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        btnCancelar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        cmbStatus = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        cmbServicio = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbEmpleado = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        cmbNumero = new org.edisoncor.gui.comboBox.ComboBoxRound();
        dchFechaFinal = new com.toedter.calendar.JDateChooser();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        dchFechaInicial = new com.toedter.calendar.JDateChooser();
        rbtFecha = new javax.swing.JRadioButton();
        rbtFactura = new javax.swing.JRadioButton();
        rbtEmpleado = new javax.swing.JRadioButton();
        rbtServicio = new javax.swing.JRadioButton();
        rbtStatus = new javax.swing.JRadioButton();
        rbtSeleccion = new javax.swing.JRadioButton();
        rbtTodo = new javax.swing.JRadioButton();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();

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
        jScrollPane1.setViewportView(tablaFacturas);

        labelMetric3.setText("Consulta de Facturas");
        labelMetric3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

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

        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura-48.png"))); // NOI18N
        btnGenerar.setText("Generar Reporte");
        btnGenerar.setBorder(null);
        btnGenerar.setBorderPainted(false);
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        labelMetric6.setText("Status:");

        labelMetric7.setText("Servicio:");

        labelMetric5.setText("Empleado:");

        labelMetric4.setText("Número:");

        dchFechaFinal.setEnabled(false);

        labelMetric2.setText("Fecha Final:");

        labelMetric1.setText("Fecha Inicial:");

        dchFechaInicial.setEnabled(false);

        rbtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtFecha.setForeground(new java.awt.Color(255, 255, 255));
        rbtFecha.setText("Fecha");
        rbtFecha.setBorder(null);
        rbtFecha.setContentAreaFilled(false);
        rbtFecha.setEnabled(false);
        rbtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFechaActionPerformed(evt);
            }
        });

        rbtFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtFactura.setForeground(new java.awt.Color(255, 255, 255));
        rbtFactura.setText("Número");
        rbtFactura.setBorder(null);
        rbtFactura.setContentAreaFilled(false);
        rbtFactura.setEnabled(false);
        rbtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFacturaActionPerformed(evt);
            }
        });

        rbtEmpleado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        rbtEmpleado.setText("Empleado");
        rbtEmpleado.setBorder(null);
        rbtEmpleado.setContentAreaFilled(false);
        rbtEmpleado.setEnabled(false);
        rbtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEmpleadoActionPerformed(evt);
            }
        });

        rbtServicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtServicio.setForeground(new java.awt.Color(255, 255, 255));
        rbtServicio.setText("Servicio");
        rbtServicio.setBorder(null);
        rbtServicio.setContentAreaFilled(false);
        rbtServicio.setEnabled(false);
        rbtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtServicioActionPerformed(evt);
            }
        });

        rbtStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtStatus.setForeground(new java.awt.Color(255, 255, 255));
        rbtStatus.setText("Status");
        rbtStatus.setBorder(null);
        rbtStatus.setContentAreaFilled(false);
        rbtStatus.setEnabled(false);
        rbtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtStatusActionPerformed(evt);
            }
        });

        rbtSeleccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        rbtSeleccion.setText("Seleccion");
        rbtSeleccion.setBorder(null);
        rbtSeleccion.setContentAreaFilled(false);
        rbtSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSeleccionActionPerformed(evt);
            }
        });

        rbtTodo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbtTodo.setForeground(new java.awt.Color(255, 255, 255));
        rbtTodo.setText("Todas");
        rbtTodo.setBorder(null);
        rbtTodo.setContentAreaFilled(false);
        rbtTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodoActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        labelMetric8.setText("Buscar:");
        labelMetric8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtTodo)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSeleccion)
                        .addGap(164, 164, 164))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelMetric1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dchFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dchFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(btnGenerar)
                                        .addGap(53, 53, 53)
                                        .addComponent(btnCancelar)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(rbtFecha)
                                .addGap(18, 18, 18)
                                .addComponent(rbtFactura)
                                .addGap(18, 18, 18)
                                .addComponent(rbtEmpleado)
                                .addGap(18, 18, 18)
                                .addComponent(rbtServicio)
                                .addGap(7, 7, 7)
                                .addComponent(rbtStatus)
                                .addGap(29, 29, 29))))))
        );

        panel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbEmpleado, cmbNumero, cmbServicio, cmbStatus, dchFechaFinal, dchFechaInicial});

        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtTodo)
                            .addComponent(rbtSeleccion))
                        .addGap(28, 28, 28)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtFactura)
                            .addComponent(rbtEmpleado)
                            .addComponent(rbtFecha)
                            .addComponent(rbtStatus)
                            .addComponent(rbtServicio))
                        .addGap(39, 39, 39)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dchFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerar)
                            .addComponent(btnCancelar))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        try {

            String sql = " SELECT factura.id_factura AS factura, "
                    + "factura.n_factura AS numero, "
                    + "factura.fecha_fac AS fecha, "
                    + "factura.fecha_carga AS carga, "
                    + "CONCAT( proveedor.rif_cedula, '-', proveedor.nom_prove) AS proveedor, "
                    + "CONCAT( personal.nom_per, ' ', personal.ape_per) AS empleado, "
                    + "servicio.nom_servi AS servicio, "
                    + "status.nom_sta AS status, "
                    + "factura.descri_fac AS descripcion, "
                    + "factura.monto AS monto "
                    + "FROM factura "
                    + "INNER JOIN proveedor ON factura.id_proveedor = proveedor.id_proveedor "
                    + "INNER JOIN personal ON factura.id_personal = personal.id_personal "
                    + "INNER JOIN servicio ON factura.id_servicio = servicio.id_servicio "
                    + "INNER JOIN status ON factura.id_status = status.id_status ";

            String filtro = "";

            if (rbtTodo.isSelected()) {
                filtro = "";
            } else {

                if (rbtFecha.isSelected()) {

                    if (dchFechaInicial.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha inicial");
                        dchFechaInicial.requestFocusInWindow();
                        return;
                    }

                    if (dchFechaFinal.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha final");
                        dchFechaFinal.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.fecha_fac >= '"
                            + Utilidades.formateDate(dchFechaInicial.getDate())
                            + "' AND factura.fecha_fac <= '"
                            + Utilidades.formateDate(dchFechaFinal.getDate()) + "'";
                }

                if (rbtFactura.isSelected()) {

                    if (cmbNumero.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar una factura ");
                        cmbNumero.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.n_factura >= "
                            + ((Opcion) cmbNumero.getSelectedItem()).getValor();

                }

                if (rbtEmpleado.isSelected()) {

                    if (cmbEmpleado.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un Empleado");
                        cmbEmpleado.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.id_personal = '" + ((Opcion) cmbEmpleado.getSelectedItem()).getValor() + "'";
                }

                if (rbtServicio.isSelected()) {

                    if (cmbServicio.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
                        cmbServicio.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.id_servicio = '" + ((Opcion) cmbServicio.getSelectedItem()).getValor() + "'";
                }

                if (rbtStatus.isSelected()) {

                    if (cmbStatus.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un Status");
                        cmbStatus.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.id_status = '" + ((Opcion) cmbStatus.getSelectedItem()).getValor() + "'";
                }

            }
            
            

            /* Adicionamos el filtro a la consulta */
            sql = sql + filtro + "ORDER by numero";

            /* Instanciamos un objeto de la Clase Datos */
            Datos datos = new Datos();

            /* Con el sql obtenido de la consulta y el filtro se lo pasamos a
             la funcion getFactura para obtener los datos de la factura */
            JRResultSetDataSource data = new JRResultSetDataSource(datos.getFacturas(sql));

            if (datos.getFacturas(sql) == null) {
                JOptionPane.showMessageDialog(this, "No se encontraron facturas con la consulta proporcionada.");
                return;
            }

            Map parametros = new HashMap();

            /* con el metodo put se le pasa el parametros al reporte, en este
             caso el parametro se llama factura */
            parametros.put("total", datos.getMontoTotal());

            /* Obtenemos la direccion del reporte*/
            String template = frmFactura.class.getProtectionDomain().getCodeSource().getLocation().getPath();

            File aux = new File(template);

            template = "/Reportes/report_consulta.jrxml";

            InputStream in = getClass().getResourceAsStream(template);

            /* Le pasamos la direccion del reporte que en este caso es un
             archivo jrxml, para que lo compile */
            JasperReport jasperReport = JasperCompileManager.compileReport(in);

            /* Una ves compilado se lo pasamos al objeto Jasperprint para que
             arme las consultas y los datos que contendran el reporte, la funcion
             fillReport recibe como parametro:
             - El jasperReport
             - Los parametros
             - Un objeto que contenga la conexion de la base de datos o un objeto
             ResultSet con lo datos.

             En este caso le pasamos un JRResultSetDataSource con los datos*/
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, data);

            /* Lo hacemos visible en pantalla */
            JasperViewer visor = new JasperViewer(print, false);
            visor.setVisible(true);

            JOptionPane.showMessageDialog(null, "Reporte Generado");
        } catch (Exception ex) {
            Logger.getLogger(frmConsultarFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void rbtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFechaActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtFechaActionPerformed

    private void rbtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFacturaActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtFacturaActionPerformed

    private void rbtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEmpleadoActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtEmpleadoActionPerformed

    private void rbtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtServicioActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtServicioActionPerformed

    private void rbtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtStatusActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtStatusActionPerformed

    private void rbtSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSeleccionActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtSeleccionActionPerformed

    private void rbtTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodoActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtTodoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            /* Evento cuando el formulario se abra */

            if (cargo.equals("Director") || cargo.equals("Gerente") || cargo.equals("Administrador")) {
                llenarTabla();
            } else {

                tablaModelo.setRowCount(0);
                llenarTabla(nombre);
            }

            grupo1.add(rbtTodo);
            grupo1.add(rbtSeleccion);

            grupo2.add(rbtFecha);
            grupo2.add(rbtFactura);
            grupo2.add(rbtEmpleado);
            grupo2.add(rbtServicio);
            grupo2.add(rbtStatus);

            cmbNumero.setEnabled(false);
            dchFechaInicial.setEnabled(false);
            dchFechaFinal.setEnabled(false);
            cmbEmpleado.setEnabled(false);
            cmbServicio.setEnabled(false);
            cmbStatus.setEnabled(false);

            /* Instanciamos un objeto de la Clase Datos, para poder acceder a los
             metodos */
            Datos datos = new Datos();

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de las Facturas  */
            Opcion op = new Opcion("0", "Seleccione una Factura ");

            /* Añadimos el primer elemento al combo box */
            cmbNumero.addItem(op);

            /* Llamos a la funcion getFacturas la cual nos devuelve todas las
             facturas que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todas las facturas */
            ResultSet rsFac = datos.getFacturas();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rsFac.next()) {
                op = new Opcion(
                        rsFac.getString("id_factura"),
                        rsFac.getString("id_factura"));
                cmbNumero.addItem(op);
            }

            if (cargo.equals("Director") || cargo.equals("Gerente") || cargo.equals("Administrador")) {
                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op2 = new Opcion("0", "Seleccione un Empleado ");

                /* Añadimos el primer elemento al combo box */
                cmbEmpleado.addItem(op2);

                /* Llamos a la funcion getPersonal la cual nos devuelve todo el
                 Personal que hay, esos datos los guardamos en un ResultSet para luego
                 llenar el combo box con todos los Empleados */
                ResultSet rsPer = datos.getPersonal();

                /* Hacemos un while que mientras hallan registros en rs, sobreescrira
                 al objeto de la clase opcion con los datos del objeto rs, y los añada
                 al combo box */
                while (rsPer.next()) {
                    op2 = new Opcion(
                            rsPer.getString("id_personal"),
                            rsPer.getString("nom_per")
                            + " " + rsPer.getString("ape_per"));
                    cmbEmpleado.addItem(op2);
                }

            } else {
                /* Instaciamos un objeto de la clase Opcion para cargar el combo box
                 de los Empleados  */
                Opcion op2 = new Opcion("0", "Seleccione un empleado");

                /* Añadimos el primer elemento al combo box */
                cmbEmpleado.addItem(op2);

                op2 = new Opcion("" + id, usuario);

                /* Añadimos el primer elemento al combo box */
                cmbEmpleado.addItem(op2);

                rbtTodo.setEnabled(false);
                rbtSeleccion.setEnabled(false);
                rbtEmpleado.setSelected(true);
                cmbEmpleado.setSelectedIndex(1);

            }
            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de los servicios  */
            Opcion op3 = new Opcion("0", "Seleccione un servicio");

            /* Añadimos el primer elemento al combo box */
            cmbServicio.addItem(op3);

            /* Llamos a la funcion getServicios la cual nos devuelve todos los
             Servicios que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todos los Servicios */
            ResultSet rsSer = datos.getServicios();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rsSer.next()) {
                op3 = new Opcion(
                        rsSer.getString("id_servicio"),
                        rsSer.getString("nom_servi"));
                cmbServicio.addItem(op3);
            }

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box
             de los Status  */
            Opcion op4 = new Opcion("0", "Seleccione un Status");

            /* Añadimos el primer elemento al combo box */
            cmbStatus.addItem(op4);

            /* Llamos a la funcion getStatus la cual nos devuelve todos los
             Status que hay, esos datos los guardamos en un ResultSet para luego
             llenar el combo box con todos los Status */
            ResultSet rs = datos.getStatus();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rs.next()) {
                op4 = new Opcion(
                        rs.getString("id_status"),
                        rs.getString("nom_sta"));
                cmbStatus.addItem(op4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmConsultarFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        /* Cuando el usuario digite en el campo txt Buscar y tabulee
         llenamos la tabla con la busqueda */
        if (!txtBuscar.getText().equals("")) {

            if (cargo.equals("Director") || cargo.equals("Gerente") || cargo.equals("Administrador")) {
                llenarTabla(txtBuscar.getText());
            } else {
                llenarTabla(nombre);
            }

        } else {
            /* Limpiamos la tabla */
            tablaModelo.setRowCount(0);
            llenarTabla(nombre);

        }


    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbEmpleado;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbNumero;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbServicio;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbStatus;
    private com.toedter.calendar.JDateChooser dchFechaFinal;
    private com.toedter.calendar.JDateChooser dchFechaInicial;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.ButtonGroup grupo2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JRadioButton rbtEmpleado;
    private javax.swing.JRadioButton rbtFactura;
    private javax.swing.JRadioButton rbtFecha;
    private javax.swing.JRadioButton rbtSeleccion;
    private javax.swing.JRadioButton rbtServicio;
    private javax.swing.JRadioButton rbtStatus;
    private javax.swing.JRadioButton rbtTodo;
    private javax.swing.JTable tablaFacturas;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
