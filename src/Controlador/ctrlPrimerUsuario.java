
package Controlador;

import Modelo.usuarios;
import Controlador.ctrlEncriptacion;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ctrlPrimerUsuario implements ActionListener{

    
    private PrimerUsuario vistaPUsuario; 
    private usuarios modeloUsuario;
    private LoginPTC login;
    private ctrlEncriptacion encript;
    
    public ctrlPrimerUsuario (PrimerUsuario vistaPUsuario, usuarios modeloUsuario, LoginPTC login, ctrlEncriptacion encript){
        this.modeloUsuario=modeloUsuario;
        this.vistaPUsuario=vistaPUsuario;
        this.login=login;
        this.encript=encript;
        this.vistaPUsuario.btnAgregar.addActionListener(this);
    }           
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaPUsuario.btnAgregar){
            System.out.println("se da clic en ctrl usuario");
            modeloUsuario.setUsr_nombre(vistaPUsuario.txtUsuario.getText());
//            modeloUsuario.setUsr_contra(vistaPUsuario.txtContrasenia.getText());
            modeloUsuario.setUsr_contra(encript.convertirSHA256(vistaPUsuario.txtContrasenia.getText()));
            modeloUsuario.PMUsuario(modeloUsuario);
            vistaPUsuario.dispose();
            login.INIT();
            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
}
