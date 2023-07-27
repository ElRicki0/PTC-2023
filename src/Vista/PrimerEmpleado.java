/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlPrimerEmpleado;
import Modelo.*;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class PrimerEmpleado extends javax.swing.JFrame {

    EmpleadosM modeloEmpelados = new EmpleadosM();
    
    public PrimerEmpleado() {
        initComponents();
//        TextPrompt texto1 = new TextPrompt("Ingrese su nombre...", txtNombre);
//        TextPrompt texto3 = new TextPrompt("Ingrese su correo...", txtCorreo);
//        TextPrompt texto4 = new TextPrompt("Ingrese su direccion...", txtDireccion);
//        TextPrompt texto2 = new TextPrompt("Ingrese su Telefono...", txtTelefono);
        
        this.setLocationRelativeTo(null);
        transparenciaBotin();
        modeloEmpelados.llenarCMB(jcbGenero);
    }

    public void INIT(){
        PrimerEmpleado vistaPrimer= new PrimerEmpleado();
        EmpleadosM modeloEmpleado= new EmpleadosM();
        PrimerUsuario vistaPMUsuario = new PrimerUsuario();
        ctrlPrimerEmpleado control = new ctrlPrimerEmpleado(modeloEmpleado, vistaPrimer, vistaPMUsuario);
        vistaPrimer.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel14 = new javax.swing.JLabel();
        panelCurvas2 = new Vista.PanelCurvas();
        txtTelefono = new javax.swing.JTextField();
        panelCurvas3 = new Vista.PanelCurvas();
        txtNombre = new javax.swing.JTextField();
        panelCurvas5 = new Vista.PanelCurvas();
        txtCorreo = new javax.swing.JTextField();
        panelCurvas4 = new Vista.PanelCurvas();
        txtFecha = new javax.swing.JTextField();
        panelCurvas6 = new Vista.PanelCurvas();
        txtDireccion = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        panelCurvas7 = new Vista.PanelCurvas();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        panelCurvas2.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas2.setRoundBottomLeft(25);
        panelCurvas2.setRoundBottomRight(25);
        panelCurvas2.setRoundTopLeft(25);
        panelCurvas2.setRoundTopRight(25);
        panelCurvas2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefono.setBorder(null);
        panelCurvas2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 290, 60));

        panelCurvas3.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);
        panelCurvas3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setBorder(null);
        panelCurvas3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 290, 60));

        panelCurvas5.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);
        panelCurvas5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setBorder(null);
        panelCurvas5.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 290, 60));

        panelCurvas4.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);
        panelCurvas4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(51, 51, 51));
        txtFecha.setBorder(null);
        panelCurvas4.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 290, 60));

        panelCurvas6.setBackground(new java.awt.Color(255, 255, 255));
        panelCurvas6.setRoundBottomLeft(25);
        panelCurvas6.setRoundBottomRight(25);
        panelCurvas6.setRoundTopLeft(25);
        panelCurvas6.setRoundTopRight(25);
        panelCurvas6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(51, 51, 51));
        txtDireccion.setBorder(null);
        panelCurvas6.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 40));

        jPanel1.add(panelCurvas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 290, 60));

        jcbGenero.setBackground(new java.awt.Color(255, 255, 255));
        jcbGenero.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jPanel1.add(jcbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 290, 60));

        panelCurvas7.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas7.setRoundBottomLeft(50);
        panelCurvas7.setRoundBottomRight(50);
        panelCurvas7.setRoundTopLeft(50);
        panelCurvas7.setRoundTopRight(50);

        btnAgregar.setFont(new java.awt.Font("Leelawadee UI", 1, 40)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
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

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ingrese su fecha de nacimiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 350, 30));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("<html> Saludos usuario, para poder iniciar el programa debemos iniciar creando un empleado con sus datos, este contara con control total del sistema</html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 520, 110));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Ingrese su genero");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 230, 30));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Ingrese su nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 220, 30));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ingrese su correo ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 220, 30));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ingrese su telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 220, 30));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ingrese su direccion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 230, 30));

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

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        String Nombre = txtNombre.getText();
        String Correo = txtCorreo.getText();
        String Direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
                
        
        if (Nombre.isEmpty()&&Correo.isEmpty()&&Direccion.isEmpty()&&telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos");
            
        } else {
            PrimerUsuario PrimerUS = new PrimerUsuario();
            PrimerUS.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    public void transparenciaBotin(){
        btnAgregar.setOpaque(false);        
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setBorderPainted(false);
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
            java.util.logging.Logger.getLogger(PrimerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimerEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox<String> jcbGenero;
    private Vista.PanelCurvas panelCurvas1;
    private Vista.PanelCurvas panelCurvas2;
    private Vista.PanelCurvas panelCurvas3;
    private Vista.PanelCurvas panelCurvas4;
    private Vista.PanelCurvas panelCurvas5;
    private Vista.PanelCurvas panelCurvas6;
    private Vista.PanelCurvas panelCurvas7;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
