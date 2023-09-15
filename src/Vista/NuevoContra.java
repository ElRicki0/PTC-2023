package Vista;

import Controlador.ctrlActualizarContra;
import Modelo.usuarios;

public class NuevoContra extends javax.swing.JFrame {

    public NuevoContra() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jbNo.setVisible(false);
        this.jbNoRepetir.setVisible(false);
        TextPrompt textPrompta = new TextPrompt("Ingrese su usuario", this.txtUsuario);
        TextPrompt textPrompta2 = new TextPrompt("ingrese nueva contraseña", this.txtContrasenia);
        TextPrompt textPrompta1 = new TextPrompt("Repita la contraseña", this.txtRepetir);
        rsscalelabel.RSScaleLabel.setScaleLabel(jbver, "src/Vista/Iconos/ver.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jbNo, "src/Vista/Iconos/noVer.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jbVerRepetir, "src/Vista/Iconos/ver.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jbNoRepetir, "src/Vista/Iconos/noVer.png");
        transparenciaBotin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel14 = new javax.swing.JLabel();
        panelCurvas2 = new Vista.PanelCurvas();
        txtRepetir = new javax.swing.JPasswordField();
        panelCurvas4 = new Vista.PanelCurvas();
        btnEnviar = new javax.swing.JButton();
        panelCurvas7 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas3 = new Vista.PanelCurvas();
        txtContrasenia = new javax.swing.JPasswordField();
        panelCurvas5 = new Vista.PanelCurvas();
        txtUsuario = new javax.swing.JTextField();
        jbver = new javax.swing.JLabel();
        jbNo = new javax.swing.JLabel();
        jbNoRepetir = new javax.swing.JLabel();
        jbVerRepetir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(590, 470));
        setResizable(false);
        setSize(new java.awt.Dimension(590, 470));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(25);
        panelCurvas1.setRoundBottomRight(25);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Recuperación de contraseña");
        panelCurvas1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 60));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 100));

        panelCurvas2.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas2.setRoundBottomLeft(25);
        panelCurvas2.setRoundBottomRight(25);
        panelCurvas2.setRoundTopLeft(25);
        panelCurvas2.setRoundTopRight(25);

        txtRepetir.setBackground(new java.awt.Color(255, 255, 255));
        txtRepetir.setBorder(null);

        javax.swing.GroupLayout panelCurvas2Layout = new javax.swing.GroupLayout(panelCurvas2);
        panelCurvas2.setLayout(panelCurvas2Layout);
        panelCurvas2Layout.setHorizontalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelCurvas2Layout.setVerticalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 400, 50));

        panelCurvas4.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);

        btnEnviar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas4Layout = new javax.swing.GroupLayout(panelCurvas4);
        panelCurvas4.setLayout(panelCurvas4Layout);
        panelCurvas4Layout.setHorizontalGroup(
            panelCurvas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        panelCurvas4Layout.setVerticalGroup(
            panelCurvas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, 50));

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

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 100));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setBorder(null);

        javax.swing.GroupLayout panelCurvas3Layout = new javax.swing.GroupLayout(panelCurvas3);
        panelCurvas3.setLayout(panelCurvas3Layout);
        panelCurvas3Layout.setHorizontalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelCurvas3Layout.setVerticalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 400, 50));

        panelCurvas5.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setBorder(null);

        javax.swing.GroupLayout panelCurvas5Layout = new javax.swing.GroupLayout(panelCurvas5);
        panelCurvas5.setLayout(panelCurvas5Layout);
        panelCurvas5Layout.setHorizontalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas5Layout.setVerticalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 400, 50));

        jbver.setToolTipText("");
        jbver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbverMouseClicked(evt);
            }
        });
        jPanel1.add(jbver, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 50, 50));

        jbNo.setToolTipText("");
        jbNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNoMouseClicked(evt);
            }
        });
        jPanel1.add(jbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 50, 50));

        jbNoRepetir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNoRepetirMouseClicked(evt);
            }
        });
        jPanel1.add(jbNoRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 50, 40));

        jbVerRepetir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVerRepetirMouseClicked(evt);
            }
        });
        jPanel1.add(jbVerRepetir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCurvas7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCurvas7MouseClicked
        RecContrasenia vista = new RecContrasenia();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_panelCurvas7MouseClicked

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked

    }//GEN-LAST:event_btnEnviarMouseClicked

    private void jbverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbverMouseClicked
        jbver.setVisible(false);
        jbNo.setVisible(true);
        txtContrasenia.setEchoChar((char) 0);
    }//GEN-LAST:event_jbverMouseClicked

    private void jbNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNoMouseClicked
        jbver.setVisible(true);
        jbNo.setVisible(false);
        txtContrasenia.setEchoChar('*');
    }//GEN-LAST:event_jbNoMouseClicked

    private void jbVerRepetirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVerRepetirMouseClicked
        jbVerRepetir.setVisible(false);
        jbNoRepetir.setVisible(true);
        txtRepetir.setEchoChar((char) 0);
    }//GEN-LAST:event_jbVerRepetirMouseClicked

    private void jbNoRepetirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNoRepetirMouseClicked
        jbVerRepetir.setVisible(true);
        jbNoRepetir.setVisible(false);
        txtRepetir.setEchoChar('*');
    }//GEN-LAST:event_jbNoRepetirMouseClicked

    public void transparenciaBotin() {
        btnEnviar.setOpaque(false);
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setBorderPainted(false);
    }

    /**
     * @param args the command line arguments
     */
    public void INIT() {
        NuevoContra vistaPUsuario = new NuevoContra();
        usuarios modelo = new usuarios();
        ctrlActualizarContra control = new ctrlActualizarContra(modelo, vistaPUsuario);
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
            java.util.logging.Logger.getLogger(NuevoContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbNo;
    private javax.swing.JLabel jbNoRepetir;
    private javax.swing.JLabel jbVerRepetir;
    private javax.swing.JLabel jbver;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas2;
    public Vista.PanelCurvas panelCurvas3;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas5;
    private Vista.PanelCurvas panelCurvas7;
    public javax.swing.JPasswordField txtContrasenia;
    public javax.swing.JPasswordField txtRepetir;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
