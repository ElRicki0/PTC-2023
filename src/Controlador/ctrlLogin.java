package Controlador;

import Modelo.*;
import Vista.*;
import Controlador.ctrlEncriptacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements ActionListener {

    private usuarios modeloUsuario;
    private LoginPTC vistaLogin;
    private Main main;
    private ctrlEncriptacion encript;

    public ctrlLogin(usuarios modeloUsuario, LoginPTC vistaLogin, Main main, ctrlEncriptacion encript) {
        this.modeloUsuario = modeloUsuario;
        this.vistaLogin = vistaLogin;
        this.main = main;
        this.encript = encript;
        this.vistaLogin.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.btnLogin) {
            if (encript != null && modeloUsuario != null) {
                String usuarioIngresado = vistaLogin.txtUsuario.getText();
                String contraseñaIngresada = vistaLogin.txtContraseña.getText();

                modeloUsuario.setUsr_nombre(usuarioIngresado);

                String contraseñaIngresadaEncriptada = encript.convertirSHA256(contraseñaIngresada);
                String contraseñaAlmacenada = modeloUsuario.obtenerContraseñaDesdeBD();

                if (contraseñaAlmacenada != null && contraseñaAlmacenada.equals(contraseñaIngresadaEncriptada)) {

                    Main main = new Main();
                    main.setVisible(true);
                    LoginPTC loginvista= new LoginPTC();
                    loginvista.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas");
                }
            } else {
                // Manejo de caso en que encript o modeloUsuario es null
                JOptionPane.showMessageDialog(null, "Encriptador o modeloUsuario no inicializado.");
            }
        }
    }

}
