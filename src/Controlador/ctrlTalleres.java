package Controlador;

import Modelo.talleres;
import Vista.VTaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTalleres implements ActionListener{

    private VTaller vista;
    private talleres modelo;
    
    public ctrlTalleres(VTaller vista, talleres modelo) {
        this.modelo=modelo;
        this.vista=vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificarMP.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btnAgregar) {
            String texto1 =vista.txtNombre.getText();
            String texto2 =vista.txtTelefono.getText();
            String texto3 =vista.txtCorreo.getText();
            String texto4 =vista.txtDuenio.getText();
            
            if (texto1.isEmpty()||texto2.isEmpty()||texto3.isEmpty()||texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                   JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                }else{
                    if (!texto1.matches("[a-z A-Z]+")&&texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");                                 
                    } else {
                        if (texto2.length()==8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");                        
                            } else {
                                modelo.setTall_Nombre(vista.txtNombre.getText());
                                modelo.setTall_Telefono(vista.txtTelefono.getText());
                                modelo.setTall_Correo(vista.txtCorreo.getText());
                                modelo.setTall_Dueño(vista.txtDuenio.getText());
                                modelo.Agregar(modelo);
                                modelo.MostratTabla(vista);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");                                 
                        }
                    }
                }
            }
            
        }if (e.getSource()==vista.btnEliminar) {
            modelo.Eliminar(vista);
            modelo.MostratTabla(vista);
        }if (e.getSource()==vista.btnModificarMP) {
            String texto1 =vista.txtNombre.getText();
            String texto2 =vista.txtTelefono.getText();
            String texto3 =vista.txtCorreo.getText();
            String texto4 =vista.txtDuenio.getText();
            
            if (texto1.isEmpty()||texto2.isEmpty()||texto3.isEmpty()||texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                   JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                }else{
                    if (!texto1.matches("[a-z A-Z]+")||texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");                                 
                    } else {
                        if (texto2.length()==8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");                        
                            } else {
                                modelo.Editar(vista);
                                modelo.MostratTabla(vista);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");                                 
                        }
                    }
                }
            }
            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
