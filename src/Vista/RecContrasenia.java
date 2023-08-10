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
        jLabel14 = new javax.swing.JLabel();
        panelCurvas5 = new Vista.PanelCurvas();
        jLabel4 = new javax.swing.JLabel();
        panelCurvas6 = new Vista.PanelCurvas();
        jLabel5 = new javax.swing.JLabel();
        panelCurvas4 = new Vista.PanelCurvas();
        jLabel3 = new javax.swing.JLabel();
        panelCurvas7 = new Vista.PanelCurvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 730));
        setSize(new java.awt.Dimension(750, 730));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(25);
        panelCurvas1.setRoundBottomRight(25);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("<html>Eliga un metodo de recuperacion de Cuenta</html>");
        panelCurvas1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 630, 80));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 100));

        panelCurvas5.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);
        panelCurvas5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCurvas5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 160));

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 170, 160));

        panelCurvas6.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas6.setRoundBottomLeft(25);
        panelCurvas6.setRoundBottomRight(25);
        panelCurvas6.setRoundTopLeft(25);
        panelCurvas6.setRoundTopRight(25);
        panelCurvas6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCurvas6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 160));

        jPanel1.add(panelCurvas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 170, 160));

        panelCurvas4.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);
        panelCurvas4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCurvas4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 160));

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 160));

        panelCurvas7.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas7.setRoundBottomLeft(50);
        panelCurvas7.setRoundBottomRight(50);
        panelCurvas7.setRoundTopLeft(50);
        panelCurvas7.setRoundTopRight(50);

        javax.swing.GroupLayout panelCurvas7Layout = new javax.swing.GroupLayout(panelCurvas7);
        panelCurvas7.setLayout(panelCurvas7Layout);
        panelCurvas7Layout.setHorizontalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelCurvas7Layout.setVerticalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas5;
    private Vista.PanelCurvas panelCurvas6;
    private Vista.PanelCurvas panelCurvas7;
    // End of variables declaration//GEN-END:variables
}
