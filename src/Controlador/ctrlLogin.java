
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlLogin implements ActionListener{

    private usuarios modeloUsuario;
    private LoginPTC vistaLogin;
    private Main main;
    
    public ctrlLogin(usuarios modeloUsuario, LoginPTC vistaLogin, Main main){
        this.modeloUsuario=modeloUsuario;
        this.vistaLogin=vistaLogin;
        this.main=main;
        this.vistaLogin.btnLogin.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vistaLogin.btnLogin){
            modeloUsuario.setUsr_nombre(vistaLogin.txtUsuario.getText());
            modeloUsuario.setUsr_contra(vistaLogin.txtContraseña.getText());
            modeloUsuario.ValidarUsuario(modeloUsuario);
            vistaLogin.dispose();
            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
