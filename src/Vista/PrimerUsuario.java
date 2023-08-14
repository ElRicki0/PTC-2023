/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlEncriptacion;
import Controlador.ctrlPrimerUsuario;
import Modelo.usuarios;

/**
 *
 * @author rnmel
 */
public class PrimerUsuario extends javax.swing.JFrame {

    
    public PrimerUsuario() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCurvas3 = new Vista.PanelCurvas();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas4 = new Vista.PanelCurvas();
        txtContrasenia = new javax.swing.JTextField();
        panelCurvas7 = new Vista.PanelCurvas();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 730));
        setSize(new java.awt.Dimension(750, 730));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(25);
        panelCurvas1.setRoundBottomRight(25);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Bienvenido Usuario");
        panelCurvas1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 41));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 100));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("<html>Ahora para poder continuer, nesesitamos que ingrese los datos de su usuario para el sistema </html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 520, 110));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Ingrese su Usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 220, 30));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);
        panelCurvas3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setBorder(null);
        panelCurvas3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 290, 60));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ingrese su Contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 190, 30));

        panelCurvas4.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);
        panelCurvas4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtContrasenia.setForeground(new java.awt.Color(51, 51, 51));
        txtContrasenia.setBorder(null);
        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });
        panelCurvas4.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 290, 60));

        panelCurvas7.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas7.setRoundBottomLeft(50);
        panelCurvas7.setRoundBottomRight(50);
        panelCurvas7.setRoundTopLeft(50);
        panelCurvas7.setRoundTopRight(50);

        btnAgregar.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas7Layout = new javax.swing.GroupLayout(panelCurvas7);
        panelCurvas7.setLayout(panelCurvas7Layout);
        panelCurvas7Layout.setHorizontalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas7Layout.setVerticalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void transparenciaBotin(){
        btnAgregar.setOpaque(false);        
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setBorderPainted(false);
    }
    
    /**
     * @param args the command line arguments
     */
    
    public void INIT(){
            PrimerUsuario vistaPUsuario = new PrimerUsuario();
            usuarios modeloUsuario= new usuarios();
            LoginPTC login=new LoginPTC();
            ctrlEncriptacion encript= new ctrlEncriptacion();

            ctrlPrimerUsuario cotrl = new ctrlPrimerUsuario(vistaPUsuario, modeloUsuario, login, encript);
            vistaPUsuario.setVisible(true);
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
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    public javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas3;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas7;
    public javax.swing.JTextField txtContrasenia;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
