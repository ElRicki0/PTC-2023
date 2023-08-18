
package Vista;

import Controlador.ctrlEncriptacion;
import Controlador.ctrlPrimerUsuario;
import Modelo.usuarios;
import java.util.Properties;
import java.util.Random;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class ContraGMAIL extends javax.swing.JFrame {
       int aleatorio=0;
    
    public ContraGMAIL() {
        initComponents();
        this.setLocationRelativeTo(null);        
        TextPrompt textPrompta =new TextPrompt("Ingrese su Correo", this.txtCorreo);        
        TextPrompt textPrompta1 =new TextPrompt("Correo", this.txtCodigo);        
        transparenciaBotin();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel14 = new javax.swing.JLabel();
        panelCurvas2 = new Vista.PanelCurvas();
        txtCodigo = new javax.swing.JTextField();
        panelCurvas4 = new Vista.PanelCurvas();
        btnEnviar = new javax.swing.JButton();
        panelCurvas7 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas3 = new Vista.PanelCurvas();
        txtCorreo = new javax.swing.JTextField();
        panelCurvas5 = new Vista.PanelCurvas();
        btnCodigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(590, 470));
        setMinimumSize(new java.awt.Dimension(590, 470));
        setSize(new java.awt.Dimension(590, 470));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(25);
        panelCurvas1.setRoundBottomRight(25);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Recuperacion por Gmail");
        panelCurvas1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 60));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 100));

        panelCurvas2.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas2.setRoundBottomLeft(25);
        panelCurvas2.setRoundBottomRight(25);
        panelCurvas2.setRoundTopLeft(25);
        panelCurvas2.setRoundTopRight(25);

        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(51, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(null);

        javax.swing.GroupLayout panelCurvas2Layout = new javax.swing.GroupLayout(panelCurvas2);
        panelCurvas2.setLayout(panelCurvas2Layout);
        panelCurvas2Layout.setHorizontalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas2Layout.setVerticalGroup(
            panelCurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 160, 50));

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
            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        panelCurvas4Layout.setVerticalGroup(
            panelCurvas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 50));

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

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 100));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setBorder(null);

        javax.swing.GroupLayout panelCurvas3Layout = new javax.swing.GroupLayout(panelCurvas3);
        panelCurvas3.setLayout(panelCurvas3Layout);
        panelCurvas3Layout.setHorizontalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas3Layout.setVerticalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 400, 50));

        panelCurvas5.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);

        btnCodigo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCodigo.setText("verificar");
        btnCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCodigoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas5Layout = new javax.swing.GroupLayout(panelCurvas5);
        panelCurvas5.setLayout(panelCurvas5Layout);
        panelCurvas5Layout.setHorizontalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCurvas5Layout.setVerticalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCurvas7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCurvas7MouseClicked
        RecContrasenia vista = new RecContrasenia();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_panelCurvas7MouseClicked

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        mandarCorreo();
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void btnCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCodigoMouseClicked
        VerificarCodigo();
    }//GEN-LAST:event_btnCodigoMouseClicked

    public void transparenciaBotin(){
        btnEnviar.setOpaque(false);        
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setBorderPainted(false);
        btnCodigo.setOpaque(false);        
        btnCodigo.setContentAreaFilled(false);
        btnCodigo.setBorderPainted(false);
    }
    
    /**
     * @param args the command line arguments
     */
    
    public void INIT(){
            ContraGMAIL vistaPUsuario = new ContraGMAIL();
            vistaPUsuario.setVisible(true);
        }   
    
    public void mandarCorreo(){
            aleatorio = (int)(Math.random()*100000000);
        try{
            //Preparar las cosas
            String correoEmisor = "GoldenManagerStudio@gmail.com";
            String contraseñaEmisor = "urjqvpuobtjciwwk";     
            String CorreoReceptor = txtCorreo.getText();
            String asunto = "Recuperación de contraseña";
            String mensaje = "Este es tu código de recuperación "+aleatorio;
            
            //Configurar SMTP
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starls.enable", "true");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

          
            //Configurar el envio
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoEmisor));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(CorreoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);

            //Envío del mensaje
            Transport t = session.getTransport("smtp");
            t.connect(correoEmisor, contraseñaEmisor);    
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
            System.out.println(aleatorio);

        }catch(Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al enviar correo");
            System.out.println(aleatorio);
        }
    }
    
    public void VerificarCodigo() {
        try {
            int texto2= Integer.parseInt(txtCodigo.getText());
        if (aleatorio==texto2) {
            NuevoContra vista = new NuevoContra();
            vista.INIT();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error"    );
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo valido"    );
        }
        
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
            java.util.logging.Logger.getLogger(ContraGMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContraGMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContraGMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContraGMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton btnCodigo;
    public javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas2;
    private Vista.PanelCurvas panelCurvas3;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas5;
    private Vista.PanelCurvas panelCurvas7;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    
}
