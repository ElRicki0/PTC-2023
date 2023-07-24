/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.CConexion;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane;
import Modelo.usuarios;
import Controlador.ctrlUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPTC extends javax.swing.JFrame {
    
    CConexion cc = new CConexion();
//    Connection con=(Connection) cc.getConexion();
    
    public LoginPTC() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Vista/Imagenes/lupa.png")).getImage());
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(txtImagen, "src/Vista/Imagenes/trabajador.png");
        TextPrompt txtUsuario = new TextPrompt("Usuario", this.txtUsuario);
        TextPrompt txtContraseña = new TextPrompt("Contraseñas", this.txtContraseña);
        transpareciaBoton();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas2 = new Vista.PanelCurvas();
        txtUsuario = new javax.swing.JTextField();
        panelCurvas3 = new Vista.PanelCurvas();
        txtContraseña = new javax.swing.JTextField();
        bntSesion = new Vista.PanelCurvas();
        btnLogin = new javax.swing.JButton();
        txtImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(64, 81, 115));

        panelCurvas1.setBackground(new java.awt.Color(51, 153, 255));
        panelCurvas1.setRoundBottomLeft(50);
        panelCurvas1.setRoundBottomRight(50);
        panelCurvas1.setRoundTopLeft(50);
        panelCurvas1.setRoundTopRight(50);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Inicio Sesión");
        panelCurvas1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 14, -1, -1));

        panelCurvas2.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas2.setRoundBottomLeft(25);
        panelCurvas2.setRoundBottomRight(25);
        panelCurvas2.setRoundTopLeft(25);
        panelCurvas2.setRoundTopRight(25);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas2Layout = new javax.swing.GroupLayout(panelCurvas2);
        panelCurvas2.setLayout(panelCurvas2Layout);
        panelCurvas2Layout.setHorizontalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelCurvas2Layout.setVerticalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCurvas1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 58, -1, -1));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setForeground(new java.awt.Color(51, 51, 51));
        txtContraseña.setBorder(null);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas3Layout = new javax.swing.GroupLayout(panelCurvas3);
        panelCurvas3.setLayout(panelCurvas3Layout);
        panelCurvas3Layout.setHorizontalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelCurvas3Layout.setVerticalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCurvas1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 172, -1, -1));

        bntSesion.setBackground(new java.awt.Color(255, 255, 255));
        bntSesion.setRoundBottomLeft(25);
        bntSesion.setRoundBottomRight(25);
        bntSesion.setRoundTopLeft(25);
        bntSesion.setRoundTopRight(25);
        bntSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntSesionMouseClicked(evt);
            }
        });
        bntSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        btnLogin.setText("jButton1");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        bntSesion.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 80));

        panelCurvas1.add(bntSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 274, 140, 80));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCurvas1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelCurvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 310, 410));
        jPanel1.add(txtImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 290, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void bntSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntSesionMouseClicked
       
//        Modelo.usuarios();
    }//GEN-LAST:event_bntSesionMouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginMouseClicked

    public void transpareciaBoton(){
        btnLogin.setOpaque(false);        
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                usuarios modeloUsuario = new usuarios();
                LoginPTC vistaLogin = new LoginPTC();
                ctrlUsuario controlador = new ctrlUsuario(modeloUsuario, vistaLogin);
                
                vistaLogin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.PanelCurvas bntSesion;
    public javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas2;
    private Vista.PanelCurvas panelCurvas3;
    public javax.swing.JTextField txtContraseña;
    private javax.swing.JLabel txtImagen;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
