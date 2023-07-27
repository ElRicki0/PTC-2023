package Controlador;

import Modelo.EmpleadosM;
import Vista.VEmpleados;
import Vista.VNEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.ThaiBuddhistEra;
import javax.swing.JOptionPane;


public class ctrlEmpleado implements ActionListener{

    private VEmpleados vistaEmpleado;
    private EmpleadosM modeloEmpleado; 
    
    
    
    public ctrlEmpleado(VEmpleados vistaEmpleado, EmpleadosM modeloEmpleado){
        this.vistaEmpleado=vistaEmpleado;
        this.modeloEmpleado=modeloEmpleado;
        this.vistaEmpleado.btnAgregar.addActionListener(this);
        this.vistaEmpleado.btnEliminar.addActionListener(this);
        this.vistaEmpleado.btnModificarMP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==vistaEmpleado.btnAgregar){
//            try {
//                System.out.println("clic en ctrlempleado");
//                modeloEmpleado.setEmp_nombre(vistaEmpleado.txtNombre_emp.getText());
//                modeloEmpleado.setEmp_fecha(vistaEmpleado.txtFN_emp.getText());
//                modeloEmpleado.setEmp_direccion(vistaEmpleado.txtDireccion_emp.getText());
//                modeloEmpleado.setEmp_telefono(vistaEmpleado.txtTelefono_emp.getText());
//                modeloEmpleado.setEmp_correo(vistaEmpleado.txtCorreo_emp.getText());
//                modeloEmpleado.setIdGenero(vistaEmpleado.jcbGenero.getSelectedItem().toString());
//                modeloEmpleado.setEmp_nombre(vistaEmpleado.jcbTipo.getSelectedItem().toString());
//                
//                modeloEmpleado.MAgregarEmpleado(modeloEmpleado);
//                modeloEmpleado.MostrarEmpleados(vistaEmpleado);
//            } catch (Exception ae) {
//            JOptionPane.showMessageDialog(null, "ERROR EN EL control empleado "+ae.toString());  
//            }
//        }
          if(e.getSource()==vistaEmpleado.btnEliminar){
              try {
                  modeloEmpleado.eliminar(vistaEmpleado);
              modeloEmpleado.MostrarEmpleados(vistaEmpleado);
              } catch (Exception ae) {
                  JOptionPane.showMessageDialog(null, "Seleccione un empleado para eliminar");  
              }
              
          }if(e.getSource()==vistaEmpleado.btnModificarMP){
              try {
            System.out.println("se da clic");
              
              modeloEmpleado.actualizar(vistaEmpleado);
              modeloEmpleado.MostrarEmpleados(vistaEmpleado);
        } catch (Exception ee) {
                  JOptionPane.showMessageDialog(null, "Seleccione un empleado para modificar");  
        }
              
          }             

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
