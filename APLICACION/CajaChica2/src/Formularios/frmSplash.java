/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Cargar;
import com.sun.awt.AWTUtilities;

/**
 *
 * @author sofia
 */
public final class frmSplash extends javax.swing.JFrame {

    double i = 50, j = 1;
    Cargar hilo;

    public frmSplash() {
        initComponents();
        iniciar();
    }

    public void iniciar() {

        /* Le pasamos la barra de progreso al objeto que instanciamos*/
        hilo = new Cargar(barraProgreso);

        /* Iniciamos el hilo */
        hilo.start();

        hilo = null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraProgreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraProgresoStateChanged(evt);
            }
        });
        getContentPane().add(barraProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 900, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diseño de sist caja chica.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraProgresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraProgresoStateChanged

        if (barraProgreso.getValue() == i) {
            if (j != 101) {

                AWTUtilities.setWindowOpacity(this, Float.valueOf((100 - j) / 100 + "f"));
                i++;
                j += 2;
            }

        }

        if (barraProgreso.getValue() == 100) {
            frmLogin login = new frmLogin();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            this.dispose();
        }

    }//GEN-LAST:event_barraProgresoStateChanged

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
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
