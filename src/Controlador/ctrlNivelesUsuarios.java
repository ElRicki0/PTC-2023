
package Controlador;

import Modelo.NivelesUsuarios;
import Vista.VNEmpleados;
import Vista.VNUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlNivelesUsuarios implements ActionListener{

    private VNUsuarios vistaNUsuarios;
    private NivelesUsuarios modeloNUsuarios;
    
    public ctrlNivelesUsuarios(VNUsuarios vistaNUsuarios, NivelesUsuarios modeloNUsuarios){
        this.vistaNUsuarios=vistaNUsuarios;
        this.modeloNUsuarios=modeloNUsuarios;
        this.vistaNUsuarios.btnAgregar.addActionListener(this);
        this.vistaNUsuarios.btnEliminar.addActionListener(this);
        this.vistaNUsuarios.btnModificarMP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaNUsuarios.btnAgregar){
            
            try {
                modeloNUsuarios.setUsr_Nivel(vistaNUsuarios.txtNombre_NU.getText());
            modeloNUsuarios.setUsr_Descripcion(vistaNUsuarios.txtDescripcion_NU.getText());
            modeloNUsuarios.agregar(modeloNUsuarios);
            modeloNUsuarios.MostrarNusuarios(vistaNUsuarios);
            } catch (Exception ae) {
                  JOptionPane.showMessageDialog(null, "Ingrese datos para agregar");  

            }
            
        }if(e.getSource()==vistaNUsuarios.btnEliminar){
            try {
            modeloNUsuarios.eliminar(vistaNUsuarios);
            modeloNUsuarios.MostrarNusuarios(vistaNUsuarios);
        } catch (Exception ee) {
                  JOptionPane.showMessageDialog(null, "seleccione un dato de la tabla para eliminar");  
        }
            
        }if(e.getSource()==vistaNUsuarios.btnModificarMP){
            try {
            modeloNUsuarios.actualizar(vistaNUsuarios);
            modeloNUsuarios.MostrarNusuarios(vistaNUsuarios);
        } catch (Exception ie) {
        }
                  JOptionPane.showMessageDialog(null, "seleccione un dato de la tabla para editar");  
            
        }
            
            
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
