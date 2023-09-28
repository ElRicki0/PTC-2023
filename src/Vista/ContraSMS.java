/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class ContraSMS extends javax.swing.JFrame {

    /**
     * Creates new form ContraSMS
     */
    public ContraSMS() {
        initComponents();
        TextPrompt textPrompta = new TextPrompt("Ingrese su Numero de teléfono", this.txtNumero);
        TextPrompt textPrompta1 = new TextPrompt("Codigo", this.txtCodigo);
        transparenciaBoton();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel14 = new javax.swing.JLabel();
        panelCurvas3 = new Vista.PanelCurvas();
        txtNumero = new javax.swing.JTextField();
        panelCurvas5 = new Vista.PanelCurvas();
        btnCodigoVerificar = new javax.swing.JButton();
        panelCurvas7 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        panelCurvas4 = new Vista.PanelCurvas();
        btnEnviar = new javax.swing.JButton();
        panelCurvas2 = new Vista.PanelCurvas();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel14.setText("Recuperación por SMS");
        panelCurvas1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 60));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 100));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);

        txtNumero.setBackground(new java.awt.Color(255, 255, 255));
        txtNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(51, 51, 51));
        txtNumero.setBorder(null);

        javax.swing.GroupLayout panelCurvas3Layout = new javax.swing.GroupLayout(panelCurvas3);
        panelCurvas3.setLayout(panelCurvas3Layout);
        panelCurvas3Layout.setHorizontalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurvas3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelCurvas3Layout.setVerticalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 300, 50));

        panelCurvas5.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);

        btnCodigoVerificar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCodigoVerificar.setText("verificar");
        btnCodigoVerificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCodigoVerificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas5Layout = new javax.swing.GroupLayout(panelCurvas5);
        panelCurvas5.setLayout(panelCurvas5Layout);
        panelCurvas5Layout.setHorizontalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCodigoVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCurvas5Layout.setVerticalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCodigoVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, 50));

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

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, 50));

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

        jPanel1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 160, 50));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCodigoVerificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCodigoVerificarMouseClicked
        VerificarCodigo();
    }//GEN-LAST:event_btnCodigoVerificarMouseClicked

    private void panelCurvas7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCurvas7MouseClicked
        RecContrasenia vista = new RecContrasenia();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_panelCurvas7MouseClicked

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        mandarSMS();
    }//GEN-LAST:event_btnEnviarMouseClicked

    int aleatorio = 0;
    public static final String ACCOUNT_SID = "AC4afb361fef3f52feb1a840bac7d177f7";
    public static final String AUTH_TOKEN = "fa23172a77d402f93b7abbaf3cf0880c";
    private String Numero = "+19289107991";

    public void mandarSMS() {

        aleatorio = (int) (Math.random() * 1000000);
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("+503" + txtNumero.getText().trim()),
                    new com.twilio.type.PhoneNumber(Numero),
                    "Este es tu código de recuperación:" + aleatorio)
                    .create();
//            System.out.println(message.getSid());
            JOptionPane.showMessageDialog(null, "Enviado" + message.getSid());
        } catch (TwilioException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    public void VerificarCodigo() {
        try {
            int verificacion = Integer.parseInt(txtCodigo.getText());
            if (aleatorio == verificacion) {
                NuevoContra vista = new NuevoContra();
                vista.INIT();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Codigo Invalido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo valido");
        }

    }

    public void transparenciaBoton() {
        btnEnviar.setOpaque(false);
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setBorderPainted(false);
        btnCodigoVerificar.setOpaque(false);
        btnCodigoVerificar.setContentAreaFilled(false);
        btnCodigoVerificar.setBorderPainted(false);
    }

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContraSMS().setVisible(true);
            }
        });
    }

    
//    public class EnviarSMS {
//        // Find your Account Sid and Token at twilio.com/console
//
//        public static final String ACCOUNT_SID = "AC9a823f30cf1502be6bf3cbef4b77e9a7";
//        public static final String AUTH_TOKEN = "6a4bf4ea04458fe75f8df6fdb04b069d";
//
//        public void main(String[] args) {
//            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//            Message message = Message.creator(
//                    new com.twilio.type.PhoneNumber("+50372212777"),
//                    new com.twilio.type.PhoneNumber("+14259038961"),
//                    "Este es tu código de recuperación")
//                    .create();
//
//            System.out.println(message.getSid());
//        }
//    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCodigoVerificar;
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
    public javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
