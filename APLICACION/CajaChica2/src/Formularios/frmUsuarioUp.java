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
 * @author vpino
 */
public class frmUsuarioUp extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmUsuarioUp
     */
    public frmUsuarioUp() {
        initComponents();
    }

    /* Definimos los titulos que llevara la tabla*/
    public String titulos[] = {"ID Usuario", "Tipo Usuario", "Nombre"};

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

            /* Llamos a la funcion getUsuarios la cual nos devuelve todos 
             los usuarios registrados en la base de datos. 
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
             */
            ResultSet rs = datos.getUsuarios();

            /* Instaciamos un obejto vector tipo string, el cual nos servira
             para guardar las filas de la tabla. */
            String registro[] = new String[4];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("id_usuario");
                registro[1] = rs.getString("tipo_usu");
                registro[2] = rs.getString("usuario");
                tablaModelo.addRow(registro);

            }

            tablaUsuarios.setModel(tablaModelo);
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

            /* Llamos a la funcion getUsuariosNom la cual nos devuelve todos 
             los usuarios relaciones con el nombre a buscar en la base de datos. 
            
             - Los datos recibidos lo guardamos en el objeto ResulSet para luego
             llenar la tabla con los registros.
            
             */
            ResultSet rs = datos.getUsuariosNom(nombre);

            String registro[] = new String[4];

            /* Hacemos un while que mientras en rs hallan datos el ira agregando
             filas a la tabla. */
            while (rs.next()) {

                registro[0] = rs.getString("id_usuario");
                registro[1] = rs.getString("tipo_usu");
                registro[2] = rs.getString("usuario");
                tablaModelo.addRow(registro);

            }

            tablaUsuarios.setModel(tablaModelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmProyectoUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnModificar = new org.edisoncor.gui.button.ButtonAction();
        bntCancelar = new org.edisoncor.gui.button.ButtonAction();
        btnEliminar = new org.edisoncor.gui.button.ButtonAction();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        txtConfirmarClave = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric21 = new org.edisoncor.gui.label.LabelMetric();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        txtNuevaClave = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();

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

        labelMetric1.setText("Gestión de Usuarios");
        labelMetric1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

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

        txtConfirmarClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveKeyTyped(evt);
            }
        });

        labelMetric9.setText("Confirmar Clave:");

        labelMetric21.setText("Usuario:");

        txtUsuario.setEnabled(false);

        labelMetric10.setText("Nueva Clave:");

        txtNuevaClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevaClaveKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelMetric9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMetric10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtConfirmarClave, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                            .addComponent(txtNuevaClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNuevaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        /* Variable que contendra el ID de la fila seleccionada */
        int s = 0;

        /* Limpiamos los campos  */
        txtUsuario.setText("");


        /* Guardamos el ID de dla fila selecciona en la variable s*/
        s = tablaUsuarios.getSelectedRow();

        /* Validamos que hallan seleccionado */
        if (s < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario");
            return;
        }

        /* Llenamos los campos mrediante el ID de la fila seleccionada

         - Como la funcion getValueAt recibe como parametro, el numero de la fila
         y el numero de la columna y devuelve como parametro un Objeto y el campo
         txt recibe es un String, hay que hacer la conversion de objeto a String.
         Para eso utilizamos el metodo de la clase Utilidades objetoToString
         que me transforma un objeto a String.

         */
        txtUsuario.setText(Utilidades.objectToString(tablaUsuarios.getValueAt(s, 2)));
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        /* Instanciamos el objetos Datos */
        Datos datos = new Datos();

        /* Validaciones */
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre de usuario");
            txtUsuario.requestFocusInWindow();
            return;
        }

        /* Como el cambo passwordfield nos devuelve un array, hay que transformarlo
         a String para validarlo y luego compararlo con la confirmacion */
       
        String newClave = new String(txtNuevaClave.getPassword());

        if (newClave.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la nueva clave del usuario");
            txtNuevaClave.requestFocusInWindow();
            return;
        }

        String confirmar = new String(txtConfirmarClave.getPassword());

        if (confirmar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe confirmar la nueva clave ");
            txtConfirmarClave.requestFocusInWindow();
            return;
        }

        if (!newClave.equals(confirmar)) {
            JOptionPane.showMessageDialog(rootPane, "Las claves no coinciden, "
                    + "por favor vuelva a ingresarlas");
            txtNuevaClave.setText("");
            txtConfirmarClave.setText("");
            txtNuevaClave.requestFocusInWindow();
            return;
        }

        /* Llamamos a la funcion modificarUsuario */
        if (datos.modificarUsuario(txtUsuario.getText(), newClave)) {

            JOptionPane.showMessageDialog(rootPane, "El Usuario ha sido "
                    + "modificado correctamente ");
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido modificar a el"
                    + "Usuario, por favor intentelo mas tarde ");

        }

        /* Limpiamos los campos  */
        txtUsuario.setText("");
        txtNuevaClave.setText("");
        txtConfirmarClave.setText("");

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
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar el nombre del Usuario");
            txtUsuario.requestFocusInWindow();
            return;
        }

        /* Llamamos a la funcion ElinarProveedor la cual recibe como parametro
         un Integer que es el ID del proyecto  */
        if (datos.eliminarUsuario(txtUsuario.getText())) {
            JOptionPane.showMessageDialog(rootPane, "El Usuario ha sido "
                    + "eliminado correctamente ");
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar el"
                    + "Usuario, por favor intentelo mas tarde ");

        }

        /* Limpiamos los campos  */
        txtUsuario.setText("");
        txtNuevaClave.setText("");
        txtConfirmarClave.setText("");

        /* Limpiamos la tabla */
        tablaModelo.setRowCount(0);
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        /* Cuando el usuario digite en el campo txt Buscar y tabulee
         llenamos la tabla con la busqueda */
        llenarTabla(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtConfirmarClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveKeyTyped
        
        if (txtConfirmarClave.getPassword().length >= 10) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "La clave debe ser menor o igual a 10 caracteres");

        }
    }//GEN-LAST:event_txtConfirmarClaveKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       /* Cuando el formulario se abra llenamos la tabla */
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNuevaClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaClaveKeyTyped
         
        if (txtNuevaClave.getPassword().length >= 10) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "La clave debe ser menor o igual a 10 caracteres");

        }
    }//GEN-LAST:event_txtNuevaClaveKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bntCancelar;
    private org.edisoncor.gui.button.ButtonAction btnEliminar;
    private org.edisoncor.gui.button.ButtonAction btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric21;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaUsuarios;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBuscar;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtConfirmarClave;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtNuevaClave;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
