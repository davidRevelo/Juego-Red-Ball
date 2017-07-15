/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.swing.JOptionPane;

/**
 *
 * @author 22B
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        cb_perfil.addItem("");
        cb_perfil.addItem("ADMINISTRADOR");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_perfil = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_ced = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nom_user = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_registrarse = new javax.swing.JButton();
        btn_ir_iniciar = new javax.swing.JButton();
        txt_contra = new javax.swing.JPasswordField();
        txt_ncontra = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txt_no = new javax.swing.JLabel();
        txt_d = new javax.swing.JLabel();
        txt_s = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_selec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Apellidos y Nombres");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel3.setText("PERFIL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        cb_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_perfilActionPerformed(evt);
            }
        });
        getContentPane().add(cb_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 132, -1));

        jLabel4.setText("Cédula");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel5.setText("Correo electrónico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 297, -1));

        txt_ced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedActionPerformed(evt);
            }
        });
        getContentPane().add(txt_ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 297, -1));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 297, -1));

        jLabel6.setText("Contraseña");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jLabel7.setText("Vuelva a escribir la contraseña");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jLabel8.setText("Nombre de usuario");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));
        getContentPane().add(txt_nom_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 297, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reg.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 620, 130));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/owl.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        btn_registrarse.setBackground(new java.awt.Color(0, 51, 255));
        btn_registrarse.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrarse.setText("REGISTRARSE");
        btn_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, -1, -1));

        btn_ir_iniciar.setBackground(new java.awt.Color(0, 51, 255));
        btn_ir_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ir_iniciar.setText("Ir a Iniciar Sesión");
        btn_ir_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ir_iniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ir_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, -1, 20));
        getContentPane().add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 290, -1));
        getContentPane().add(txt_ncontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 290, -1));

        jLabel12.setFont(new java.awt.Font("Elephant", 1, 12)); // NOI18N
        jLabel12.setText("REGISTRO DE USUARIOS");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 120, 220, -1));

        txt_no.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(txt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 220, 20));

        txt_d.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(txt_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 670, 240, 20));

        txt_s.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txt_s.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txt_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 210, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blanco.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 620, 640));

        txt_selec.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txt_selec.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(txt_selec, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_cedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedActionPerformed

    private void btn_ir_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ir_iniciarActionPerformed
        // TODO add your handling code here:
        Inicio inicio=new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_ir_iniciarActionPerformed

    private void cb_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_perfilActionPerformed
        // TODO add your handling code here:
        
        if(cb_perfil.getSelectedItem().equals("")){
            txt_s.setText("Seleccione un perfil e ingrese los datos");
            txt_no.setText("");
            txt_d.setText("");
            txt_nombre.setEnabled(false);
            txt_nom_user.setEnabled(false);
            txt_ced.setEnabled(false);
            txt_contra.setEnabled(false);
            txt_ncontra.setEnabled(false);
            txt_correo.setEnabled(false);
            txt_nombre.setText("");
            txt_nom_user.setText("");
            txt_ced.setText("");
            txt_contra.setText("");
            txt_ncontra.setText("");
            txt_correo.setText("");
            
        }
        else{
            txt_s.setText("");
            txt_nombre.setEnabled(true);
            txt_nom_user.setEnabled(true);
            txt_ced.setEnabled(true);
            txt_contra.setEnabled(true);
            txt_ncontra.setEnabled(true);
            txt_correo.setEnabled(true);
        }
    }//GEN-LAST:event_cb_perfilActionPerformed

    private void btn_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarseActionPerformed
        // TODO add your handling code here:
        String n=txt_nombre.getText();
        String u=txt_nom_user.getText();
        String c=txt_ced.getText();
        String co=txt_correo.getText();
        String Pcontra=txt_contra.getText();
        String Scontra=txt_ncontra.getText();
        
         if(cb_perfil.getSelectedItem().equals("")==false &&  (n.equals("")||u.equals("")||c.equals("")||Pcontra.equals("")||Scontra.equals("")||co.equals("")) ){
            txt_d.setText("INGRESE TODOS LOS DATOS");
        }
         else if(cb_perfil.getSelectedItem().equals("")){
             txt_s.setText("Seleccione un perfil e ingrese los datos");
         }

        else if(Pcontra.equals(Scontra)==false ){
            txt_no.setText("* Las contraseñas no coinciden");
        }
       
        else{
            
            txt_d.setText("Su cuenta ha sido registrada exitosamente");
            txt_s.setText("");
            txt_no.setText("");
        }
      
    }//GEN-LAST:event_btn_registrarseActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        String Pcontra=txt_contra.getText();
        String Scontra=txt_ncontra.getText();
        if(Pcontra.equals(Scontra)==false ){
            txt_no.setText("* Las contraseñas no coinciden");
        }  else{
            txt_no.setText("");
            
        }
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ir_iniciar;
    private javax.swing.JButton btn_registrarse;
    private javax.swing.JComboBox cb_perfil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_ced;
    private javax.swing.JPasswordField txt_contra;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JLabel txt_d;
    private javax.swing.JPasswordField txt_ncontra;
    private javax.swing.JLabel txt_no;
    private javax.swing.JTextField txt_nom_user;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JLabel txt_s;
    private javax.swing.JLabel txt_selec;
    // End of variables declaration//GEN-END:variables
}
