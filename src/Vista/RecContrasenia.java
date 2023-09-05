/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlPrimerUsuario;
import Modelo.usuarios;

/**
 *
 * @author rnmel
 */
public class RecContrasenia extends javax.swing.JFrame {

    
    public RecContrasenia() {
        initComponents();
        this.setLocationRelativeTo(null);
        transparenciaBotin();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel15 = new javax.swing.JLabel();
        btnCorreo = new Vista.PanelCurvas();
        jLabel9 = new javax.swing.JLabel();
        btnSMS = new Vista.PanelCurvas();
        jLabel8 = new javax.swing.JLabel();
        btnPreguntas = new Vista.PanelCurvas();
        jLabel7 = new javax.swing.JLabel();
        panelCurvas7 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 473));
        setMinimumSize(new java.awt.Dimension(750, 473));
        setResizable(false);
        setSize(new java.awt.Dimension(750, 473));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(25);
        panelCurvas1.setRoundBottomRight(25);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Leelawadee UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("<html>Eliga un metodo de recuperacion de Cuenta</html>");
        panelCurvas1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 630, 130));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 150));

        btnCorreo.setBackground(new java.awt.Color(255, 255, 255));
        btnCorreo.setRoundBottomLeft(25);
        btnCorreo.setRoundBottomRight(25);
        btnCorreo.setRoundTopLeft(25);
        btnCorreo.setRoundTopRight(25);
        btnCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCorreoMouseClicked(evt);
            }
        });
        btnCorreo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/correo.png"))); // NOI18N
        btnCorreo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 130));

        jPanel1.add(btnCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 170, 170));

        btnSMS.setBackground(new java.awt.Color(255, 255, 255));
        btnSMS.setRoundBottomLeft(25);
        btnSMS.setRoundBottomRight(25);
        btnSMS.setRoundTopLeft(25);
        btnSMS.setRoundTopRight(25);
        btnSMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSMSMouseClicked(evt);
            }
        });
        btnSMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/SMS.png"))); // NOI18N
        btnSMS.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 130));

        jPanel1.add(btnSMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 170, 170));

        btnPreguntas.setBackground(new java.awt.Color(255, 255, 255));
        btnPreguntas.setRoundBottomLeft(25);
        btnPreguntas.setRoundBottomRight(25);
        btnPreguntas.setRoundTopLeft(25);
        btnPreguntas.setRoundTopRight(25);
        btnPreguntas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/preguntas.png"))); // NOI18N
        btnPreguntas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 130));

        jPanel1.add(btnPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 170, 170));

        panelCurvas7.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas7.setPreferredSize(new java.awt.Dimension(100, 100));
        panelCurvas7.setRoundBottomLeft(50);
        panelCurvas7.setRoundBottomRight(50);
        panelCurvas7.setRoundTopLeft(50);
        panelCurvas7.setRoundTopRight(50);
        panelCurvas7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCurvas7MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/flecha.png"))); // NOI18N

        javax.swing.GroupLayout panelCurvas7Layout = new javax.swing.GroupLayout(panelCurvas7);
        panelCurvas7.setLayout(panelCurvas7Layout);
        panelCurvas7Layout.setHorizontalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelCurvas7Layout.setVerticalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 100, 100));

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(64, 81, 115));
        jLabel14.setText("Preguntas de usuario");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 200, 30));

        jLabel16.setFont(new java.awt.Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(64, 81, 115));
        jLabel16.setText("Correo electronico");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, 30));

        jLabel17.setFont(new java.awt.Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(64, 81, 115));
        jLabel17.setText("Mensaje SMS");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCurvas7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCurvas7MouseClicked
        LoginPTC vista = new LoginPTC();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_panelCurvas7MouseClicked

    private void btnCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCorreoMouseClicked
        ContraGMAIL vista = new ContraGMAIL();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnCorreoMouseClicked

    private void btnSMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMSMouseClicked

        ContraSMS vista = new ContraSMS();
        vista.show();
        this.dispose();
    }//GEN-LAST:event_btnSMSMouseClicked

    public void transparenciaBotin(){
    }
    
    /**
     * @param args the command line arguments
     */
    
    public void INIT(){
            RecContrasenia vista = new RecContrasenia();
            vista.setVisible(true);
        }   
    
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
            java.util.logging.Logger.getLogger(RecContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
                 
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.PanelCurvas btnCorreo;
    private Vista.PanelCurvas btnPreguntas;
    private Vista.PanelCurvas btnSMS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas7;
    // End of variables declaration//GEN-END:variables
}
