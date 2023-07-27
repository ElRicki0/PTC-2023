package Controlador;

import Modelo.TiposEmpleados;
import Vista.VNEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTEmpleados implements ActionListener{

    private VNEmpleados vistaTEmpleados;
    private TiposEmpleados modeloTEmpleados;
    
    public ctrlTEmpleados(VNEmpleados vistaTEmpleados, TiposEmpleados modeloTEmpleados){
        this.vistaTEmpleados=vistaTEmpleados;
        this.modeloTEmpleados=modeloTEmpleados;
        this.vistaTEmpleados.btnAgregar.addActionListener(this);
        this.vistaTEmpleados.btnEliminar.addActionListener(this);
        this.vistaTEmpleados.btnModificarMP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaTEmpleados.btnAgregar){
            String texto = vistaTEmpleados.txtNombre_TE.getText();
            String texto1 = vistaTEmpleados.txtDescripcion_TE.getText();
            if (!texto.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");                                 
            }else{
                if (!texto1.matches("[a-z A-Z]+")) {                     
                    JOptionPane.showMessageDialog(null, "La descripcion solo pueden ir letras");                                 
                   
                } else {
                
                    modeloTEmpleados.setTipo_Emp(vistaTEmpleados.txtNombre_TE.getText());
                    modeloTEmpleados.setDescripcion_Emp(vistaTEmpleados.txtDescripcion_TE.getText());
                    modeloTEmpleados.agregar(modeloTEmpleados);
                    modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
                }                
            }            
        }if(e.getSource()==vistaTEmpleados.btnEliminar){
            modeloTEmpleados.eliminar(vistaTEmpleados);
            modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
        }if(e.getSource()==vistaTEmpleados.btnModificarMP){
            modeloTEmpleados.actualizar(vistaTEmpleados);
            modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
        }
            
            
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
