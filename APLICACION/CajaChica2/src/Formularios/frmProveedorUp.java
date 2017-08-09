/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Datos;
import Clases.Opcion;
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
public class frmProveedorUp extends javax.swing.JInternalFrame {

    /* Definimos los titulos que llevara la tabla*/
    public String titulos[] = {"ID", "Rif-Cedula", "Nombre", "Telefono", "Descripcion"};

    public frmProveedorUp() {
        initComponents();
    }

    public String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

            /* Llamos a la funcion getProveedor la cual nos devuelve todos 
             los proovedores registrados en la base de datos. 
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
             */
            ResultSet rs = datos.getProveedor();

            /* Instaciamos un vector de objeto tipo string, el cual nos servira
             para guardar las filas de la tabla. */
            String registro[] = new String[5];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("id_proveedor");
                registro[1] = rs.getString("rif_cedula");
                registro[2] = rs.getString("nom_prove");
                registro[3] = rs.getString("tele_prove");
                registro[4] = rs.getString("direcc_prove");
                tablaModelo.addRow(registro);

            }

            tablaProveedores.setModel(tablaModelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmProveedorUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* Funcion para llenar la tabla cuando se busque un proyecto en especifico
     por el nombre */
    public void llenarTabla(String nombre) {

        try {
            /* Limpiamos la tabla */
            tablaModelo.setRowCount(0);

            /* Llamamos a la funcion getProveedorNom la cual nos devuelve todos 
             los empleados relaciones con el nombre a buscar en la base de datos. 
            
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
            
             */
            ResultSet rs = datos.getProveedorNom(nombre);

            String registro[] = new String[6];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("id_proveedor");
                registro[1] = rs.getString("rif_cedula");
                registro[2] = rs.getString("nom_prove");
                registro[3] = rs.getString("tele_prove");
                registro[4] = rs.getString("direcc_prove");
                tablaModelo.addRow(registro);

            }

            tablaProveedores.setModel(tablaModelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmProveedorUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        btnModificar = new org.edisoncor.gui.button.ButtonAction();
        bntCancelar = new org.edisoncor.gui.button.ButtonAction();
        btnEliminar = new org.edisoncor.gui.button.ButtonAction();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        txtIDProveedor = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtCedulaProveedor = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtNomPro = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        cmbTelefono = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtTelefono = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric17 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();

        setClosable(true);
        setResizable(true);
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

        labelMetric1.setText("Gestion de Proovedores");
        labelMetric1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        labelMetric4.setText("Buscar:");
        labelMetric4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        labelMetric2.setText("ID Proveedor:");

        txtIDProveedor.setEnabled(false);

        txtCedulaProveedor.setEnabled(false);

        labelMetric3.setText("Rif-Cédula:");

        labelMetric5.setText("Nombre:");

        txtNomPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        labelMetric17.setText("Telefono:");

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane2.setViewportView(areaDescripcion);

        labelMetric6.setText("Descripcion:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(351, 351, 351))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(540, 540, 540))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCedulaProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNomPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(cmbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(317, 317, 317))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(34, 34, 34)))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedulaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        /* Instanciamos el objetos Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtIDProveedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el ID del Proveedor");
            txtIDProveedor.requestFocusInWindow();
            return;
        }

        if (txtCedulaProveedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cedula");
            txtCedulaProveedor.requestFocusInWindow();
            return;
        }

        if (txtNomPro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre ");
            txtNomPro.requestFocusInWindow();
            return;
        }

        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un telefono ");
            txtTelefono.requestFocusInWindow();
            return;
        }

        if (txtTelefono.getText().length() < 7) {

            JOptionPane.showMessageDialog(this, "Debe digitar un telefono valido");
            txtTelefono.setText("");
            txtTelefono.requestFocusInWindow();
            return;

        }

        if (areaDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una descripcion ");
            areaDescripcion.requestFocusInWindow();
            return;
        }


        /* Llamamos a la funcion modificarProyecto la cual recibe como parametro
         un Integer que es el ID del proyecto y un String que seria el nombre
         del proyecto */
        if (datos.modificarProveedor(Integer.parseInt(txtIDProveedor.getText()),
                txtNomPro.getText(),
                ((Opcion) cmbTelefono.getSelectedItem()).getDescripcion() + "" + txtTelefono.getText(),
                areaDescripcion.getText())) {

            JOptionPane.showMessageDialog(rootPane, "El Proveedor ha sido "
                    + "modificado correctamente ");
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido modificar a el"
                    + "Proveedor, por favor intentelo mas tarde ");

        }

        /* Limpiamos los campos  */
        txtIDProveedor.setText("");
        txtCedulaProveedor.setText("");
        txtNomPro.setText("");
        txtTelefono.setText("");
        areaDescripcion.setText("");

        tablaModelo.setRowCount(0);
        llenarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        /* Instanciamos el objetos Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtIDProveedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el ID del Proveedor");
            txtIDProveedor.requestFocusInWindow();
            return;
        }

        /* Llamamos a la funcion ElinarProveedor la cual recibe como parametro
         un Integer que es el ID del proyecto  */
        if (datos.eliminarProveedor(Integer.parseInt(txtIDProveedor.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "El Proveedor ha sido "
                    + "eliminado correctamente ");
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar el"
                    + "Proveedor, por favor intentelo mas tarde ");

        }

        /* Limpiamos los campos  */
        txtIDProveedor.setText("");
        txtCedulaProveedor.setText("");
        txtNomPro.setText("");
        txtTelefono.setText("");
        areaDescripcion.setText("");

        /* Limpiamos la tabla */
        tablaModelo.setRowCount(0);
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        /* Cuando el usuario digite en el campo txt Buscar y tabulee
         llenamos la tabla con la busqueda */
        llenarTabla(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtNomProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProKeyTyped
        /* Validar solo letras */
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        
        if (txtNomPro.getText().length() >= 40) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtNomProKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        /* Cuando el formulario se abra llenamos la tabla */
        llenarTabla();

        Opcion op = new Opcion("1", "414");

        cmbTelefono.addItem(op);

        op = new Opcion("2", "416");

        cmbTelefono.addItem(op);

        op = new Opcion("3", "426");

        cmbTelefono.addItem(op);

        op = new Opcion("4", "412");

        cmbTelefono.addItem(op);

        op = new Opcion("5", "424");

        cmbTelefono.addItem(op);

        op = new Opcion("5", "212");

        cmbTelefono.addItem(op);

    }//GEN-LAST:event_formInternalFrameOpened

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        /* Variable que contendra el ID de la fila seleccionada */
        int s = 0;

        /* Limpiamos los campos  */
        txtIDProveedor.setText("");
        txtCedulaProveedor.setText("");
        txtNomPro.setText("");

        /* Guardamos el ID de dla fila selecciona en la variable s*/
        s = tablaProveedores.getSelectedRow();

        /* Validamos que hallan seleccionado */
        if (s < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un proveedor");
            return;
        }

        String telefono = Utilidades.objectToString(tablaProveedores.getValueAt(s, 3));

        char[] tele = telefono.toCharArray();
        
        telefono = "";
        
        for (int x=3; x < tele.length; x++){
            telefono += "" + tele[x];
            
        }
        
        /* Llenamos el campo IDProveedor con el ID de la fila seleccionada

         - Como la funcion getValueAt recibe como parametro, el numero de la fila
         y el numero de la columna y devuelve como parametro un Objeto y el campo
         txt recibe es un String, hay que hacer la conversion de objeto a String.
         Para eso utilizamos el metodo de la clase Utilidades objetoToString
         que me transforma un objeto a String.

         */
        txtIDProveedor.setText(Utilidades.objectToString(tablaProveedores.getValueAt(s, 0)));
        txtCedulaProveedor.setText(Utilidades.objectToString(tablaProveedores.getValueAt(s, 1)));
        txtNomPro.setText(Utilidades.objectToString(tablaProveedores.getValueAt(s, 2)));
        txtTelefono.setText(telefono);
        areaDescripcion.setText(Utilidades.objectToString(tablaProveedores.getValueAt(s, 4)));

    }//GEN-LAST:event_tablaProveedoresMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private org.edisoncor.gui.button.ButtonAction bntCancelar;
    private org.edisoncor.gui.button.ButtonAction btnEliminar;
    private org.edisoncor.gui.button.ButtonAction btnModificar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric17;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaProveedores;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBuscar;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtCedulaProveedor;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtIDProveedor;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtNomPro;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtTelefono;
    // End of variables declaration//GEN-END:variables
}
