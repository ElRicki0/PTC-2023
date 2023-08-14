package Controlador;

import Modelo.*;
import Vista.*;
import Controlador.ctrlEncriptacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            modeloUsuario.setUsr_nombre(vistaLogin.txtUsuario.getText());
            modeloUsuario.setUsr_contra(encript.ecnode(vistaLogin.txtContraseña.getText()));
//            modeloUsuario.ValidarUsuario(modeloUsuario);            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
