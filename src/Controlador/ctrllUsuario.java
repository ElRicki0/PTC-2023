
package Controlador;

import Modelo.usuarios;
import Vista.VUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrllUsuario implements ActionListener{

    private VUsuarios vistaUsuario;
    private usuarios modeloUsuario;
    
    public ctrllUsuario(VUsuarios vistaUsuario, usuarios modeloUsuario){
        this.modeloUsuario=modeloUsuario;
        this.vistaUsuario=vistaUsuario;
        this.vistaUsuario.btnAgregar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaUsuario.btnAgregar){
            modeloUsuario.setUsr_nombre(vistaUsuario.txtNombre_USR.getText());
            modeloUsuario.setUsr_contra(vistaUsuario.txtContra_USR.getText());
            modeloUsuario.setIdEmpleado(vistaUsuario.jcbEmpleado.getSelectedItem().toString());
            modeloUsuario.setIdnivelUser(vistaUsuario.jcbUsuario.getSelectedItem().toString());
            modeloUsuario.AUsuarios(modeloUsuario);
            modeloUsuario.mostrarUsuarios(vistaUsuario);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
