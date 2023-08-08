
package Controlador;

import Modelo.usuarios;
import Vista.VUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrllUsuario implements ActionListener{

    private VUsuarios vistaUsuario;
    private usuarios modeloUsuario;
    
    public ctrllUsuario(VUsuarios vistaUsuario, usuarios modeloUsuario){
        this.modeloUsuario=modeloUsuario;
        this.vistaUsuario=vistaUsuario;
        this.vistaUsuario.btnAgregar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaUsuario.btnAgregar){
            try {
                modeloUsuario.setUsr_nombre(vistaUsuario.txtNombre_USR.getText());
                modeloUsuario.setIdEmpleado(vistaUsuario.jcbEmpleado.getSelectedItem().toString());
                modeloUsuario.setIdnivelUser(vistaUsuario.jcbUsuario.getSelectedItem().toString());
                modeloUsuario.AUsuarios(modeloUsuario, vistaUsuario.jcbEmpleado, vistaUsuario.jcbUsuario);
                modeloUsuario.mostrarUsuarios(vistaUsuario);
                JOptionPane.showMessageDialog(null, "Usuario agregado con exito");        
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "error ctrl usuario "+ ae.toString());        
            }
            
        }if (e.getSource()==vistaUsuario.btnEliminar) {
            modeloUsuario.EliminarUsuario(vistaUsuario);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
