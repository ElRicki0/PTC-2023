/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlEmpleado;
import Modelo.EmpleadosM;
import Modelo.usuarios;

/**
 *
 * @author rnmel
 */
public class PrimerUsuario extends javax.swing.JFrame {

    EmpleadosM modeloEmpelados = new EmpleadosM();
    
    public PrimerUsuario() {
        initComponents();
        TextPrompt texto1 = new TextPrompt("Ingrese su nombre...", txtNombre);
        TextPrompt texto3 = new TextPrompt("Ingrese su correo...", txtCorreo);
        TextPrompt texto4 = new TextPrompt("Ingrese su direccion...", txtDireccion);
        TextPrompt texto2 = new TextPrompt("Ingrese su Telefono...", txtTelefono);
        this.setLocationRelativeTo(null);
        transpareciaBoton();
        modeloEmpelados.llenarCMB(jcbGenero);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCurvas1 = new Vista.PanelCurvas();
        jLabel1 = new javax.swing.JLabel();
        jLtexto1 = new javax.swing.JLabel();
        panelCurvas7 = new Vista.PanelCurvas();
        txtTelefono = new javax.swing.JTextField();
        panelCurvas6 = new Vista.PanelCurvas();
        txtFecha = new com.toedter.calendar.JDateChooser();
        panelCurvas4 = new Vista.PanelCurvas();
        txtCorreo = new javax.swing.JTextField();
        panelCurvas3 = new Vista.PanelCurvas();
        txtDireccion = new javax.swing.JTextField();
        panelCurvas2 = new Vista.PanelCurvas();
        txtNombre = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        panelCurvas5 = new Vista.PanelCurvas();
        btnAgregar = new javax.swing.JButton();
        jLtexto2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(730, 720));

        jPanel1.setBackground(new java.awt.Color(250, 247, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurvas1.setBackground(new java.awt.Color(64, 81, 115));
        panelCurvas1.setRoundBottomLeft(40);
        panelCurvas1.setRoundBottomRight(40);
        panelCurvas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 247, 239));
        jLabel1.setText("Bienvenido Usuario");
        panelCurvas1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 330, 50));

        jPanel1.add(panelCurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        jLtexto1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLtexto1.setForeground(new java.awt.Color(45, 40, 37));
        jLtexto1.setText("<html>Para accseder al sistema se tiene que crear un nuevo usuario el cual tendra un control total del mismo sistema. </html>");
        jLtexto1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLtexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 600, 120));

        panelCurvas7.setBackground(new java.awt.Color(246, 234, 204));
        panelCurvas7.setRoundBottomLeft(25);
        panelCurvas7.setRoundBottomRight(25);
        panelCurvas7.setRoundTopLeft(25);
        panelCurvas7.setRoundTopRight(25);
        panelCurvas7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTelefono.setBackground(new java.awt.Color(246, 234, 204));
        txtTelefono.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefono.setBorder(null);
        panelCurvas7.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 308, 48));

        jPanel1.add(panelCurvas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 320, 60));

        panelCurvas6.setBackground(new java.awt.Color(246, 234, 204));
        panelCurvas6.setRoundBottomLeft(25);
        panelCurvas6.setRoundBottomRight(25);
        panelCurvas6.setRoundTopLeft(25);
        panelCurvas6.setRoundTopRight(25);
        panelCurvas6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha.setDateFormatString("yyyy/MM/d");
        panelCurvas6.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 40));

        jPanel1.add(panelCurvas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 320, 60));

        panelCurvas4.setBackground(new java.awt.Color(246, 234, 204));
        panelCurvas4.setRoundBottomLeft(25);
        panelCurvas4.setRoundBottomRight(25);
        panelCurvas4.setRoundTopLeft(25);
        panelCurvas4.setRoundTopRight(25);
        panelCurvas4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setBackground(new java.awt.Color(246, 234, 204));
        txtCorreo.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setBorder(null);
        panelCurvas4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 308, 48));

        jPanel1.add(panelCurvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 320, 60));

        panelCurvas3.setBackground(new java.awt.Color(246, 234, 204));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);
        panelCurvas3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDireccion.setBackground(new java.awt.Color(246, 234, 204));
        txtDireccion.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(51, 51, 51));
        txtDireccion.setBorder(null);
        panelCurvas3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 308, 48));

        jPanel1.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 320, 60));

        panelCurvas2.setBackground(new java.awt.Color(246, 234, 204));
        panelCurvas2.setRoundBottomLeft(25);
        panelCurvas2.setRoundBottomRight(25);
        panelCurvas2.setRoundTopLeft(25);
        panelCurvas2.setRoundTopRight(25);
        panelCurvas2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(246, 234, 204));
        txtNombre.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setBorder(null);
        panelCurvas2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 308, 48));

        jPanel1.add(panelCurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 320, 60));

        jcbGenero.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jPanel1.add(jcbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 320, 60));

        panelCurvas5.setBackground(new java.awt.Color(172, 147, 110));
        panelCurvas5.setRoundBottomLeft(25);
        panelCurvas5.setRoundBottomRight(25);
        panelCurvas5.setRoundTopLeft(25);
        panelCurvas5.setRoundTopRight(25);

        btnAgregar.setFont(new java.awt.Font("Leelawadee UI", 0, 36)); // NOI18N
        btnAgregar.setText("Agregar");

        javax.swing.GroupLayout panelCurvas5Layout = new javax.swing.GroupLayout(panelCurvas5);
        panelCurvas5.setLayout(panelCurvas5Layout);
        panelCurvas5Layout.setHorizontalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurvas5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCurvas5Layout.setVerticalGroup(
            panelCurvas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurvas5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCurvas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 220, 100));

        jLtexto2.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLtexto2.setForeground(new java.awt.Color(45, 40, 37));
        jLtexto2.setText("<html>Cree el primer empleado.</html>");
        jLtexto2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLtexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void transpareciaBoton(){
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
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrimerUsuario().setVisible(true);
                PrimerUsuario vistaPrimer= new PrimerUsuario();
                EmpleadosM modeloEmpleado= new EmpleadosM();
                ctrlEmpleado control = new ctrlEmpleado(vistaPrimer, modeloEmpleado);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLtexto1;
    private javax.swing.JLabel jLtexto2;
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
    public com.toedter.calendar.JDateChooser txtFecha;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
