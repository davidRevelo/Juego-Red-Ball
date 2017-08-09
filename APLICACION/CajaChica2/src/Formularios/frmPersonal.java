/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import Clases.Opcion;
import Clases.Personal;
import Clases.Usuario;
import Clases.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sofia
 */
public class frmPersonal extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPersonalN
     */
    public frmPersonal() {
        initComponents();
    }

    public String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean validarEmail(String email) {

        String expresionRegular = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        //Set the email pattern string
        Pattern p = Pattern.compile(expresionRegular);

        //Match the given string with the pattern
        Matcher m = p.matcher(email);

        //check whether match is found 
        boolean matchFound = m.matches();

        return matchFound;
    }

    public String titulos[] = {"ID Proyecto", "Proyecto"};

    DefaultTableModel tablaModelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        PanelTop = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        Usuario = new org.edisoncor.gui.panel.Panel();
        btnCancelarUsuario = new org.edisoncor.gui.button.ButtonAction();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        btnSiguiente = new org.edisoncor.gui.button.ButtonAction();
        txtIdUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric15 = new org.edisoncor.gui.label.LabelMetric();
        cmbTipo = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtClave = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();
        txtConfirmarClave = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric21 = new org.edisoncor.gui.label.LabelMetric();
        Personal = new org.edisoncor.gui.panel.Panel();
        labelMetric11 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric13 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric14 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric16 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric17 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric19 = new org.edisoncor.gui.label.LabelMetric();
        txtCedula = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtTelefono = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        btnSiguientePer = new org.edisoncor.gui.button.ButtonAction();
        txtIDEmpleado = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtApellido = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        btnCancelarGe = new org.edisoncor.gui.button.ButtonAction();
        txtCorreo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric12 = new org.edisoncor.gui.label.LabelMetric();
        cmbCedula = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbTelefono = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbCargo = new org.edisoncor.gui.comboBox.ComboBoxRound();
        Proyecto = new org.edisoncor.gui.panel.Panel();
        cmbProyecto = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric22 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyecto = new javax.swing.JTable();
        btnCancelarPro = new org.edisoncor.gui.button.ButtonAction();
        btnRegistrar = new org.edisoncor.gui.button.ButtonAction();
        btnAdd = new javax.swing.JButton();
        btnDele = new javax.swing.JButton();

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

        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-sistema.png"))); // NOI18N

        btnCancelarUsuario.setText("Cancelar");
        btnCancelarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUsuarioActionPerformed(evt);
            }
        });

        labelMetric8.setText("Clave:");

        labelMetric9.setText("Confirmar Clave:");

        labelMetric10.setText("ID:");

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        txtIdUsuario.setEnabled(false);
        txtIdUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        labelMetric15.setText("Tipo:");

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        txtConfirmarClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveKeyTyped(evt);
            }
        });

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        labelMetric21.setText("Usuario:");

        javax.swing.GroupLayout UsuarioLayout = new javax.swing.GroupLayout(Usuario);
        Usuario.setLayout(UsuarioLayout);
        UsuarioLayout.setHorizontalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtConfirmarClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        UsuarioLayout.setVerticalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        PanelTop.addTab("Usuario", Usuario);

        Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-sistema.png"))); // NOI18N

        labelMetric11.setText("ID:");

        labelMetric13.setText("Cédula:");

        labelMetric14.setText("Nombre:");

        labelMetric16.setText("Apellido:");

        labelMetric17.setText("Telefono:");

        labelMetric19.setText("Cargo:");

        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnSiguientePer.setText("Siguiente");
        btnSiguientePer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguientePerActionPerformed(evt);
            }
        });

        txtIDEmpleado.setEnabled(false);
        txtIDEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        btnCancelarGe.setText("Cancelar");
        btnCancelarGe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarGeActionPerformed(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        labelMetric12.setText("Correo:");

        javax.swing.GroupLayout PersonalLayout = new javax.swing.GroupLayout(Personal);
        Personal.setLayout(PersonalLayout);
        PersonalLayout.setHorizontalGroup(
            PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btnCancelarGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSiguientePer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PersonalLayout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PersonalLayout.createSequentialGroup()
                        .addComponent(cmbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PersonalLayout.createSequentialGroup()
                        .addComponent(cmbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIDEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177))
        );
        PersonalLayout.setVerticalGroup(
            PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(PersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguientePer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        PanelTop.addTab("Personal", Personal);

        Proyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-sistema.png"))); // NOI18N

        labelMetric22.setText("Proyecto:");

        tablaProyecto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProyecto);

        btnCancelarPro.setText("Cancelar");
        btnCancelarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Minus2.png"))); // NOI18N
        btnDele.setBorder(null);
        btnDele.setBorderPainted(false);
        btnDele.setContentAreaFilled(false);
        btnDele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProyectoLayout = new javax.swing.GroupLayout(Proyecto);
        Proyecto.setLayout(ProyectoLayout);
        ProyectoLayout.setHorizontalGroup(
            ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProyectoLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProyectoLayout.createSequentialGroup()
                        .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addGap(136, 136, 136))
                    .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProyectoLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btnDele)
                            .addGap(43, 43, 43))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProyectoLayout.createSequentialGroup()
                            .addComponent(btnCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(225, 225, 225)))))
        );
        ProyectoLayout.setVerticalGroup(
            ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProyectoLayout.createSequentialGroup()
                .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProyectoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProyectoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProyectoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(ProyectoLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnDele)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        PanelTop.addTab("Proyecto", Proyecto);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUsuarioActionPerformed

        setVisible(false);
    }//GEN-LAST:event_btnCancelarUsuarioActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        /* Instanciamos un objeto de la Clase Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtIdUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el ID del usuario");
            txtIdUsuario.requestFocusInWindow();
            return;
        }

        if (cmbTipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe Seleccionar un tipo de usuario");
            cmbTipo.requestFocusInWindow();
            return;
        }

        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre de usuario");
            txtUsuario.requestFocusInWindow();
            return;
        }

        if (!txtUsuario.getText().equals("")) {

            if (datos.getUsuario(txtUsuario.getText())) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya se "
                        + "encuentra registrado. ");
                txtUsuario.setText("");
                txtUsuario.requestFocusInWindow();
                return;
            }

        }

        /* Como el cambo passwordfield nos devuelve un array, hay que transformarlo
         a String para validarlo y luego compararlo con la confirmacion */
        String clave = new String(txtClave.getPassword());

        if (clave.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la clave del usuario");
            txtClave.requestFocusInWindow();
            return;
        }

        String confirmar = new String(txtConfirmarClave.getPassword());

        if (confirmar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe confirmar la clave ");
            txtConfirmarClave.requestFocusInWindow();
            return;
        }

        if (!clave.equals(confirmar)) {
            JOptionPane.showMessageDialog(rootPane, "Las claves no coinciden, "
                    + "por favor vuelva a ingresarlas");
            txtClave.setText("");
            txtConfirmarClave.setText("");
            txtClave.requestFocusInWindow();
            return;
        }

        PanelTop.setSelectedComponent(Personal);

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnSiguientePerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguientePerActionPerformed
        /* Evento de click sobre el boton de REGISTRAR Gerente */

        /* Instanciamos un objeto de la Clase Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtIDEmpleado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el ID del Gerente");
            txtIDEmpleado.requestFocusInWindow();
            return;
        }

        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cedula");
            txtCedula.requestFocusInWindow();
            return;
        }

        if (cmbCedula.getSelectedIndex() == 0) {

            if (txtCedula.getText().length() < 8) {

                JOptionPane.showMessageDialog(this, "Debe digitar una Cedula valida");
                txtCedula.setText("");
                txtCedula.requestFocusInWindow();
                return;

            }

        } else {

            if (txtCedula.getText().length() < 10) {

                JOptionPane.showMessageDialog(this, "Debe digitar una Cedula valida");
                txtCedula.setText("");
                txtCedula.requestFocusInWindow();
                return;

            }

        }

        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre ");
            txtNombre.requestFocusInWindow();
            return;
        }

        if (txtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un apellido ");
            txtApellido.requestFocusInWindow();
            return;
        }

        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe especificar un telefono de contacto ");
            txtTelefono.requestFocusInWindow();
            return;
        }

        if (txtTelefono.getText().length() < 7) {

            JOptionPane.showMessageDialog(this, "Debe digitar un telefono valido");
            txtTelefono.setText("");
            txtTelefono.requestFocusInWindow();
            return;

        }

        if (cmbCargo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cargo");
            cmbCargo.requestFocusInWindow();
            return;
        }
        if (txtCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un correo ");
            txtCorreo.requestFocusInWindow();
            return;
        }

        /* Llamamos a la funcion validar email  */
        if (!validarEmail(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Correo invalido");
            txtCorreo.setText("");
            txtCorreo.requestFocusInWindow();
            return;
        }

        PanelTop.setSelectedComponent(Proyecto);

    }//GEN-LAST:event_btnSiguientePerActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        /* Validar solo letras */
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped

        /* Validar solo letras */
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }

        if (!Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();
        }

    }//GEN-LAST:event_txtApellidoKeyTyped

    private void btnCancelarGeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarGeActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarGeActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            /* Evento cuando el formulario se abra */

            /* Instanciamos un objeto de la Clase Datos, para poder acceder a los
             metodos */
            Datos datos = new Datos();

            /* Cargamos los ID en los formularios */
            int idUsu = datos.getIdUsuario();
            txtIdUsuario.setText("" + idUsu);

            int idPer = datos.getIdPersonal();
            txtIDEmpleado.setText("" + idPer);

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box 
             de tipos de usuarios  */
            Opcion op = new Opcion("0", "Seleccione el tipo de usuario");

            /* Añadimos el primer elemento al combo box */
            cmbTipo.addItem(op);

            /* Llamos a la funcion getTipoUsuario la cual nos devuelve todos los tipos
             de usuarios que hay, esos datos los guardmoas en un ResultSet para luego
             llenar el combo box con todos los tipos de usuarios */
            ResultSet rs = datos.getTiposUsuario();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rs.next()) {
                op = new Opcion(
                        rs.getString("id_tipo"),
                        rs.getString("nom_tipo"));
                cmbTipo.addItem(op);
            }

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box 
             de cargos  */
            Opcion op2 = new Opcion("0", "Seleccione un cargo");

            /* Añadimos el primer elemento al combo box */
            cmbCargo.addItem(op2);

            /* Llamos a la funcion getCargos la cual nos devuelve todos los 
             cargos que hay, esos datos los guardmoas en un ResultSet para luego
             llenar el combo box con todos los cargos */
            ResultSet rsCargo = datos.getCargos();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rsCargo.next()) {
                op2 = new Opcion(
                        rsCargo.getString("id_cargo"),
                        rsCargo.getString("cargo"));
                cmbCargo.addItem(op2);
            }

            /* Instaciamos un objeto de la clase Opcion para cargar el combo box 
             de proyectos  */
            Opcion op3 = new Opcion("0", "Seleccione un proyecto");

            /* Añadimos el primer elemento al combo box */
            cmbProyecto.addItem(op3);

            /* Llamos a la funcion getProyectos la cual nos devuelve todos los 
             proyectos que hay, esos datos los guardmoas en un ResultSet para luego
             llenar el combo box con todos los proyectos */
            ResultSet rsPro = datos.getProyectos();

            /* Hacemos un while que mientras hallan registros en rs, sobreescrira
             al objeto de la clase opcion con los datos del objeto rs, y los añada
             al combo box */
            while (rsPro.next()) {
                op3 = new Opcion(
                        rsPro.getString("id_proyecto"),
                        rsPro.getString("nom_pro"));
                cmbProyecto.addItem(op3);
            }

            Opcion op4 = new Opcion("1", "N-");

            cmbCedula.addItem(op4);

            op4 = new Opcion("2", "J-");

            cmbCedula.addItem(op4);

            Opcion op5 = new Opcion("1", "414");

            cmbTelefono.addItem(op5);

            op5 = new Opcion("2", "416");

            cmbTelefono.addItem(op5);

            op5 = new Opcion("3", "426");

            cmbTelefono.addItem(op5);

            op5 = new Opcion("4", "412");

            cmbTelefono.addItem(op5);

            op5 = new Opcion("5", "424");

            cmbTelefono.addItem(op5);

            op5 = new Opcion("5", "212");

            cmbTelefono.addItem(op5);

            tablaProyecto.setModel(tablaModelo);

        } catch (SQLException ex) {
            Logger.getLogger(frmPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarProActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        /* Evento de click sobre el boton de REGISTRAR Gerente */

        /* Instanciamos un objeto de la Clase Datos */
        Datos datos = new Datos();

        int filas = tablaProyecto.getRowCount();

        if (filas <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Proyecto");
            cmbProyecto.requestFocusInWindow();
            return;
        }

        if (!txtUsuario.getText().equals("")) {

            if (datos.getUsuario(txtUsuario.getText())) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya se "
                        + "encuentra registrado. ");
                txtUsuario.setText("");
                txtUsuario.requestFocusInWindow();

            }

        }

        String clave = new String(txtClave.getPassword());

        /* Instanciamos un objeto de la Clase Usuario, el cual se lo pasaremos
         a la funcion agregarUsuario, la cual pide como parametro un objeto Usuario */
        Usuario usuario = new Usuario(Integer.parseInt(txtIdUsuario.getText()),
                cmbTipo.getSelectedIndex(),
                txtUsuario.getText(),
                clave,
                txtCorreo.getText());

        /* Instanciamos un objeto de la clase Personal el  cual se lo pasaremos
         a la funcion agregarPersonal, la cual pide como parametro un objeto Personal */
        Personal personal = new Personal(Integer.parseInt(txtIDEmpleado.getText()),
                txtUsuario.getText(),
                ((Opcion) cmbCedula.getSelectedItem()).getDescripcion() + "" + txtCedula.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                ((Opcion) cmbTelefono.getSelectedItem()).getDescripcion() + "" + txtTelefono.getText(),
                ((Opcion) cmbCargo.getSelectedItem()).getDescripcion());

        /* Una ves instanciado y cargado el objeto llamamos a la funcion
         agregarPersonal, validamos si la funcion retorna true, imprimimos en
         pantalla un mensaje de aprobacion, si no lo contrario. */
        /*Id del empleado lo convertimos a integer para pasarselo a la funcion
         agregarProyeGere*/
        int idEm = Integer.parseInt(txtIDEmpleado.getText());

        /* Convertimos el Objeto que nos devuelve el combox a integer para
         pasarselo a la funcion agregarProyeGere */
        int idPro = 0;

        if (datos.agregarUsuario(usuario) && datos.agregarPersonal(personal)) {

            for (int i = 0; i < tablaProyecto.getRowCount(); i++) {

                idPro = Integer.parseInt(Utilidades.objectToString(tablaProyecto.getValueAt(i, 0)));
                datos.agregarProyeGere(idPro, idEm);

            }

            JOptionPane.showMessageDialog(this, "Empleado Agregado Correctamente");

        } else {
            JOptionPane.showMessageDialog(this, "En estos momentos no es posible"
                    + " agregar al Empleado, intentelo mas tarde");
        }

        setVisible(false);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (cmbProyecto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un Proyecto");
            cmbProyecto.requestFocusInWindow();
            return;
        }

        int filas = tablaProyecto.getRowCount();

        if (filas > 2) {
            JOptionPane.showMessageDialog(rootPane, "No puede agregar mas proyecto, el limite es 3");
            cmbProyecto.requestFocusInWindow();
            return;
        }

        for (int i = 0; i < filas; i++) {

            if (((Opcion) cmbProyecto.getSelectedItem()).
                    getValor().equals(Utilidades.objectToString(tablaProyecto.getValueAt(i, 0)))) {
                JOptionPane.showMessageDialog(rootPane, "El Proyecto ya ha sido agregado");
                cmbProyecto.requestFocusInWindow();
                return;
            }
        }

        String registro[] = new String[3];

        registro[0] = (((Opcion) cmbProyecto.getSelectedItem()).getValor());
        registro[1] = (((Opcion) cmbProyecto.getSelectedItem()).getDescripcion());

        tablaModelo.addRow(registro);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tablaProyecto.getModel();

        modelo.removeRow(tablaProyecto.getSelectedRow());

    }//GEN-LAST:event_btnDeleActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        /* Funcion para validar que solo ingresen numeros */
        char c = evt.getKeyChar();

        if (cmbCedula.getSelectedIndex() == 0) {

            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();

            }

            if (txtCedula.getText().length() >= 8) {
                evt.consume();
            }

        } else {

            if (txtCedula.getText().length() == 8) {

                if (evt.getKeyChar() == '-') {
                    return;
                } else {
                    evt.consume();
                }

            }

            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();

            }

            if (txtCedula.getText().length() >= 10) {
                evt.consume();
            }

        }

        /* if (Character.isLetter(c)) {
         getToolkit().beep();

         evt.consume();
         }

         if (Character.isWhitespace(evt.getKeyChar())) {
         evt.consume();
         } */

    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
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

        if (txtTelefono.getText().length() >= 7) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped

        if (txtClave.getPassword().length >= 10) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "La clave debe ser menor o igual a 10 caracteres");

        }

    }//GEN-LAST:event_txtClaveKeyTyped

    private void txtConfirmarClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveKeyTyped
        if (txtConfirmarClave.getPassword().length >= 10) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "La clave debe ser menor o igual a 10 caracteres");

        }
    }//GEN-LAST:event_txtConfirmarClaveKeyTyped

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        Datos da = new Datos();

        if (!txtUsuario.getText().equals("")) {

            if (da.getUsuario(txtUsuario.getText())) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya se "
                        + "encuentra registrado. ");
                txtUsuario.setText("");
                txtUsuario.requestFocusInWindow();
                return;
            }

        }

    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost


    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        
        if (evt.getKeyChar() == 'ñ') {
            evt.consume();
        }
        
        if (txtCorreo.getText().length() >= 40) {
            evt.consume();
        }


    }//GEN-LAST:event_txtCorreoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader PanelTop;
    private org.edisoncor.gui.panel.Panel Personal;
    private org.edisoncor.gui.panel.Panel Proyecto;
    private org.edisoncor.gui.panel.Panel Usuario;
    private javax.swing.JButton btnAdd;
    private org.edisoncor.gui.button.ButtonAction btnCancelarGe;
    private org.edisoncor.gui.button.ButtonAction btnCancelarPro;
    private org.edisoncor.gui.button.ButtonAction btnCancelarUsuario;
    private javax.swing.JButton btnDele;
    private org.edisoncor.gui.button.ButtonAction btnRegistrar;
    private org.edisoncor.gui.button.ButtonAction btnSiguiente;
    private org.edisoncor.gui.button.ButtonAction btnSiguientePer;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbCargo;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbCedula;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbProyecto;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbTelefono;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric11;
    private org.edisoncor.gui.label.LabelMetric labelMetric12;
    private org.edisoncor.gui.label.LabelMetric labelMetric13;
    private org.edisoncor.gui.label.LabelMetric labelMetric14;
    private org.edisoncor.gui.label.LabelMetric labelMetric15;
    private org.edisoncor.gui.label.LabelMetric labelMetric16;
    private org.edisoncor.gui.label.LabelMetric labelMetric17;
    private org.edisoncor.gui.label.LabelMetric labelMetric19;
    private org.edisoncor.gui.label.LabelMetric labelMetric21;
    private org.edisoncor.gui.label.LabelMetric labelMetric22;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaProyecto;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtApellido;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtCedula;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtClave;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtConfirmarClave;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtCorreo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtIDEmpleado;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtIdUsuario;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtNombre;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtTelefono;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
