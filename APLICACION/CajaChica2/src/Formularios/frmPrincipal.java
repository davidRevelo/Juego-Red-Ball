/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import javax.swing.JOptionPane;

/**
 *
 * @author Victor Pino
 */
public class frmPrincipal extends javax.swing.JFrame {

    public String usuario;
    public Integer perfil;
    public String cargo;
    public Integer id;
    public String nombre;

    public frmPrincipal() {
        initComponents();
    }

    public void setUsuario(String usuario, int id, int perfil, String cargo, String nombre) {
        this.usuario = usuario;
        this.id = id;
        this.perfil = perfil;
        this.cargo = cargo;
        this.nombre = nombre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new javax.swing.JDesktopPane();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHerramientas = new javax.swing.JMenu();
        mnuHerramientasAddProyecto = new javax.swing.JMenuItem();
        mnuHerramientasUpdateProyecto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuHerramientaEmpleado = new javax.swing.JMenuItem();
        mnuHerramientasUpdateEmpleado = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuHerramientasAddProveedor = new javax.swing.JMenuItem();
        mnuHerramientasUpdateProveedor = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuHerramientasMontoUpdate = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuHerramientasUsuarioUp = new javax.swing.JMenuItem();
        mnuFactura = new javax.swing.JMenu();
        mnuFacturaAdd = new javax.swing.JMenuItem();
        mnuFacturaUp = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuConsultasFactura = new javax.swing.JMenuItem();
        mnuConsultasReserva = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caja Chica");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondosis.jpg"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        dpnEscritorio.setLayer(panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpnEscritorioLayout = new javax.swing.GroupLayout(dpnEscritorio);
        dpnEscritorio.setLayout(dpnEscritorioLayout);
        dpnEscritorioLayout.setHorizontalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dpnEscritorioLayout.setVerticalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mnuHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/herra3-48.png"))); // NOI18N
        mnuHerramientas.setText("Herramientas Administrativas");

        mnuHerramientasAddProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proyecto-32.png"))); // NOI18N
        mnuHerramientasAddProyecto.setText("Registrar Solicitud");
        mnuHerramientasAddProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasAddProyectoActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasAddProyecto);

        mnuHerramientasUpdateProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/uppro-32.png"))); // NOI18N
        mnuHerramientasUpdateProyecto.setText("Modificar Solicitud");
        mnuHerramientasUpdateProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasUpdateProyectoActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasUpdateProyecto);
        mnuHerramientas.add(jSeparator1);

        mnuHerramientaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios-32.png"))); // NOI18N
        mnuHerramientaEmpleado.setText("Registrar Usuario");
        mnuHerramientaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientaEmpleadoActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientaEmpleado);

        mnuHerramientasUpdateEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar-em-32.png"))); // NOI18N
        mnuHerramientasUpdateEmpleado.setText("Modificar Usuario");
        mnuHerramientasUpdateEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasUpdateEmpleadoActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasUpdateEmpleado);
        mnuHerramientas.add(jSeparator2);

        mnuHerramientasAddProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor-32.png"))); // NOI18N
        mnuHerramientasAddProveedor.setText("Registrar Proveedor");
        mnuHerramientasAddProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasAddProveedorActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasAddProveedor);

        mnuHerramientasUpdateProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar-up-32.png"))); // NOI18N
        mnuHerramientasUpdateProveedor.setText("Modificar Proveedor");
        mnuHerramientasUpdateProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasUpdateProveedorActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasUpdateProveedor);
        mnuHerramientas.add(jSeparator3);

        mnuHerramientasMontoUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/monto-up-32.png"))); // NOI18N
        mnuHerramientasMontoUpdate.setText(" Reserva");
        mnuHerramientasMontoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasMontoUpdateActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasMontoUpdate);
        mnuHerramientas.add(jSeparator4);

        mnuHerramientasUsuarioUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario-up-32.png"))); // NOI18N
        mnuHerramientasUsuarioUp.setText("Modificar y/o Eliminar Usuario");
        mnuHerramientasUsuarioUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHerramientasUsuarioUpActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mnuHerramientasUsuarioUp);

        jMenuBar1.add(mnuHerramientas);

        mnuFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura-48.png"))); // NOI18N
        mnuFactura.setText("Factura");

        mnuFacturaAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro-factura2-48.png"))); // NOI18N
        mnuFacturaAdd.setText("Registrar Factura");
        mnuFacturaAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFacturaAddActionPerformed(evt);
            }
        });
        mnuFactura.add(mnuFacturaAdd);

        mnuFacturaUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EditDocument-48.png"))); // NOI18N
        mnuFacturaUp.setText("Cambio de Status de Factura");
        mnuFacturaUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFacturaUpActionPerformed(evt);
            }
        });
        mnuFactura.add(mnuFacturaUp);

        jMenuBar1.add(mnuFactura);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultas-48.png"))); // NOI18N
        mnuConsultas.setText("Consultas y Reportes");

        mnuConsultasFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte2-32.png"))); // NOI18N
        mnuConsultasFactura.setText("Consultar Factura");
        mnuConsultasFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultasFacturaActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuConsultasFactura);

        mnuConsultasReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/monto-32.png"))); // NOI18N
        mnuConsultasReserva.setText("Consultar Reserva");
        mnuConsultasReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultasReservaActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuConsultasReserva);

        jMenuBar1.add(mnuConsultas);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit-48.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuHerramientasAddProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasAddProyectoActionPerformed

        frmProyectoAdd inser = new frmProyectoAdd();
        dpnEscritorio.add(inser);
        inser.setUsuario(usuario);
        inser.show();


    }//GEN-LAST:event_mnuHerramientasAddProyectoActionPerformed

    private void mnuHerramientasUpdateProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasUpdateProyectoActionPerformed

        frmProyectoUp updele = new frmProyectoUp();
        dpnEscritorio.add(updele);
        updele.setUsuario(usuario);
        updele.show();


    }//GEN-LAST:event_mnuHerramientasUpdateProyectoActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuHerramientaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientaEmpleadoActionPerformed

        frmPersonal personal = new frmPersonal();
        dpnEscritorio.add(personal);
        personal.setUsuario(usuario);
        personal.show();

    }//GEN-LAST:event_mnuHerramientaEmpleadoActionPerformed

    private void mnuHerramientasUpdateEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasUpdateEmpleadoActionPerformed

        frmPersonalUp up = new frmPersonalUp();
        dpnEscritorio.add(up);
        up.setUsuario(usuario);
        up.show();

    }//GEN-LAST:event_mnuHerramientasUpdateEmpleadoActionPerformed

    private void mnuHerramientasAddProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasAddProveedorActionPerformed

        frmProveedor proveedor = new frmProveedor();
        dpnEscritorio.add(proveedor);
        proveedor.setUsuario(usuario);
        proveedor.show();

    }//GEN-LAST:event_mnuHerramientasAddProveedorActionPerformed

    private void mnuHerramientasUpdateProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasUpdateProveedorActionPerformed

        frmProveedorUp up = new frmProveedorUp();
        dpnEscritorio.add(up);
        up.setUsuario(usuario);
        up.show();

    }//GEN-LAST:event_mnuHerramientasUpdateProveedorActionPerformed

    private void mnuFacturaAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFacturaAddActionPerformed
        frmFactura fac = new frmFactura();
        dpnEscritorio.add(fac);
        fac.setUsuario(usuario, id, perfil, cargo);
        fac.show();
    }//GEN-LAST:event_mnuFacturaAddActionPerformed

    private void mnuConsultasFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultasFacturaActionPerformed
        frmConsultarFacturas con = new frmConsultarFacturas();
        dpnEscritorio.add(con);
        con.setUsuario(usuario, id, perfil, cargo, nombre);
        con.setVisible(true);
        con.show();
    }//GEN-LAST:event_mnuConsultasFacturaActionPerformed

    private void mnuHerramientasMontoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasMontoUpdateActionPerformed
        frmReserva update = new frmReserva();
        dpnEscritorio.add(update);
        update.setVisible(true);
        update.show();
    }//GEN-LAST:event_mnuHerramientasMontoUpdateActionPerformed

    private void mnuConsultasReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultasReservaActionPerformed

        frmConsultaReserva reser = new frmConsultaReserva();
        dpnEscritorio.add(reser);
        reser.setVisible(true);
        reser.show();

    }//GEN-LAST:event_mnuConsultasReservaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         
       
        if (cargo.equals("Director")) {
                mnuFacturaUp.setEnabled(true);
                mnuHerramientas.setEnabled(true);
            } else {
                mnuFacturaUp.setEnabled(false);
                mnuHerramientaEmpleado.setEnabled(false);
                mnuHerramientasAddProveedor.setEnabled(false);
                mnuHerramientasAddProyecto.setEnabled(false);
                mnuHerramientasMontoUpdate.setEnabled(false);
                mnuHerramientasUpdateEmpleado.setEnabled(false);
                mnuHerramientasUpdateProveedor.setEnabled(false);
                mnuHerramientasUpdateProyecto.setEnabled(false);
                mnuHerramientasUsuarioUp.setEnabled(true);
                mnuHerramientasMontoUpdate.setEnabled(false);
                mnuConsultasReserva.setEnabled(false);
            }

            if (cargo.equals("Gerente") || cargo.equals("Administrador")) {
                mnuHerramientaEmpleado.setEnabled(true);
                mnuHerramientasAddProveedor.setEnabled(true);
                mnuHerramientasAddProyecto.setEnabled(true);
                mnuHerramientasMontoUpdate.setEnabled(true);
                mnuHerramientasUpdateEmpleado.setEnabled(true);
                mnuHerramientasUpdateProveedor.setEnabled(true);
                mnuHerramientasUpdateProyecto.setEnabled(true);
                mnuHerramientasUsuarioUp.setEnabled(true);
                mnuFacturaUp.setEnabled(false);
                mnuHerramientasMontoUpdate.setEnabled(false);
                mnuConsultasReserva.setEnabled(false);
            }

        this.setTitle(usuario);
    }//GEN-LAST:event_formWindowOpened

    private void mnuHerramientasUsuarioUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHerramientasUsuarioUpActionPerformed

        frmUsuarioUp up = new frmUsuarioUp();
        dpnEscritorio.add(up);
        up.setVisible(true);
        up.show();

    }//GEN-LAST:event_mnuHerramientasUsuarioUpActionPerformed

    private void mnuFacturaUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFacturaUpActionPerformed

        frmFacturaUp factura = new frmFacturaUp();
        dpnEscritorio.add(factura);
        factura.setVisible(true);
        factura.show();

    }//GEN-LAST:event_mnuFacturaUpActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenuItem mnuConsultasFactura;
    private javax.swing.JMenuItem mnuConsultasReserva;
    private javax.swing.JMenu mnuFactura;
    private javax.swing.JMenuItem mnuFacturaAdd;
    private javax.swing.JMenuItem mnuFacturaUp;
    private javax.swing.JMenuItem mnuHerramientaEmpleado;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenuItem mnuHerramientasAddProveedor;
    private javax.swing.JMenuItem mnuHerramientasAddProyecto;
    private javax.swing.JMenuItem mnuHerramientasMontoUpdate;
    private javax.swing.JMenuItem mnuHerramientasUpdateEmpleado;
    private javax.swing.JMenuItem mnuHerramientasUpdateProveedor;
    private javax.swing.JMenuItem mnuHerramientasUpdateProyecto;
    private javax.swing.JMenuItem mnuHerramientasUsuarioUp;
    private javax.swing.JMenu mnuSalir;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
