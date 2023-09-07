package Controlador;

import Modelo.usuarios;
import Vista.VEmpleados_Usuarios;
import Controlador.ctrlEncriptacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrllUsuario implements ActionListener {

    private VEmpleados_Usuarios vistaUsuario;
    private usuarios modeloUsuario;
    private ctrlEncriptacion encript;

    public ctrllUsuario(VEmpleados_Usuarios vistaUsuario, usuarios modeloUsuario, ctrlEncriptacion encript) {
        this.modeloUsuario = modeloUsuario;
        this.vistaUsuario = vistaUsuario;
        this.encript=encript;
        this.vistaUsuario.btnAgregar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnModificarMP.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaUsuario.btnAgregar) {
            try {
                String texto1 = vistaUsuario.txtNombre_USR.getText();
                if (texto1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                } else {
                    if (texto1.length()>=5) {
                        String contra = "pass123";
                        modeloUsuario.setUsr_nombre(vistaUsuario.txtNombre_USR.getText());
                        modeloUsuario.setUsr_contra(encript.convertirSHA256(contra));
                        modeloUsuario.setIdEmpleado(vistaUsuario.jcbEmpleado.getSelectedItem().toString());
                        modeloUsuario.setIdnivelUser(vistaUsuario.jcbUsuario.getSelectedItem().toString());
                        modeloUsuario.AUsuarios(modeloUsuario, vistaUsuario.jcbEmpleado, vistaUsuario.jcbUsuario);
                        modeloUsuario.mostrarUsuarios(vistaUsuario);
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre del usuario tiene que ser superior a 5 digitos");
                        
                    }
                }
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "error ctrl usuario " + ae.toString());
                modeloUsuario.mostrarUsuarios(vistaUsuario);
            }

        }if (e.getSource() == vistaUsuario.btnEliminar) {
            modeloUsuario.EliminarUsuario(vistaUsuario);
            modeloUsuario.mostrarUsuarios(vistaUsuario);
        }if (e.getSource()==vistaUsuario.btnModificarMP) {
            String texto1 = vistaUsuario.txtNombre_USR.getText();
                if (texto1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                } else {
                    if (texto1.length()>=5) {
                        modeloUsuario.setUsr_nombre(vistaUsuario.txtNombre_USR.getText());
                        modeloUsuario.setIdEmpleado(vistaUsuario.jcbEmpleado.getSelectedItem().toString());
                        modeloUsuario.setIdnivelUser(vistaUsuario.jcbUsuario.getSelectedItem().toString());
                        modeloUsuario.ActualizarUsuario(modeloUsuario, vistaUsuario.jcbEmpleado, vistaUsuario.jcbUsuario, vistaUsuario);
                        modeloUsuario.mostrarUsuarios(vistaUsuario);
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre del usuario tiene que ser superior a 5 digitos");
                        
                    }
                }
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
