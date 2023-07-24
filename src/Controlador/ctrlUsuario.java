
package Controlador;

import Modelo.usuarios;
import Vista.LoginPTC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ctrlUsuario implements ActionListener{

    private usuarios modeloUsuario;
    private LoginPTC vistaLogin;
            
    public ctrlUsuario(usuarios modeloUsuario, LoginPTC vistaLogin){
        this.modeloUsuario=modeloUsuario;
        this.vistaLogin=vistaLogin;
        this.vistaLogin.btnLogin.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaLogin.btnLogin){
            modeloUsuario.setUsr_nombre(vistaLogin.txtUsuario.getText());
            modeloUsuario.setUsr_contra(vistaLogin.txtContraseña.getText());
            modeloUsuario.ValidarUsuario(modeloUsuario);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
}
