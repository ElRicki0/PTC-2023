/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlActualizarContra;
import Controlador.ctrlEncriptacion;
import Controlador.ctrlPrimerUsuario;
import Modelo.CConexion;
import Modelo.usuarios;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ActContra extends javax.swing.JFrame {

    public ActContra() {
        initComponents();
        this.jbNo.setVisible(false);
        this.setLocationRelativeTo(null);
        TextPrompt textPrompta2 = new TextPrompt("Ingresar una contraseña", this.txtContra);
        TextPrompt textPrompta3 = new TextPrompt("Confirmar contraseña", this.txtContra2);
        rsscalelabel.RSScaleLabel.setScaleLabel(lbVer, "src/Vista/Iconos/ver.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(lbNover, "src/Vista/Iconos/noVer.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(lbVer2, "src/Vista/Iconos/ver.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(lbNover2, "src/Vista/Iconos/noVer.png");
        transparenciaBotin();
        this.lbNover.setVisible(false);
        this.lbNover2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCurvas3 = new Vista.PanelCurvas();
        txtContra2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas4 = new Vista.PanelCurvas();
        txtContra = new javax.swing.JPasswordField();
        panelCurvas7 = new Vista.PanelCurvas();
        btnActualizar = new javax.swing.JButton();
        jbVer = new javax.swing.JLabel();
        jbNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbVer = new javax.swing.JLabel();
        lbNover = new javax.swing.JLabel();
        lbVer2 = new javax.swing.JLabel();
        lbNover2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 730));
        setResizable(false);
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

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Repita su contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 220, 30));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);
        panelCurvas3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContra2.setBackground(new java.awt.Color(255, 255, 255));
        txtContra2.setForeground(new java.awt.Color(0, 0, 0));
        txtContra2.setBorder(null);
        panelCurvas3.add(txtContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 40));

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 290, 60));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ingrese su Contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 190, 30));

        panelCurvas4.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);
        panelCurvas4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContra.setBackground(new java.awt.Color(255, 255, 255));
        txtContra.setForeground(new java.awt.Color(0, 0, 0));
        txtContra.setBorder(null);
        panelCurvas4.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 40));

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 290, 60));

        panelCurvas7.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas7.setRoundBottomLeft(50);
        panelCurvas7.setRoundBottomRight(50);
        panelCurvas7.setRoundTopLeft(50);
        panelCurvas7.setRoundTopRight(50);

        btnActualizar.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas7Layout = new javax.swing.GroupLayout(panelCurvas7);
        panelCurvas7.setLayout(panelCurvas7Layout);
        panelCurvas7Layout.setHorizontalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas7Layout.setVerticalGroup(
            panelCurvas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 230, -1));

        jbVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVerMouseClicked(evt);
            }
        });
        jPanel1.add(jbVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 60, 50));

        jbNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNoMouseClicked(evt);
            }
        });
        jPanel1.add(jbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 60, 50));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("<html>Se ha detectado que es la primera ves en el sistema, por favor ingrese su nueva contraseña para su usuario</html>");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 520, 110));

        lbVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVerMouseClicked(evt);
            }
        });
        jPanel1.add(lbVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 50, 50));

        lbNover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNoverMouseClicked(evt);
            }
        });
        jPanel1.add(lbNover, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 50, 50));

        lbVer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVer2MouseClicked(evt);
            }
        });
        jPanel1.add(lbVer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 50, 50));

        lbNover2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNover2MouseClicked(evt);
            }
        });
        jPanel1.add(lbNover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 50, 50));

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

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jbVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVerMouseClicked
        jbVer.setVisible(false);
        jbNo.setVisible(true);
        txtContra.setEchoChar((char) 0);
    }//GEN-LAST:event_jbVerMouseClicked

    private void jbNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNoMouseClicked
        jbVer.setVisible(true);
        jbNo.setVisible(false);
        txtContra.setEchoChar('*');
    }//GEN-LAST:event_jbNoMouseClicked

    private void lbVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerMouseClicked
        lbVer.setVisible(false);
        lbNover.setVisible(true);
        txtContra.setEchoChar((char) 0);
    }//GEN-LAST:event_lbVerMouseClicked

    private void lbNoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNoverMouseClicked
        lbVer.setVisible(true);
        lbNover.setVisible(false);
        txtContra.setEchoChar('*');
    }//GEN-LAST:event_lbNoverMouseClicked

    private void lbVer2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVer2MouseClicked
        lbVer2.setVisible(false);
        lbNover2.setVisible(true);
        txtContra2.setEchoChar((char) 0);
    }//GEN-LAST:event_lbVer2MouseClicked

    private void lbNover2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNover2MouseClicked
        lbVer2.setVisible(true);
        lbNover2.setVisible(false);
        txtContra2.setEchoChar('*');
    }//GEN-LAST:event_lbNover2MouseClicked

    public void transparenciaBotin() {
        btnActualizar.setOpaque(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setBorderPainted(false);
    }

    /**
     * @param args the command line arguments
     */
    public void INIT() {
        NuevoContra vistaPUsuario = new NuevoContra();
        ActContra vistaNuevaC = new ActContra();
        usuarios modelo = new usuarios();
        LoginPTC vistaLG = new LoginPTC();
        ctrlActualizarContra control = new ctrlActualizarContra(modelo, vistaPUsuario, vistaNuevaC, vistaLG);

        vistaNuevaC.setVisible(true);
    }
    ctrlEncriptacion encript;

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
            java.util.logging.Logger.getLogger(ActContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbNo;
    private javax.swing.JLabel jbVer;
    private javax.swing.JLabel lbNover;
    private javax.swing.JLabel lbNover2;
    private javax.swing.JLabel lbVer;
    private javax.swing.JLabel lbVer2;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas3;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas7;
    public javax.swing.JPasswordField txtContra;
    public javax.swing.JPasswordField txtContra2;
    // End of variables declaration//GEN-END:variables
}
